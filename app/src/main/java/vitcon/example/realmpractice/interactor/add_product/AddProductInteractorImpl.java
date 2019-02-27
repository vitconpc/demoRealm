package vitcon.example.realmpractice.interactor.add_product;

import vitcon.example.realmpractice.common.Database;

public class AddProductInteractorImpl implements AddProductInteractor {

    @Override
    public void loadCategory(AddProductCallback callback) {
        callback.loadAllCategorySuccess(Database.getAllCategory());
    }
}
