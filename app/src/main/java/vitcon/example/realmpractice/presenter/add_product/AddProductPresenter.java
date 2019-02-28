package vitcon.example.realmpractice.presenter.add_product;

import vitcon.example.realmpractice.model.Category;

public interface AddProductPresenter {
    void loadCategorry();

    void addProduct(String name, String number, String price, String description, Category category);

    void loadProducts();
}
