package com.planting.plantingdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.List;

public class Left_List_Adapter extends RecyclerView.Adapter<Left_List_Adapter.ViewHolder> {
    private List<String> mList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt;
        public ViewHolder(View view){
            super(view);
            txt = (TextView)view.findViewById(R.id.left_list_item_text);
        }
    }
    public Left_List_Adapter(List<String> mList){
        this.mList = mList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.left_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        String left_list_item_name = mList.get(position);
        holder.txt.setText(left_list_item_name);
    }
    @Override
    public int getItemCount(){
        return mList.size();
    }
}
