package vitcon.example.realmpractice.presenter.add_product;

import android.content.Context;

import io.realm.RealmResults;
import vitcon.example.realmpractice.interactor.add_product.AddProductCallback;
import vitcon.example.realmpractice.interactor.add_product.AddProductInteractor;
import vitcon.example.realmpractice.interactor.add_product.AddProductInteractorImpl;
import vitcon.example.realmpractice.model.Category;
import vitcon.example.realmpractice.view.add_product.AddProductView;

public class AddProductPresenterImpl implements AddProductPresenter {

    private Context mContext;
    private AddProductView mView;
    private AddProductInteractor mInteractor;

    public AddProductPresenterImpl(Context context, AddProductView view) {
        mContext = context;
        mView = view;
        mInteractor = new AddProductInteractorImpl();
    }

    @Override
    public void loadCategorry() {
        mInteractor.loadCategory(new AddProductCallback() {
            @Override
            public void loadAllCategorySuccess(RealmResults<Category> categories) {
                //todo show to view categories
                mView.setSpinnerCategories(categories);
            }
        });
    }

    @Override
    public void addProduct(String name, String number, String price, String description, Category category) {

    }
}
