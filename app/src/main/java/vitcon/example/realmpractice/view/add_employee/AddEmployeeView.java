package vitcon.example.realmpractice.view.add_employee;

import io.realm.RealmResults;
import vitcon.example.realmpractice.model.Employee;

public interface AddEmployeeView {
    void showAllEmployees(String s);

    void showError(String empty_enter_phone_number);
}
