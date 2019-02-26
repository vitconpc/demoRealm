package vitcon.example.realmpractice.presenter.add_category;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import vitcon.example.realmpractice.interactor.add_category.AddCategoryCallback;
import vitcon.example.realmpractice.interactor.add_category.AddCategoryInteractor;
import vitcon.example.realmpractice.interactor.add_category.AddCategoryInteractorImpl;
import vitcon.example.realmpractice.view.add_category.AddCategoryView;

public class AddCategoryPresenterImpl implements AddCategoryPresenter {

    private Context mContext;
    private AddCategoryView mAddCategoryView;
    private AddCategoryInteractor mInteractor;

    public AddCategoryPresenterImpl(Context context, AddCategoryView addCategoryView) {
        mContext = context;
        mAddCategoryView = addCategoryView;
        mInteractor = new AddCategoryInteractorImpl();
    }

    @Override
    public void addCategory(String name) {
        if (!TextUtils.isEmpty(name)){
            mInteractor.addCategory(name, new AddCategoryCallback() {
                @Override
                public void success(String s) {
                    mAddCategoryView.showError(s);
                    Log.d("vitcon", "success: "+ s);
                }
            });
        }else {
            mAddCategoryView.showError("Empty Enter Error");
        }
    }
}
