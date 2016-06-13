package com.dojoandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dojoandroid.activity.R;
import com.dojoandroid.entity.Product;

import java.util.List;


/**
 * Created by vgonsalez on 6/13/16.
 */
public class ProductsAdapter extends BaseAdapter {

    private List<Product> mProductList;
    private Context mContext;

    public ProductsAdapter(Context context, List<Product> productList) {
        mContext = context;
        mProductList = productList;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view_products, parent, false);
        }

        TextView priceText = (TextView) convertView.findViewById(R.id.product_price);
        TextView nameText = (TextView) convertView.findViewById(R.id.product_name);
        ImageView statusImage = (ImageView) convertView.findViewById(R.id.product_status);

        priceText.setText("" + mProductList.get(position).price);
        nameText.setText(mProductList.get(position).name);

        statusImage.setImageResource(mProductList.get(position).status ? R.drawable.success : R.drawable.error);

        return convertView;
    }
}
