package vitcon.example.realmpractice.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import vitcon.example.realmpractice.R;
import vitcon.example.realmpractice.common.Database;
import vitcon.example.realmpractice.view.add_bill_detail.AddBillDetailActivity;
import vitcon.example.realmpractice.view.add_category.AddCategoryActivity;
import vitcon.example.realmpractice.view.add_employee.AddEmployeeActivity;
import vitcon.example.realmpractice.view.add_product.AddProductActivity;
import vitcon.example.realmpractice.view.statistical.StatisticalActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        setEvent();
    }

    private void initData() {
        Database.inItRealm(this);
    }

    private void setEvent() {
        findViewById(R.id.btn_add_category).setOnClickListener(this);
        findViewById(R.id.btn_add_product).setOnClickListener(this);
        findViewById(R.id.btn_add_employee).setOnClickListener(this);
        findViewById(R.id.btn_add_contract).setOnClickListener(this);
        findViewById(R.id.btn_statistical).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_category: {
                Intent intent = new Intent(this, AddCategoryActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btn_add_product: {
                Intent intent = new Intent(this, AddProductActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btn_add_employee: {
                Intent intent = new Intent(this, AddEmployeeActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btn_add_contract: {
                Intent intent = new Intent(this, AddBillDetailActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btn_statistical: {
                Intent intent = new Intent(this, StatisticalActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}
