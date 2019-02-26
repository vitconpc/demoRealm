package vitcon.example.realmpractice.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Category extends RealmObject {
    private int mId;
    private String mCategoryName;
    private RealmList<Product> mProducts;

    public Category(int id, String categoryName) {
        mId = id;
        mCategoryName = categoryName;
        mProducts = new RealmList<>();
    }

    public Category() {
        mProducts = new RealmList<>();
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setCategoryName(String categoryName) {
        mCategoryName = categoryName;
    }

    public RealmList<Product> getProducts() {
        return mProducts;
    }

    public void setProducts(RealmList<Product> products) {
        mProducts = products;
    }
}

