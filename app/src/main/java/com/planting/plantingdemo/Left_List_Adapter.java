package com.planting.plantingdemo;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

public class Left_List_Adapter extends RecyclerView.Adapter<Left_List_Adapter.ViewHolder> {
    private List<String> mList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView left_txt;
//        TextView right_txt;
        public ViewHolder(View view){
            super(view);
            left_txt = (TextView)view.findViewById(R.id.left_list_item_text);
//            right_txt = (TextView)view.findViewById(R.id.right_top_name);
        }
    }
    public Left_List_Adapter(List<String> mList){
        this.mList = mList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.left_list_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
//        holder.txt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//                String name = mList.get(position);
//                getListener.onClick();
//                notifyDataSetChanged();
//                v.setBackgroundColor(Color.WHITE);
//                Toast.makeText(v.getContext(),"you clicked "+name,Toast.LENGTH_SHORT).show();
//            }
//        });
        return holder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        String left_list_item_name = mList.get(position);
        holder.left_txt.setText(left_list_item_name);
        holder.left_txt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                int position = holder.getAdapterPosition();
//                String name = mList.get(position);
                getListener.onClick(position);
                notifyDataSetChanged();
            }
        });
        if (position == getmPosition()){
            holder.left_txt.setBackgroundColor(Color.WHITE);
//            holder.right_txt.setText(left_list_item_name);
        }else{
            holder.left_txt.setBackgroundColor(Color.rgb(244,244,244));
        }
    }
    @Override
    public int getItemCount(){
        return mList.size();
    }

    public interface GetListener{
        void onClick(int position);
    }

    public GetListener getListener;

    public void setGetListener(GetListener getListener){
        this.getListener = getListener;
    }
    private int mPosition;
    public int getmPosition(){
        return mPosition;
    }
    public void setmPosition(int mPosition){
        this.mPosition = mPosition;
    }
}
