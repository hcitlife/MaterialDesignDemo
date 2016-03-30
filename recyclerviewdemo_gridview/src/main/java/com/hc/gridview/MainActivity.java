package com.hc.gridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<String>();
        for (int i = 1; i < 70; i++) {
            data.add((new Random().nextInt(90) * 10 + 100) + "");
        }
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

//        GridLayoutManager manager = new GridLayoutManager(this, 5);
//        manager.setOrientation(GridLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(manager);

        //        竖向滚动
       // recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));

        //横向滚动
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));

        recyclerView.setAdapter(new ViewAdapter());
        //设置分隔线
        recyclerView.addItemDecoration(new ItemDividerDecoration(this));
    }

    class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.listview_item, null);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            String text = data.get(position);
            holder.textView.setText(text);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        protected class MyViewHolder extends ViewHolder {
            private TextView textView;

            public MyViewHolder(View view) {
                super(view);
                textView = (TextView) view.findViewById(R.id.textView);
            }
        }
    }

}