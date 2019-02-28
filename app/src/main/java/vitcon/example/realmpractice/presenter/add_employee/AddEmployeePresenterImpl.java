package vitcon.example.realmpractice.presenter.add_employee;

import android.content.Context;
import android.text.TextUtils;

import io.realm.RealmResults;
import vitcon.example.realmpractice.interactor.add_employee.AddEmployeeCallback;
import vitcon.example.realmpractice.interactor.add_employee.AddEmployeeInteractor;
import vitcon.example.realmpractice.interactor.add_employee.AddEmployeeInteractorImpl;
import vitcon.example.realmpractice.model.Employee;
import vitcon.example.realmpractice.view.add_employee.AddEmployeeView;

public class AddEmployeePresenterImpl implements AddEmployeePresenter, AddEmployeeCallback {

    private Context mContext;
    private AddEmployeeView mView;
    private AddEmployeeInteractor mInteractor;

    public AddEmployeePresenterImpl(Context context, AddEmployeeView view) {
        mContext = context;
        mView = view;
        mInteractor = new AddEmployeeInteractorImpl();
    }

    @Override
    public void loadData() {
        mInteractor.getAllEmployee(this);
    }

    @Override
    public void loadAllEmployees(RealmResults<Employee> allEmployees) {
        String s = "";
        for (int i = 0; i < allEmployees.size(); i++) {
            s+= allEmployees.get(i).getEmployeeName()+" : " + allEmployees.get(i).getAddress() + " : " + allEmployees.get(i).getNumberPhone() +
                    " : " + allEmployees.get(i).isSex() + "\n";
        }
        mView.showAllEmployees(s);
    }

    @Override
    public void addEmployee(String name, String address, String phoneNumber, boolean isMale) {
        if (TextUtils.isEmpty(name)){
            mView.showError("Empty enter name");
            return;
        }
        if (TextUtils.isEmpty(address)){
            mView.showError("Empty enter address");
            return;
        }
        if (TextUtils.isEmpty(phoneNumber)){
            mView.showError("Empty enter Phone Number");
            return;
        }
        mInteractor.addEmplyees(name,address,phoneNumber,isMale,this);
    }

    @Override
    public void afterAdd() {
        loadData();
    }
}
