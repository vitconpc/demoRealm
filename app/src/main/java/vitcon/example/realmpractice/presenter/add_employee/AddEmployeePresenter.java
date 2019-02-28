package vitcon.example.realmpractice.presenter.add_employee;

public interface AddEmployeePresenter {
    void loadData();

    void addEmployee(String name, String address, String phoneNumber, boolean isMale);
}
