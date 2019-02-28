package vitcon.example.realmpractice.interactor.add_employee;

import io.realm.RealmResults;
import vitcon.example.realmpractice.model.Employee;

public interface AddEmployeeCallback {
    void loadAllEmployees(RealmResults<Employee> allEmployees);

    void afterAdd();
}
