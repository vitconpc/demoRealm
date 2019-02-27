package vitcon.example.realmpractice.common;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import vitcon.example.realmpractice.model.Category;

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
}
