package vitcon.example.realmpractice.view.add_employee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import vitcon.example.realmpractice.R;
import vitcon.example.realmpractice.presenter.add_employee.AddEmployeePresenter;
import vitcon.example.realmpractice.presenter.add_employee.AddEmployeePresenterImpl;

public class AddEmployeeActivity extends AppCompatActivity implements View.OnClickListener, AddEmployeeView {

    private EditText mTextName;
    private EditText mTextAddress;
    private EditText mTextPhoneNumber;
    private RadioButton mRbMale;
    private RadioButton mRbFemale;
    private TextView mTextEmployees;
    private AddEmployeePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        initViewAndData();
        loadData();
    }

    private void loadData() {
        mPresenter.loadData();
    }

    private void initViewAndData() {
        mTextName = findViewById(R.id.text_employee_name);
        mTextAddress = findViewById(R.id.text_address);
        mTextPhoneNumber = findViewById(R.id.text_number_phone);
        mRbMale = findViewById(R.id.rb_male);
        mRbFemale = findViewById(R.id.rb_female);
        mTextEmployees = findViewById(R.id.text_employees);
        mRbMale.setChecked(true);
        findViewById(R.id.btn_add_employee).setOnClickListener(this);

        mPresenter = new AddEmployeePresenterImpl(this,this);
    }

    @Override
    public void onClick(View v) {
        boolean isMale = false;
        if (mRbMale.isChecked()){
            isMale = true;
        }
        mPresenter.addEmployee(mTextName.getText().toString().trim(),mTextAddress.getText().toString().trim(),mTextPhoneNumber.getText().toString().trim(),isMale);
    }

    @Override
    public void showAllEmployees(String s) {
        mTextEmployees.setText(s);
    }

    @Override
    public void showError(String empty_enter_phone_number) {
        Toast.makeText(this, empty_enter_phone_number, Toast.LENGTH_SHORT).show();
    }
}
