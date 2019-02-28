package vitcon.example.realmpractice.view.add_product;

import io.realm.RealmResults;
import vitcon.example.realmpractice.model.Category;

public interface AddProductView {
    void setSpinnerCategories(RealmResults<Category> categories);

    void showError(String empty_enter_product_name);

    void setResult(String s);
}
