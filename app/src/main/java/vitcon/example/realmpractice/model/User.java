package vitcon.example.realmpractice.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class User extends RealmObject {
    private int mId;
    private String mUserName;
    private String mNumberPhone;
    private RealmList<Bill> mBills;

    public User() {
        mBills = new RealmList<>();
    }

    public User(int id, String userName, String numberPhone) {
        mId = id;
        mUserName = userName;
        mNumberPhone = numberPhone;
        mBills = new RealmList<>();
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
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
