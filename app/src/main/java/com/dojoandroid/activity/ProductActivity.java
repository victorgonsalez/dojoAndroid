package com.dojoandroid.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.dojoandroid.activity.R;
import com.dojoandroid.adapter.ProductsAdapter;
import com.dojoandroid.entity.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        ListView listView = (ListView) findViewById(R.id.list_product);

        List<Product> productList = new ArrayList<>();
        Product product = new Product();
        product.name = "Geladeira";
        product.price = 1200;
        product.status = true;
        productList.add(product);

        Product product2 = new Product();
        product2.name = "Fogão";
        product2.price = 809;
        product2.status = false;
        productList.add(product2);

        Product product3 = new Product();
        product3.name = "Toalha";
        product3.price = 509;
        product3.status = true;
        productList.add(product3);

        ProductsAdapter productsAdapter = new ProductsAdapter(this, productList);
        listView.setAdapter(productsAdapter);
    }
}

