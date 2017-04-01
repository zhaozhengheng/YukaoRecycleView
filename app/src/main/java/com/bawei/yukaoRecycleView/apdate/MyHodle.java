package com.bawei.yukaoRecycleView.apdate;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.yukaoRecycleView.R;

/**
 * Created by 1 on 2017/4/1.
 */
public class MyHodle  extends RecyclerView.ViewHolder
{
    public ImageView mImageView;
    public TextView right;
    public MyHodle(View itemView) {
        super(itemView);
         mImageView = (ImageView) itemView.findViewById(R.id.ImageView);
         right = (TextView) itemView.findViewById(R.id.TextView_right);

    }
}
