package vitcon.example.realmpractice.model;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;

public class BillDetail extends RealmObject {
    private Product mProduct;
    private int mCount;
    private long mPriceTotal;
    @LinkingObjects("mDetails")
    private final RealmResults<Bill> mBills = null;

    public BillDetail() {
    }

    public Product getProduct() {
        return mProduct;
    }

    public void setProduct(Product product) {
        mProduct = product;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        mCount = count;
    }

    public long getPriceTotal() {
        return mPriceTotal;
    }

    public void setPriceTotal(long priceTotal) {
        mPriceTotal = priceTotal;
    }

    public RealmResults<Bill> getBills() {
        return mBills;
    }
}
