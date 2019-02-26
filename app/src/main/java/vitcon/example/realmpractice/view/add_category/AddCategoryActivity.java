package vitcon.example.realmpractice.view.add_category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import vitcon.example.realmpractice.R;
import vitcon.example.realmpractice.presenter.add_category.AddCategoryPresenter;
import vitcon.example.realmpractice.presenter.add_category.AddCategoryPresenterImpl;

public class AddCategoryActivity extends AppCompatActivity implements AddCategoryView {

    private EditText mEditCategoryName;
//    private RecyclerView mRvCategories;
    private AddCategoryPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        initView();
        initData();
    }

    private void initData() {
        mPresenter = new AddCategoryPresenterImpl(this,this);
    }

    private void initView() {
        mEditCategoryName = findViewById(R.id.edt_category_name);
    }

    public void addCategory(View view) {
        mPresenter.addCategory(mEditCategoryName.getText().toString().trim());
    }

    @Override
    public void showError(String empty_enter_error) {
        Toast.makeText(this, empty_enter_error, Toast.LENGTH_SHORT).show();
    }
}
