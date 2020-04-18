package com.planting.plantingdemo;

public class Find_Talk_Classification {
    private String title,syn;
    private int people_num,imageId;

    public Find_Talk_Classification(String title,String syn,int people_num,int imageId){
        this.title=title;
        this.syn=syn;
        this.people_num=people_num;
        this.imageId=imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getSyn() {
        return syn;
    }

    public int getImageId() {
        return imageId;
    }

    public int getPeople_num() {
        return people_num;
    }
}
