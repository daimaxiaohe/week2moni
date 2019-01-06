package com.example.zhoukaomoni3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhoukaomoni3.R;
import com.example.zhoukaomoni3.bean.AssorBean;

import java.util.ArrayList;
import java.util.List;

/**
 * はすてすゃの
 * 2019-01-06.
 */
public class LeftItemAdapter extends RecyclerView.Adapter<LeftItemAdapter.LeftItemHolder>{
    private Context context;
    private List<AssorBean.Product.Sub> list;
    public LeftItemAdapter(Context context,List<AssorBean.Product.Sub> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public LeftItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        LeftItemHolder leftItemHolder = new LeftItemHolder(view);
        return leftItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LeftItemHolder leftItemHolder, int i) {
        leftItemHolder.item_name.setText(list.get(i).name);
        Glide.with(context).load(list.get(i).icon).into(leftItemHolder.item_img);
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    /**
     * 复用类
     */
    class LeftItemHolder extends RecyclerView.ViewHolder{
        private TextView item_name;
        private ImageView item_img;
        public LeftItemHolder(@NonNull View itemView) {
            super(itemView);
            item_img = itemView.findViewById(R.id.item_img);
            item_name = itemView.findViewById(R.id.item_name);
        }
    }
}
