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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FindFragment extends Fragment {

    private List<Find_Talk_Classification> Find_Talk_List = new ArrayList<>();
    public FindFragment(){}
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root;
        root = inflater.inflate(R.layout.find_fragment,container,false);

//        init_Talk();
//        RecyclerView recyclerView_talk = root.findViewById(R.id.find_talk_recyclerview);
//        Find_Talk_Adapter Talk_Adapter = new Find_Talk_Adapter(Find_Talk_List);
//        recyclerView_talk.setAdapter(Talk_Adapter);

        return root;
    }
    void init_Talk(){
        Find_Talk_List.add(new Find_Talk_Classification("#扦插的法师","多肉法师的繁殖方法主要是以扦插法。但扦插法又分为侧芽扦插,砍头扦插和枝条扦插三种操作方法。繁殖数量最多,成苗最快的繁殖方法要数侧芽扦插法。砍头扦插法成苗也.",1837,R.drawable.plant1));
        Find_Talk_List.add(new Find_Talk_Classification("#不用浇水的植物","很多花友都担心自己家植物的生长，所以很多花友出去玩儿的时候，也还惦记着自己家的花草，担心自己忘了浇水，影响植物的生长，其实有些植物不用浇水，也能长得很好。",686,R.drawable.plant1));
    }

}
