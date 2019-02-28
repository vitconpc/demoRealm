package vitcon.example.realmpractice.common;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import vitcon.example.realmpractice.model.Category;
import vitcon.example.realmpractice.model.Employee;
import vitcon.example.realmpractice.model.Product;

public class Database {
    private static Realm sRealm;

    public static void inItRealm(Context context) {
        if (sRealm == null || sRealm.isClosed()) {
            sRealm.init(context);
            sRealm = Realm.getInstance(new RealmConfiguration.Builder().name(Constants.DATABASE_NAME)
//                    .deleteRealmIfMigrationNeeded()
                    .build());
        }
        return;
    }

    public static void saveCategory(final String nameCategory) {
        sRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Number currentId = realm.where(Category.class).max("mId");
                int nextId;
                if (currentId == null) {
                    nextId = 1;
                } else {
                    nextId = currentId.intValue() + 1;
                }
                Category category = new Category(nextId, nameCategory);
                realm.insertOrUpdate(category);
            }
        });
    }

    public static RealmResults<Category> getAllCategory() {
        return sRealm.where(Category.class).findAll();
    }

    public static void saveProduct(final String name, final int number, final long price, final String des, final Category category) {
        sRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Number currentId = sRealm.where(Product.class).max("mId");
                int nextID = 1;
                if (currentId != null) {
                    nextID = currentId.intValue() + 1;
                }

                Product product = sRealm.createObject(Product.class, nextID);
                product.setProductName(name);
                product.setDescription(des);
                product.setTotalCount(number);
                product.setPrice(price);
                Category category1 = sRealm.where(Category.class).equalTo("mId", category.getId()).findFirst();
                category1.addProduct(product);
            }
        });
    }

    public static RealmResults<Product> getAllProduct() {
        return sRealm.where(Product.class).findAll();
    }

    public static RealmResults<Employee> getAllEmployees() {
        return sRealm.where(Employee.class).findAll();
    }

    public static void saveEmployee(final String name, final String address, final String phoneNumber, final boolean isMale) {
        sRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                int nextId = 1;
                Number curentID = sRealm.where(Employee.class).max("mId");
                if (curentID != null) {
                    nextId = curentID.intValue() + 1;
                }
                Employee employee = new Employee(nextId, name, isMale, address, phoneNumber);
                sRealm.insertOrUpdate(employee);
            }
        });
    }
}
