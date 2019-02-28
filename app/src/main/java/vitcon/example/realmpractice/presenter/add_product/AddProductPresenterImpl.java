package vitcon.example.realmpractice.presenter.add_product;

import android.content.Context;
import android.text.TextUtils;

import io.realm.RealmResults;
import vitcon.example.realmpractice.interactor.add_product.AddProductCallback;
import vitcon.example.realmpractice.interactor.add_product.AddProductInteractor;
import vitcon.example.realmpractice.interactor.add_product.AddProductInteractorImpl;
import vitcon.example.realmpractice.model.Category;
import vitcon.example.realmpractice.model.Product;
import vitcon.example.realmpractice.view.add_product.AddProductView;

public class AddProductPresenterImpl implements AddProductPresenter, AddProductCallback {

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
        mInteractor.loadCategory(this);
    }

    @Override
    public void addProduct(String name, String number, String price, String description, Category category) {
        int num = Integer.valueOf(number);
        long pri = Long.valueOf(price);
        if (TextUtils.isEmpty(name)) {
            mView.showError("Empty Enter Product Name ");
            return;
        }
        if (TextUtils.isEmpty(number)) {
            mView.showError("Empty Enter Product Number");
            return;
        }
        if (TextUtils.isEmpty(price)) {
            mView.showError("Empty Enter Product Price");
            return;
        }
        mInteractor.addProduct(name, num, pri, description, category, this);
    }

    @Override
    public void loadAllCategorySuccess(RealmResults<Category> categories) {
        //todo show to view categories
        mView.setSpinnerCategories(categories);
    }

    @Override
    public void loadAllProductSuccess(RealmResults<Product> allProduct) {
        //todo show to view product
        String s = "";
        for (int i = 0; i < allProduct.size(); i++) {
            s += allProduct.get(i).getProductName() + "\n";
            s += allProduct.get(i).getTotalCount() + "\n";
            s += allProduct.get(i).getPrice() + "\n";
            s += allProduct.get(i).getDescription() + "\n";
            s += allProduct.get(i).getCategories().first().getCategoryName() + "\n";
            s += "\n";
        }
        mView.setResult(s);
    }

    @Override
    public void loadProducts() {
        mInteractor.loadProduct(this);
    }
}
