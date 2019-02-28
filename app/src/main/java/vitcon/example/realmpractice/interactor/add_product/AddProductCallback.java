package vitcon.example.realmpractice.interactor.add_product;

import io.realm.RealmResults;
import vitcon.example.realmpractice.model.Category;
import vitcon.example.realmpractice.model.Product;

public interface AddProductCallback {
    void loadAllCategorySuccess(RealmResults<Category> categories);

    void loadAllProductSuccess(RealmResults<Product> allProduct);
}
