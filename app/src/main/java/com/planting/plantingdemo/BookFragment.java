package com.planting.plantingdemo;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class BookFragment extends Fragment {
    private List<String> left_list_items = new ArrayList<>();

    private List<Plant_Classification> plant_class_list = new ArrayList<>();
    private List<List<Plant_Classification>> plant_class_list_matrix = new ArrayList<List<Plant_Classification>>();
    public BookFragment(){

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.book_fragment,container,false);
        initLeft_List_Items();
        initPlant_Class_Items();
        RecyclerView recyclerView_left = (RecyclerView)root.findViewById(R.id.left_recyclerview);
        RecyclerView recyclerView_right = (RecyclerView)root.findViewById(R.id.right_content_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView_left.setLayoutManager(layoutManager);
        recyclerView_right.setLayoutManager(gridLayoutManager);
        Book_Left_List_Adapter book_left_list_adapter = new Book_Left_List_Adapter(left_list_items);
        Plant_Class_Adapter plant_class_adapter = new Plant_Class_Adapter(plant_class_list_matrix.get(1));

        recyclerView_left.setAdapter(book_left_list_adapter);
        recyclerView_right.setAdapter(plant_class_adapter);

        init_onClick(book_left_list_adapter);
        return root;
    }
    public void initLeft_List_Items(){
        left_list_items.add("蔷薇科");
        left_list_items.add("百合科");
        left_list_items.add("木兰科");
        left_list_items.add("山茶科");
        left_list_items.add("木犀科");
        left_list_items.add("毛茛科");
        left_list_items.add("石蒜科");
        left_list_items.add("天南星科");
        left_list_items.add("天门冬科");
        left_list_items.add("兰科");
        left_list_items.add("茜草科");
        left_list_items.add("楝科");

        Plant_Classification[] plant_classifications = {new Plant_Classification("玫瑰",R.drawable.plant1),
                new Plant_Classification("月季",R.drawable.pic_yueji),new Plant_Classification("海棠",R.drawable.pic_haitang),new Plant_Classification("梅花",R.drawable.plant1)};
        plant_class_list.clear();
        for (int i=0;i<plant_classifications.length;i++){
            plant_class_list.add(plant_classifications[i]);
        }
        plant_class_list_matrix.add(plant_class_list);
        plant_class_list.clear();
        plant_classifications= new Plant_Classification[]{new Plant_Classification("玫瑰", R.drawable.pic_meigui),
                new Plant_Classification("月季", R.drawable.pic_yueji), new Plant_Classification("海棠", R.drawable.pic_haitang), new Plant_Classification("梅花", R.drawable.pic_meihua)};
        for (int i=0;i<plant_classifications.length;i++){
            plant_class_list.add(plant_classifications[i]);
        }
        plant_class_list_matrix.add(plant_class_list);
    }
    public void initPlant_Class_Items(){



    }

    public void init_onClick(final Book_Left_List_Adapter adapter){
        adapter.setGetListener(new Book_Left_List_Adapter.GetListener() {
            @Override
            public void onClick(int position) {
                adapter.setmPosition(position);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
