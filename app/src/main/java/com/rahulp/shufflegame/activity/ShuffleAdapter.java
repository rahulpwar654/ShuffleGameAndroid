package com.rahulp.shufflegame.activity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Rahul on 1/20/2015.
 */
public class ShuffleAdapter extends BaseAdapter {

    Context context;
    int nums;

    ShuffleAdapter(Context context,int nums)
    {
        this.nums=nums;
        this.context=context;

    }



    @Override
    public int getCount() {
        return 0;
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

        TextView textView;

        if(convertView==null) {

            textView=new TextView(context);
            textView.setTextColor(Color.RED);


        }
        else{
            textView=(TextView)convertView;
        }
        return textView;

    }
}
