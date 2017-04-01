package com.bawei.yukaoRecycleView.apdate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.bawei.yukaoRecycleView.R;
import com.bawei.yukaoRecycleView.bean.Left;
import com.bawei.yukaoRecycleView.bean.Zhong;

import java.util.List;

/**
 * Created by 1 on 2017/4/1.
 */
public class LeftApdate extends RecyclerView.Adapter<MyViewHodle>
{
    private Context context;
    private List<Zhong> list;
    public interface jiekou{
        void dianji(int position);
    }
    private jiekou mjiekou;



    public void setMjiekou(jiekou mjiekou) {
        this.mjiekou = mjiekou;
    }

    public LeftApdate(Context context, List<Zhong> list) {
        this.context = context;
        this.list = list;
    }

    public LeftApdate()
    {
        super();
    }

    @Override
    public MyViewHodle onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.item_left, parent, false);
        MyViewHodle myViewHodle = new MyViewHodle(view);

        return myViewHodle;
    }


    @Override
    public void onBindViewHolder(MyViewHodle holder, final  int position)
    {
        holder.left.setText(list.get(position).getName());
        holder.left.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mjiekou!=null)
                {
                    mjiekou.dianji(position);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
class MyViewHodle extends RecyclerView.ViewHolder{
    TextView left;
    public MyViewHodle(View itemView) {
        super(itemView);
         left = (TextView) itemView.findViewById(R.id.TextView_left);

    }
}
