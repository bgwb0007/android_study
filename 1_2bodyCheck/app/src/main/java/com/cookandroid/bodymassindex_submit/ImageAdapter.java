package com.cookandroid.bodymassindex_submit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Integer> mThumblds=null;

    public ImageAdapter(Context c, ArrayList<Integer> mThumblds){
        mContext=c;
        this.mThumblds=mThumblds;
    }

    @Override
    public int getCount() {
        return mThumblds.size();
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
        ImageView i=new ImageView(mContext);
        i.setImageResource(mThumblds.get(position));
        i.setLayoutParams(new Gallery.LayoutParams(600,600));
        i.setScaleType(ImageView.ScaleType.FIT_XY);
        return i;
    }
}
