package vitcon.example.realmpractice.view.add_product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;
import vitcon.example.realmpractice.R;
import vitcon.example.realmpractice.common.adapter.SpinnerCategoriesAdapter;
import vitcon.example.realmpractice.model.Category;
import vitcon.example.realmpractice.presenter.add_product.AddProductPresenter;
import vitcon.example.realmpractice.presenter.add_product.AddProductPresenterImpl;

public class AddProductActivity extends AppCompatActivity implements View.OnClickListener, AddProductView {

    private EditText mTextProductName;
    private EditText mTextNumber;
    private EditText mTextPrice;
    private EditText mTextDescription;
    private Spinner mSpinnerCategories;
    private SpinnerCategoriesAdapter mSpinnerCategoriesAdapter;
    private List<Category> mCategories;
    private TextView mTextProducts;

    private AddProductPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        ititViewAndData();
    }

    private void ititViewAndData() {
        mTextDescription = findViewById(R.id.text_description);
        mTextProductName = findViewById(R.id.text_product_name);
        mTextNumber = findViewById(R.id.text_product_number);
        mTextPrice = findViewById(R.id.text_product_price);
        mSpinnerCategories = findViewById(R.id.sp_category);
        mTextProducts = findViewById(R.id.text_products);
        mCategories = new ArrayList<>();
        mSpinnerCategoriesAdapter = new SpinnerCategoriesAdapter(mCategories, this);
        mSpinnerCategories.setAdapter(mSpinnerCategoriesAdapter);
        findViewById(R.id.btn_add_product).setOnClickListener(this);
        mPresenter = new AddProductPresenterImpl(this,this);
        loadData();

    }

    private void loadData() {
        mPresenter.loadCategorry();
        mPresenter.loadProducts();
    }

    @Override
    public void onClick(View v) {
        mPresenter.addProduct(mTextProductName.getText().toString().trim(), mTextNumber.getText().toString().trim(), mTextPrice.getText().toString().trim()
                , mTextDescription.getText().toString().trim(), (Category) mSpinnerCategories.getSelectedItem());
    }

    @Override
    public void setSpinnerCategories(RealmResults<Category> categories) {
        mCategories.clear();
        mCategories.addAll(categories);
        mSpinnerCategoriesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String empty_enter_product_name) {
        Toast.makeText(this, empty_enter_product_name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setResult(String s) {
        mTextProducts.setText(s);
    }
}
