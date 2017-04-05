package com.bawei.yukaoRecycleView.active;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.yukaoRecycleView.R;
import com.bawei.yukaoRecycleView.apdate.Apdate;
import com.bawei.yukaoRecycleView.apdate.LeftApdate;
import com.bawei.yukaoRecycleView.bean.Erji;
import com.bawei.yukaoRecycleView.bean.Erjixia;
import com.bawei.yukaoRecycleView.bean.Left;
import com.bawei.yukaoRecycleView.bean.Right;
import com.bawei.yukaoRecycleView.bean.Zhong;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView right;
    private RecyclerView left;
    private TextView mTextView;
    private List<Left> list_left;
    private List<Right> list_right;
    private List<Zhong> list_zhong;
    private List<Erji> list_yiji;
    private List<Erjixia> list_erji;

    Handler han = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

       /*     left.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            LeftApdate mLeftApdate = new LeftApdate(MainActivity.this,list_left);
            left.setAdapter(mLeftApdate);
            mLeftApdate.setMjiekou(new LeftApdate.jiekou() {
                @Override
                public void dianji(int position)
                {


                    mTextView.setText(list_left.get(position).getName());
                    right.setLayoutManager(new GridLayoutManager(MainActivity.this,3));
                    RightApdate mRightApdate = new RightApdate(MainActivity.this,list_right);
                    right.setAdapter(mRightApdate);
                    mRightApdate.setMonTouch(new RightApdate.onTouch() {
                                @Override
                                public void dainji(int text)
                                {
                                    Toast.makeText(MainActivity.this, "点击了"+list_right.get(text).getJieshao(), Toast.LENGTH_SHORT).show();
                                }
                            });





                }
            });*/
            left.setLayoutManager(new LinearLayoutManager(MainActivity.this));

            mLeftApdate = new LeftApdate(MainActivity.this,list_yiji);
            left.setAdapter(mLeftApdate);
            mLeftApdate.setMjiekou(new LeftApdate.jiekou() {
                @Override
                public void dianji( int position)
                {
                    mTextView.setText(list_yiji.get(position).getCname());
                    //改变背景颜色
                    for(int i=0;i<list_yiji.size();i++)
                    {
                        if(i==position)
                        {
                            list_yiji.get(i).setBoo(true);
                        }else
                        {
                            list_yiji.get(i).setBoo(false);
                        }
                        mLeftApdate.notifyDataSetChanged();
                    }

                    right.setLayoutManager(new GridLayoutManager(MainActivity.this,3));
                    list1 = list_yiji.get(position).getList();

                    Apdate mRightApdate = new Apdate(MainActivity.this, list1);
                    right.setAdapter(mRightApdate);
                    mRightApdate.notifyDataSetChanged();
                    mRightApdate.setMjiekou(new Apdate.jiekou() {
                        @Override
                        public void dianji(int position)
                        {
                            Toast.makeText(MainActivity.this, "点击了"+ list1.get(position).getName(), Toast.LENGTH_SHORT).show();
                        }
                    });





                }
            });







        }
    };
    private Erji e;
    private Erjixia er;
    private List<Erjixia> list1;
    private LeftApdate mLeftApdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
    }

    private void initDate()
    {
        list_right = new ArrayList<Right>();
        list_left = new ArrayList<Left>();
        list_zhong = new ArrayList<Zhong>();
        list_yiji = new ArrayList<Erji>();


        OkHttpClient mOkHttpClient = new OkHttpClient();
      /*  Request request = new Request.Builder().url("http://m.yunifang.com/yunifang/mobile/home?random=84831&encode=9dd34239798e8cb22bf99a75d1882447")
                .build();*/
        Request request = new Request.Builder().url("http://www.meirixue.com/api.php?c=category&a=getall")
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e)
            {

            }

            @Override
            public void onResponse(Response response) throws IOException
            {
                String string = response.body().string();
               /* try {
                    JSONArray js= new JSONArray(string);
                    String[] arr= new String[js.length()];
                    for(int i=0;i<arr.length;i++)
                    {
                        arr[i]=js.optString(i);
                        Gson gson = new Gson();
                        be = gson.fromJson(arr[i], bea.class);
                        han.sendEmptyMessage(0);
                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }

*/



              /*  try {
                    JSONObject js = new JSONObject(string);
                    JSONObject data = js.optJSONObject("data");
                    JSONArray bestSellers = data.optJSONArray("bestSellers");
                    String[] arr = new String[bestSellers.length()];
                   for(int i=0;i<arr.length;i++)
                   {
                       arr[i] = bestSellers.optString(i);
                       JSONObject jj = new JSONObject(arr[i]);
                       JSONArray goodsList = jj.optJSONArray("goodsList");
                       String[] arr1 = new String[goodsList.length()];
                       for(int a=0;a<arr1.length;a++)
                       {
                           arr1[a] =goodsList.optString(a);
                           JSONObject je= new JSONObject(arr1[a]);
                           String efficacy = je.optString("efficacy");
                           Left mLeft = new Left();
                           mLeft.setName(efficacy);
                           list_left.add(mLeft);
                           String goods_img = je.optString("goods_img");
                           String goods_name = je.optString("goods_name");
                           Right right = new Right();
                           right.setImage(goods_img);
                           right.setJieshao(goods_name);
                           list_right.add(right);
                           Zhong mZhong = new Zhong();
                           mZhong.setName(efficacy);
                           mZhong.setImage(goods_img);
                           mZhong.setJieshao(goods_name);
                           list_zhong.add(mZhong);
                           han.sendEmptyMessage(0);

                       }
                   }

                } catch (Exception e) {
                    e.printStackTrace();
                }*/
                try {

                    JSONArray je= new JSONArray(string);
                    String[] arr = new String[je.length()];
                    for(int a=0;a<arr.length;a++)
                    {
                        arr[a] = je.optString(a);
                        JSONObject jn = new JSONObject(arr[a]);
                        String cname = jn.optString("cname");
                        list_erji = new ArrayList<Erjixia>();
                        e = new Erji();
                        e.setCname(cname);
                        JSONArray nodes = jn.optJSONArray("nodes");
                        String[] nn = new String[nodes.length()];
                        for(int n=0;n<nodes.length();n++)
                        {
                            nn[n]=nodes.optString(n);
                            JSONObject jv = new JSONObject(nn[n]);
                            String category_name = jv.optString("category_name");
                            er = new Erjixia();
                            er.setName(category_name);
                            list_erji.add(er);
                        }

                        e.setList(list_erji);
                        list_yiji.add(e);
                        Log.d("zzz",list_yiji.toString());
                        han.sendEmptyMessage(0);

                    }




                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

    }



    private void initView()
    {
        right = (RecyclerView) findViewById(R.id.RecyclerView_right);
        left = (RecyclerView) findViewById(R.id.RecyclerView_left);
        mTextView = (TextView) findViewById(R.id.TextView);
    }
}
