package vitcon.example.realmpractice.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class Bill extends RealmObject {
    @PrimaryKey
    private int mId;
    private RealmList<BillDetail> mDetails;
    private String mTimeSale;
    private long mTotal;
    @LinkingObjects("mBills")
    private final RealmResults<User> mUsers = null;
    @LinkingObjects("mBills")
    private final RealmResults<Employee> mEmployees = null;

    public Bill() {
        mDetails = new RealmList<>();
    }

    public Bill(int id, String timeSale, long total) {
        mId = id;
        mTimeSale = timeSale;
        mTotal = total;
        mDetails = new RealmList<>();
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public RealmList<BillDetail> getDetails() {
        return mDetails;
    }

    public void setDetails(RealmList<BillDetail> details) {
        mDetails = details;
    }

    public String getTimeSale() {
        return mTimeSale;
    }

    public void setTimeSale(String timeSale) {
        mTimeSale = timeSale;
    }

    public long getTotal() {
        return mTotal;
    }

    public void setTotal(long total) {
        mTotal = total;
    }

    public RealmResults<User> getUsers() {
        return mUsers;
    }

    public RealmResults<Employee> getEmployees() {
        return mEmployees;
    }
}
