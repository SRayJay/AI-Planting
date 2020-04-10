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
import java.util.zip.Inflater;

public class Plant_Class_Adapter extends RecyclerView.Adapter<Plant_Class_Adapter.ViewHolder> {
    private Context mContext;
    private List<Plant_Classification> cPlantList;
//    private List<List<Plant_Classification>> cPlantList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView plant_kind_image;
        TextView plant_kind_name;
        public ViewHolder(View view){
            super(view);
            cardView = (CardView)view;
            plant_kind_image = (ImageView)view.findViewById(R.id.plant_little_img);
            plant_kind_name = (TextView)view.findViewById(R.id.plant_classification_name);
        }
    }
    public Plant_Class_Adapter(List<Plant_Classification> PlantList){
        cPlantList = PlantList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if (mContext==null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.plant_classification_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Plant_Classification plant_classification = cPlantList.get(position);
        holder.plant_kind_name.setText(plant_classification.getPlant_name());
        Glide.with(mContext).load(plant_classification.getImageId()).into(holder.plant_kind_image);
    }
    @Override
    public int getItemCount(){
        return cPlantList.size();
    }

}
