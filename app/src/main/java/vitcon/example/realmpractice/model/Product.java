package vitcon.example.realmpractice.model;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;

public class Product extends RealmObject {
    private int mId;
    private String mProductName;
    private int mTotalCount;
    private long mPrice;
    private String mDescription;
    @LinkingObjects("mProducts")
    private final RealmResults<Category> mCategories = null;

    public Product() {
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getProductName() {
        return mProductName;
    }

    public void setProductName(String productName) {
        mProductName = productName;
    }

    public int getTotalCount() {
        return mTotalCount;
    }

    public void setTotalCount(int totalCount) {
        mTotalCount = totalCount;
    }

    public long getPrice() {
        return mPrice;
    }

    public void setPrice(long price) {
        mPrice = price;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public RealmResults<Category> getCategories() {
        return mCategories;
    }
}
