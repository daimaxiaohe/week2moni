package com.example.zhoukaomoni3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhoukaomoni3.R;
import com.example.zhoukaomoni3.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * はすてすゃの
 * 2019-01-05.
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.LeftHolder> {
    private Context context;
    private List<HomeBean.Datas> list;
    public LeftAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    /**
     * 设置集合的方法
     */
    public void setlist(List<HomeBean.Datas> list){
        if (list!=null){
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LeftHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.left_item,viewGroup,false);
        LeftHolder leftHolder = new LeftHolder(view);
        return leftHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LeftHolder leftHolder, final int i) {
        leftHolder.left_name.setText(list.get(i).name);
        leftHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemOnClick.OnClick(list.get(i).cid);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    /**
     * 复用类
     */
    class LeftHolder extends RecyclerView.ViewHolder{
        private TextView left_name;
        public LeftHolder(@NonNull View itemView) {
            super(itemView);
            left_name = itemView.findViewById(R.id.left_name);
        }
    }
    ItemOnClick itemOnClick;
    public void setItemOnClick(ItemOnClick itemOnClick) {
        this.itemOnClick = itemOnClick;
    }

    public interface ItemOnClick{
        void OnClick(String cid);
    }
}
