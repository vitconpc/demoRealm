package vitcon.example.realmpractice.interactor.add_category;

import vitcon.example.realmpractice.common.Database;

public class AddCategoryInteractorImpl implements AddCategoryInteractor {

    @Override
    public void addCategory(String nameCategory,AddCategoryCallback callback) {
        Database.saveCategory(nameCategory);
        String s = Database.getAllCategory();
        callback.success(s);
    }
}
