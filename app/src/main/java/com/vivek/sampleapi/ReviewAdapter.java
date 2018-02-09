package com.vivek.sampleapi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by specter on 2/9/18.
 */

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.jsonViewHolder> {

    private List<Review> reviews;
    public  ReviewAdapter(List<Review> reviews)
    {
        this.reviews = reviews;

    }

    @Override
    public jsonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.review_item, parent, false);
        return new ReviewAdapter.jsonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewAdapter.jsonViewHolder holder, int position)
    {
        Review review = reviews.get(position);
        holder.username.setText(review.user);
        holder.ratings.setText(String.valueOf(review.rating));
        holder.body.setText(review.body);
    }

    @Override
    public int getItemCount()
    {
        return reviews.size();
    }

    public class jsonViewHolder extends RecyclerView.ViewHolder
    {
        TextView username;
        TextView ratings;
        TextView body;

        public jsonViewHolder(View itemView)
        {
            super(itemView);
            username= (TextView) itemView.findViewById(R.id.username);
            ratings= (TextView) itemView.findViewById(R.id.ratings);
            body= (TextView) itemView.findViewById(R.id.body);
        }
    }

}
