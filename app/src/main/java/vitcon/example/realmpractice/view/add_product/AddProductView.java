package vitcon.example.realmpractice.view.add_product;

import io.realm.RealmResults;
import vitcon.example.realmpractice.model.Category;

public interface AddProductView {
    void setSpinnerCategories(RealmResults<Category> categories);
}
