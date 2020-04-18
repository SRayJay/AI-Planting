package com.planting.plantingdemo;


//import android.os.Bundle;
//import android.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;

import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class MyFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.my_fragment,container,false);
        Button button=(Button)view.findViewById(R.id.my_sign_button);
        return view;
    }
}
