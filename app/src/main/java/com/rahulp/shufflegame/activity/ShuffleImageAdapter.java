package com.rahulp.shufflegame.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.rahulp.shufflegame.CustomImageView;
import com.rahulp.shufflegame.R;
import com.rahulp.shufflegame.util.SquareRelativeLayout;

import java.util.ArrayList;

/**
 * Created by warlord on 10/9/2017.
 */

public class ShuffleImageAdapter extends RecyclerView.Adapter<ShuffleImageAdapter.MyViewHolder>  {

    private Context mContext;
    private ArrayList<Bitmap> albumList;

    public ShuffleImageAdapter(Context mContext) {
        this.mContext = mContext;
        albumList=ShuffleImageActivity.albumList;
    }

    public ShuffleImageAdapter(Context mContext, ArrayList<Bitmap> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shuffleimage, parent, false);

        return new MyViewHolder(itemView);
        //return null;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.thumbnail.setImageBitmap(albumList.get(position));

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        if(albumList==null)
            return 0;
            else
        return albumList.size();
    }






    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public CustomImageView thumbnail, overflow;
        SquareRelativeLayout squareRelativeLayout;

        public MyViewHolder(View view) {
            super(view);

           thumbnail = (CustomImageView) view.findViewById(R.id.img_shuffle);
            squareRelativeLayout = (SquareRelativeLayout) view.findViewById(R.id.parentvirew);
            //overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }

}
