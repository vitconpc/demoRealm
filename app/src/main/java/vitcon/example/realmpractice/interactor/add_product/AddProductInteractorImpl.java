package vitcon.example.realmpractice.interactor.add_product;

import vitcon.example.realmpractice.common.Database;
import vitcon.example.realmpractice.model.Category;

public class AddProductInteractorImpl implements AddProductInteractor {

    @Override
    public void loadCategory(AddProductCallback callback) {
        callback.loadAllCategorySuccess(Database.getAllCategory());
    }

    @Override
    public void addProduct(String name, int number, long price, String description, Category category,AddProductCallback callback) {
        Database.saveProduct(name,number,price,description,category);
        callback.loadAllProductSuccess(Database.getAllProduct());
    }

    @Override
    public void loadProduct(AddProductCallback callback) {
        callback.loadAllProductSuccess(Database.getAllProduct());
    }
}
