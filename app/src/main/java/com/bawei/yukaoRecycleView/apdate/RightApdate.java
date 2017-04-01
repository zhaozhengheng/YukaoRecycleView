package com.bawei.yukaoRecycleView.apdate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bawei.yukaoRecycleView.R;
import com.bawei.yukaoRecycleView.bean.Right;
import com.bawei.yukaoRecycleView.bean.Zhong;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 1 on 2017/4/1.
 */
public class RightApdate extends RecyclerView.Adapter<MyHodle>
{
    private Context context;
    private List<Zhong> list;

    public RightApdate(Context context, List<Zhong> list) {
        this.context = context;
        this.list = list;
    }

    public interface  onTouch{
        void dainji(int text);
    }
    private onTouch monTouch;

    public onTouch getMonTouch()
    {
        return monTouch;
    }

    public void setMonTouch(onTouch monTouch) {
        this.monTouch = monTouch;
    }

    @Override
    public MyHodle onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rigth, parent, false);
        MyHodle myHodle = new MyHodle(view);

        return myHodle;
    }


    @Override
    public void onBindViewHolder(MyHodle holder, final int position)
    {
        holder.right.setText(list.get(position).getJieshao());
        Glide.with(context)
                .load(list.get(position).getImage())
                .into(holder.mImageView);
        if(monTouch!=null)
        {
            holder.mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    monTouch.dainji(position);
                }
            });

        }

    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }
}



