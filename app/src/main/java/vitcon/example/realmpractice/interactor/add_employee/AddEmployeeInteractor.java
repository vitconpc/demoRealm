package vitcon.example.realmpractice.interactor.add_employee;

public interface AddEmployeeInteractor {
    void getAllEmployee(AddEmployeeCallback callback);

    void addEmplyees(String name, String address, String phoneNumber, boolean isMale, AddEmployeeCallback callback);
}
