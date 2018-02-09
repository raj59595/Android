package com.vivek.sampleapi;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by specter on 2/8/18.
 */

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.jsonViewHolder>
{

    private List<Product> data;
    private Context context;
    public  NewAdapter(List<Product> data, Context context)
    {
        this.data = data;
        this.context= context;

    }
    @Override
    public jsonViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.json_item, parent, false);
        return new jsonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(jsonViewHolder holder, int position)
    {
        Product product = data.get(position);
        holder.txtTitle.setText(product.name);
        holder.txtDetails.setText(product.price);
        List<Review> reviews = product.reviews;
        holder.reviewlist.setLayoutManager(new LinearLayoutManager(context));
        holder.reviewlist.setAdapter(new ReviewAdapter(reviews));
        holder.reviewlist.getAdapter().notifyDataSetChanged();

    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    public class jsonViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtTitle;
        TextView txtDetails;
        LinearLayout layout1;
        RecyclerView reviewlist;
        public jsonViewHolder(View itemView)
        {
            super(itemView);
            txtTitle= (TextView) itemView.findViewById(R.id.txtTitle);
            txtDetails= (TextView) itemView.findViewById(R.id.txtDetails);
            layout1= (LinearLayout) itemView.findViewById(R.id.layout1);
            reviewlist = (RecyclerView) itemView.findViewById(R.id.reviewlist);
        }
    }
}
