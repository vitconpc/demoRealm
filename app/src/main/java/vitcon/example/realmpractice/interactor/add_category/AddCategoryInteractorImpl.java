package vitcon.example.realmpractice.interactor.add_category;

import io.realm.RealmResults;
import vitcon.example.realmpractice.common.Database;
import vitcon.example.realmpractice.model.Category;

public class AddCategoryInteractorImpl implements AddCategoryInteractor {

    @Override
    public void addCategory(String nameCategory,AddCategoryCallback callback) {
        Database.saveCategory(nameCategory);
        RealmResults<Category> categories = Database.getAllCategory();
        String s = "";
        for (int i = 0; i < categories.size(); i++) {
            s+= categories.get(i).getId()+" : "+categories.get(i).getCategoryName() + "\n";
        }
        callback.success(s);
    }
}
