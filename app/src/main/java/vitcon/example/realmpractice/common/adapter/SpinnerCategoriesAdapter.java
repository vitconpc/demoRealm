package vitcon.example.realmpractice.common.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vitcon.example.realmpractice.R;
import vitcon.example.realmpractice.model.Category;

public class SpinnerCategoriesAdapter extends BaseAdapter {

    private List<Category> mCategories;
    private Context mContext;

    public SpinnerCategoriesAdapter(List<Category> categories, Context context) {
        mCategories = categories;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mCategories == null ? 0 : mCategories.size();
    }

    @Override
    public Category getItem(int position) {
        return mCategories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textId;
        TextView textCategoryName;
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_spinner_category_item,parent,false);
        textId = view.findViewById(R.id.text_id);
        textCategoryName = view.findViewById(R.id.text_category_name);
        textId.setText(getItem(position).getId()+"");
        textCategoryName.setText(getItem(position).getCategoryName());
        return view;
    }
}
