package com.bawei.yukaoRecycleView.apdate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.yukaoRecycleView.R;
import com.bawei.yukaoRecycleView.bean.Erjixia;

import java.util.List;

/**
 * Created by 1 on 2017/4/1.
 */
public class Apdate extends RecyclerView.Adapter<My>
{
    private Context context;

    private List<Erjixia> list1;
    // private  bea.NodesBean nodesBean;



    public interface jiekou{
        void dianji(int position);
    }
    private jiekou mjiekou;



    public void setMjiekou(jiekou mjiekou) {
        this.mjiekou = mjiekou;
    }

    public Apdate(Context context, List<Erjixia> list1) {
        this.context = context;
        this.list1 = list1;
    }

    public Apdate()
    {
        super();
    }
    @Override
    public My onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_left, parent, false);
        My myViewHodle = new My(view);

        return myViewHodle;
    }


    @Override
    public void onBindViewHolder(My holder,final  int position) {
        holder.left.setText(list1.get(position).getName());
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
        return list1.size();
    }
}
class My extends RecyclerView.ViewHolder
{
    TextView left;
    public My(View itemView) {
        super(itemView);
        left = (TextView) itemView.findViewById(R.id.TextView_left);

    }
}
