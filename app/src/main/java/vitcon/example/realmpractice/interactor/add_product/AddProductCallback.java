package vitcon.example.realmpractice.interactor.add_product;

import io.realm.RealmResults;
import vitcon.example.realmpractice.model.Category;

public interface AddProductCallback {
    void loadAllCategorySuccess(RealmResults<Category> categories);
}
