package vitcon.example.realmpractice.common;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import vitcon.example.realmpractice.model.Category;

public class Database {
    private static Realm sRealm;

    public static void inItRealm(Context context) {
        sRealm.getInstance(new RealmConfiguration.Builder().name(Constants.DATABASE_NAME).build());
        if (sRealm == null || sRealm.isClosed()) {
            sRealm.init(context);
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

    public static String getAllCategory() {
        String s = "";
        RealmResults<Category> realmResults = sRealm.where(Category.class).findAll();
        for (Category category : realmResults) {
            s += category.getId() + " : " + category.getCategoryName() + "\n";
        }
        return s;
    }
}
