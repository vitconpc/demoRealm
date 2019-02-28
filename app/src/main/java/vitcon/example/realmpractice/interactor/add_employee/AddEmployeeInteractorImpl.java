package vitcon.example.realmpractice.interactor.add_employee;

import vitcon.example.realmpractice.common.Database;

public class AddEmployeeInteractorImpl implements AddEmployeeInteractor {

    @Override
    public void getAllEmployee(AddEmployeeCallback callback) {
        callback.loadAllEmployees(Database.getAllEmployees());
    }

    @Override
    public void addEmplyees(String name, String address, String phoneNumber, boolean isMale, AddEmployeeCallback callback) {
        Database.saveEmployee(name,address,phoneNumber,isMale);
        callback.afterAdd();
    }
}
