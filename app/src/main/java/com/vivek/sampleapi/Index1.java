package com.vivek.sampleapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Index1 extends AppCompatActivity {


    RecyclerView rv1;
    private TextView responseText;
    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index1);
        rv1 = (RecyclerView) findViewById(R.id.rv_1);
        getProducts();
    }

    private void getProducts(){
        Call<List<Product>> productListCall  =   APIClient.getRetrofitService().getProductList();
        productListCall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response){

                if(response.isSuccessful()){
                    products = response.body();
                    setProductsToAdapter();
                    // Show the products on the screen

                    String name = products.get(0).getName();
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                // Toast.makeText(Index.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setProductsToAdapter()
    {
        // Add products to a adapter
        // Add adapter to the recycler view
        // jsonlist.setHasFixedSize(true);
        rv1.setLayoutManager(new LinearLayoutManager(this));
        rv1.setAdapter(new NewAdapter(products,this));
        rv1.getAdapter().notifyDataSetChanged();


    }
}
