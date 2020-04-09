package com.planting.plantingdemo;


import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
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
    public StoreFragment(){

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.store_fragment,container,false);
        initLeft_List_Items();
        RecyclerView recyclerView = (RecyclerView)root.findViewById(R.id.left_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        Left_List_Adapter left_list_adapter = new Left_List_Adapter(left_list_items);
        recyclerView.setAdapter(left_list_adapter);
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
        left_list_items.add("蔷薇科");
        left_list_items.add("玫瑰科");
        left_list_items.add("蕨类植物");
        left_list_items.add("藻类植物");
    }
}
