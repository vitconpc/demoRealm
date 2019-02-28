package vitcon.example.realmpractice.interactor.add_product;

import vitcon.example.realmpractice.model.Category;

public interface AddProductInteractor {
    void loadCategory(AddProductCallback callback);

    void addProduct(String name, int number, long price, String description, Category category,AddProductCallback callback);

    void loadProduct(AddProductCallback callback);
}
