package com.anirudh.codingchallenge;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Anirudh on 2/5/18.
 */

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.MyViewHolder>
{

    private List<Guide> guides;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mName, mCity, mState, mEndDate;
        public ImageView mImage;

        public MyViewHolder(View view)
        {
            super(view);
            mName = (TextView) view.findViewById(R.id.name_text);
            mCity = (TextView) view.findViewById(R.id.city_text);
            mState = (TextView) view.findViewById(R.id.state_text);
            mEndDate = (TextView) view.findViewById(R.id.end_date_text);
            mImage = (ImageView) view.findViewById(R.id.image_view);
        }
    }


    public GuideAdapter(List<Guide> guides)
    {
        this.guides = guides;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.guide_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        Guide guide = guides.get(position);
        holder.mName.setText(    "Name: " + guide.getName());
        holder.mCity.setText(    "City: " + guide.getCity());
        holder.mState.setText(   "State: " + guide.getState());
        holder.mEndDate.setText( "End Date: " + guide.getEndDate());
        //Log.d(TAG, guide.getUrlToImg());
        Picasso.with(holder.mName.getContext()).load(guide.getUrlToImg()).into(holder.mImage);
    }

    @Override
    public int getItemCount()
    {
        return guides.size();
    }
}
