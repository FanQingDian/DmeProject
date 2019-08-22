package com.dian.jsonname;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context mContext;
    public List<Bean> list;

    public MyAdapter(Context mContext, List<Bean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(mContext).inflate(R.layout.item, viewGroup,false);
        ViewHolder holder=new ViewHolder(mView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            ViewHolder  holder= (ViewHolder) viewHolder;
        holder.mTitle.setText(list.get(i).getName());
        holder.mContent.setText(list.get(i).getEmail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTitle;
        private TextView mContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = (TextView) itemView.findViewById(R.id.title);
            mContent = (TextView) itemView.findViewById(R.id.content);

        }
    }
}
