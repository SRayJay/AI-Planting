package com.planting.plantingdemo;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Find_Talk_Adapter extends RecyclerView.Adapter<Find_Talk_Adapter.ViewHolder>{
    private List<Find_Talk_Classification> Talk_Items;
    private Context mContext;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView find_talk_image;
        TextView find_talk_head;
        TextView find_talk_syn;
        TextView find_talk_people;

        public ViewHolder(View view){
            super(view);
            cardView = (CardView)view;
            find_talk_head = (TextView) view.findViewById(R.id.find_talk_head);
            find_talk_syn = (TextView)view.findViewById(R.id.find_talk_syn);
            find_talk_people = (TextView)view.findViewById(R.id.find_talk_peo);
            find_talk_image = (ImageView)view.findViewById(R.id.find_talk_image);
        }
    }

    public Find_Talk_Adapter(List<Find_Talk_Classification> TalkList){
        Talk_Items = TalkList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if (mContext==null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.find_talk,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    public void onBindViewHolder(ViewHolder holder, int position){
        String people;
        Find_Talk_Classification Talk_classification = Talk_Items.get(position);
        people="有"+Talk_classification.getPeople_num()+"人参与";
        holder.find_talk_head.setText(Talk_classification.getTitle());
        holder.find_talk_syn.setText(Talk_classification.getSyn());
        holder.find_talk_people.setText(people);
        Glide.with(mContext).load(Talk_classification.getImageId()).into(holder.find_talk_image);
    }
    public int getItemCount(){
        return Talk_Items.size();
    }

}
