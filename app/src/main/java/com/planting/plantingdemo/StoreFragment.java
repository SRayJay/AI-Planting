package com.planting.plantingdemo;


import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class StoreFragment extends Fragment {

    private List<String> left_list_items = new ArrayList<>();
    private String content;

    private List<Plant_Classification> plant_class_list = new ArrayList<>();
    private List<List<Plant_Classification>> plant_class_list_matrix = new ArrayList<List<Plant_Classification>>();

    public StoreFragment(){

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.store_fragment,container,false);
        initLeft_List_Items();
        initPlant_Class_Items();
        RecyclerView recyclerView_left = (RecyclerView)root.findViewById(R.id.left_recyclerview);
        RecyclerView recyclerView_right = (RecyclerView)root.findViewById(R.id.right_content_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);

        recyclerView_left.setLayoutManager(layoutManager);
        recyclerView_right.setLayoutManager(gridLayoutManager);
        Left_List_Adapter left_list_adapter = new Left_List_Adapter(left_list_items);
        Plant_Class_Adapter plant_class_adapter = new Plant_Class_Adapter(plant_class_list_matrix.get(1));

        recyclerView_left.setAdapter(left_list_adapter);
        recyclerView_right.setAdapter(plant_class_adapter);

        init_onClick(left_list_adapter);
        return root;
    }


    public void initLeft_List_Items(){
        left_list_items.add("多肉植物");
        left_list_items.add("植物用具");
        left_list_items.add("观叶绿植");
        left_list_items.add("观花植物");
        left_list_items.add("办公场所");
        left_list_items.add("阳台庭院");
        left_list_items.add("植物尺寸");
        left_list_items.add("园艺周边");
        left_list_items.add("风格");
        left_list_items.add("植物图书");
        left_list_items.add("蕨类植物");
        left_list_items.add("藻类植物");

        Plant_Classification[] plant_classifications = {new Plant_Classification("大型绿植",R.drawable.plant1),
                new Plant_Classification("盆栽绿植",R.drawable.plant1),new Plant_Classification("多肉组合",R.drawable.plant1),new Plant_Classification("大型绿植",R.drawable.plant1),
                new Plant_Classification("盆栽绿植",R.drawable.plant1),new Plant_Classification("多肉组合",R.drawable.plant1),
                new Plant_Classification("大型绿植",R.drawable.plant1),
                new Plant_Classification("盆栽绿植",R.drawable.plant1),new Plant_Classification("多肉组合",R.drawable.plant1)};
        plant_class_list.clear();
        for (int i=0;i<plant_classifications.length;i++){
            plant_class_list.add(plant_classifications[i]);
        }
        plant_class_list_matrix.add(plant_class_list);
        plant_class_list.clear();
        plant_classifications= new Plant_Classification[]{new Plant_Classification("蓝苹果", R.drawable.pic_blueapple),
                new Plant_Classification("仙人球", R.drawable.pic_xianrenqiu), new Plant_Classification("玉露", R.drawable.pic_yulu), new Plant_Classification("树冰", R.drawable.pic_treeice),new Plant_Classification("小米星",R.drawable.pic_xiaomixing),new Plant_Classification("晚霞之舞",R.drawable.pic_wanxiazhiwu),new Plant_Classification("月亮仙子",R.drawable.pic_moonxianzi),new Plant_Classification("千佛手",R.drawable.pic_qianfoshou),new Plant_Classification("芦荟",R.drawable.pic_luhui)};
        for (int i=0;i<plant_classifications.length;i++){
            plant_class_list.add(plant_classifications[i]);
        }
        plant_class_list_matrix.add(plant_class_list);
    }

    public void initPlant_Class_Items(){



    }

    public void init_onClick(final Left_List_Adapter adapter){
        adapter.setGetListener(new Left_List_Adapter.GetListener() {
            @Override
            public void onClick(int position) {
                adapter.setmPosition(position);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
