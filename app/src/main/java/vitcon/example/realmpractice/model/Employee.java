package vitcon.example.realmpractice.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Employee extends RealmObject {
    @PrimaryKey
    private int mId;
    private String mEmployeeName;
    private boolean mSex;
    private String mAddress;
    private String mNumberPhone;
    private RealmList<Bill> mBills;

    public Employee() {
        mBills = new RealmList<>();
    }

    public Employee(int id, String employeeName, boolean sex, String address, String numberPhone) {
        mId = id;
        mEmployeeName = employeeName;
        mSex = sex;
        mAddress = address;
        mNumberPhone = numberPhone;
        mBills = new RealmList<>();
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getEmployeeName() {
        return mEmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        mEmployeeName = employeeName;
    }

    public boolean isSex() {
        return mSex;
    }

    public void setSex(boolean sex) {
        mSex = sex;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getNumberPhone() {
        return mNumberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        mNumberPhone = numberPhone;
    }

    public RealmList<Bill> getBills() {
        return mBills;
    }

    public void setBills(RealmList<Bill> bills) {
        mBills = bills;
    }
}
