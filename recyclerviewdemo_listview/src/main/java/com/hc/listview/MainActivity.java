package com.hc.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> data;
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        data = new ArrayList<String>();
        for (int i = 1; i < 50; i++) {//初始化数据
            data.add((new Random().nextInt(90) * 10 + 100) + "");
        }

        recyclerView.setHasFixedSize(true);//保持固定大小，提高性能
        //如果需要显示的是横向滚动的列表或者竖直滚动的列表，则使用这个LayoutManager。要实现的是ListView的效果，所以需要使用它。
        // 生成这个LinearLayoutManager之后可以设置他滚动的方向，默认竖直滚动，所以这里没有显式地设置
        manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);

        final ViewAdapter adapter = new ViewAdapter(this, data);
        adapter.setOnRecyclerViewListener(new ViewAdapter.OnRecyclerViewListener() {
            @Override
            public void onItemClick(View view, int position) {//单击添加一条新数据
                String str = ((TextView) view.findViewById(R.id.textView)).getText() + " " + position;
                Toast toast = Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
                adapter.notifyItemChanged(position);//在Position位置插入一条数据，开始执行动画
                data.add(position, "new data");//数据源中Position位置新增一条数据
                adapter.notifyItemRangeChanged(position, adapter.getItemCount());//刷新Position之后的数据
                // 为什么要刷新position为2以后的数据呢？因为，在position为2的位置插入了一条数据后，新数据的position变成了2，那原
                // 来的position为2的应该变成了3，3的应该变成了4，所以2以后的所有数据的position都发生了改变，所以需要把position2以
                // 后的数据都要刷新。理论上是这样，但是实际上刷新的数量只有在屏幕上显示的position为2以后的数据而已。如果这里使
                // 用notifyDataSetChanged()来刷新屏幕上显示的所有item可以吗？结果不会出错，但是会有一个问题，前面调用了
                // notifyItemInserted()方法后会在执行动画，如果你调用notifyDataSetChanged()刷新屏幕上显示的所有item的话，必然也
                // 会刷新当前正在执行动画的那个item，这样导致的结果是，前面的动画还没执行完，它马上又被刷新了，动画就看不见了。所以只
                // 要刷新2以后的item就可以了。
            }

            @Override
            public boolean onItemLongClick(View view, int position) {//长按删除数据
                adapter.notifyItemRemoved(position);
                data.remove(position);
                adapter.notifyItemRangeChanged(position, adapter.getItemCount());
                return false;
            }
        });
        recyclerView.setAdapter(adapter);//设置Adapter

        recyclerView.setItemAnimator(new DefaultItemAnimator());//添加动画

//        //添加分隔线
//        recyclerView.addItemDecoration(new ItemDividerDecoration(this, ItemDividerDecoration.VERTICAL_LIST));

        //滚动监听
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView,
                                             int scrollState) {
                String stateName = "Undefined";
                switch (scrollState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        stateName = "Idle";
                        break;

                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        stateName = "Dragging";
                        break;

                    case RecyclerView.SCROLL_STATE_SETTLING:
                        stateName = "Flinging";
                        break;
                }

                Log.i("TAG", "滑动状态：" + stateName);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {

                String s = "可见Item数量：" + manager.getChildCount()
                        + " 可见Item第一个Position " + manager.findFirstVisibleItemPosition()
                        + " 可见Item最后一个Position：" + manager.findLastVisibleItemPosition();
                Log.i("TAG", s);
            }
        });
    }

}