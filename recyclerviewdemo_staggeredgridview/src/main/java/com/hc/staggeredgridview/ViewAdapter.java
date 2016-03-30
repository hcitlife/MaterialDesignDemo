package com.hc.staggeredgridview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class ViewAdapter extends
        RecyclerView.Adapter<ViewAdapter.MyViewHolder> {

    private List<String> data;
    private LayoutInflater inflater;

    private List<Integer> heights;

    public interface onRecyclerViewListener {//回调节口

        void onItemClick(View view, int position); //单击

        void onItemLongClick(View view, int position);//长按
    }

    private onRecyclerViewListener onRecyclerViewListener;

    public void setOnRecyclerViewListener(onRecyclerViewListener mOnItemClickLitener) {
        this.onRecyclerViewListener = mOnItemClickLitener;
    }

    public ViewAdapter(Context context, List<String> datas) {
        inflater = LayoutInflater.from(context);
        data = datas;

        heights = new ArrayList<Integer>();
        for (int i = 0; i < data.size(); i++) {
            heights.add((int) (100 + Math.random() * 300));
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(inflater.inflate(
                R.layout.listview_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        LayoutParams lp = holder.textView.getLayoutParams();
        lp.height = heights.get(position);

        holder.textView.setLayoutParams(lp);
        holder.textView.setText(data.get(position));

        // 如果设置了回调，则设置点击事件
        if (onRecyclerViewListener != null) {
            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onRecyclerViewListener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onRecyclerViewListener.onItemLongClick(holder.itemView, pos);
                    removeData(pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addData(int position) {//添加数据
        data.add(position, "Insert One");
        heights.add((int) (100 + Math.random() * 300));
        notifyItemInserted(position);
    }

    public void removeData(int position) { //删除数据
        data.remove(position);
        notifyItemRemoved(position);
    }

    class MyViewHolder extends ViewHolder {

        TextView textView;

        public MyViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
        }
    }
}