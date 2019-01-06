package com.example.zhoukaomoni3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhoukaomoni3.R;
import com.example.zhoukaomoni3.bean.AssorBean;
import com.example.zhoukaomoni3.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * はすてすゃの
 * 2019-01-05.
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightHolder> {
    private Context context;
    private List<AssorBean.Product> list;
    public RightAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    /**
     * 设置集合的方法
     */
    public void setlist(List<AssorBean.Product> list){
        if (list!=null){
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RightHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_item,viewGroup,false);
        RightHolder leftHolder = new RightHolder(view);
        return leftHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RightHolder rightHolder, final int i) {
        rightHolder.right_name.setText(list.get(i).name);
        rightHolder.right_item_show.setAdapter(new LeftItemAdapter(context,list.get(i).list));
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    /**
     * 复用类
     */
    class RightHolder extends RecyclerView.ViewHolder{
        private TextView right_name;
        private RecyclerView right_item_show;
        public RightHolder(@NonNull View itemView) {
            super(itemView);
            right_name = itemView.findViewById(R.id.right_name);
            right_item_show = itemView.findViewById(R.id.right_item_show);
            right_item_show.setLayoutManager(new GridLayoutManager(context,3));
        }
    }
}
