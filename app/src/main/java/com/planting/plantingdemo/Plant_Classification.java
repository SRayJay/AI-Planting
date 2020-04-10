package com.planting.plantingdemo;

public class Plant_Classification {
    private String plant_name;
    private int imageId;
    public Plant_Classification(String plant_name, int imageId){
        this.plant_name = plant_name;
        this.imageId = imageId;
    }
    public String getPlant_name(){
        return this.plant_name;
    }
    public int getImageId(){
        return this.imageId;
    }
}
