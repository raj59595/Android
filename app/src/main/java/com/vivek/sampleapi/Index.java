package com.vivek.sampleapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Index extends AppCompatActivity {

    RecyclerView jsonlist;
    private TextView responseText;
    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        jsonlist = (RecyclerView) findViewById(R.id.jsonlist);
        getProducts();
    }

    private void getProducts(){
        Call<JsonObject> productListCall  =   APIClient.getRetrofitService().getProductlist();
        productListCall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response){

                if(response.isSuccessful()){
                    JsonObject jsonObject = response.body();

                    products = new Gson().fromJson(jsonObject.getAsJsonArray("products"),new TypeToken<List<Product>>() {}.getType());
                    setProductsToAdapter();
                    // Show the products on the screen

                    String name = products.get(0).getName();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
               // Toast.makeText(Index.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setProductsToAdapter()
    {
        // Add products to a adapter
        // Add adapter to the recycler view
       // jsonlist.setHasFixedSize(true);
        jsonlist.setLayoutManager(new LinearLayoutManager(this));

        jsonlist.setAdapter(new NewAdapter(products,this));
        jsonlist.getAdapter().notifyDataSetChanged();


    }
}
