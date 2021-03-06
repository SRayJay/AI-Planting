package com.planting.plantingdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
//import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private TextView tab_menu_balcony;
    private TextView tab_menu_book;
    private TextView tab_menu_store;
    private TextView tab_menu_community;
    private TextView tab_menu_my;
    private CoordinatorLayout ly_content;

    private StoreFragment store_fragment;
    private BookFragment book_fragment;
    private FindFragment find_fragment;
    private MyFragment my_fragment;
    private FragmentManager fManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.menu);
            actionBar.setTitle("");
        }
        fManager = getFragmentManager();
        bindViews();
        //模拟一次点击，即主页在balcony
        tab_menu_balcony.performClick();

    }
    private void bindViews(){
        tab_menu_balcony = (TextView)findViewById(R.id.tab_menu_balcony);
        tab_menu_book = (TextView)findViewById(R.id.tab_menu_book);
        tab_menu_community = (TextView)findViewById(R.id.tab_menu_community);
        tab_menu_store = (TextView)findViewById(R.id.tab_menu_store);
        tab_menu_my = (TextView)findViewById(R.id.tab_menu_my);
        ly_content = (CoordinatorLayout) findViewById(R.id.ly_content);

        tab_menu_my.setOnClickListener(this);
        tab_menu_store.setOnClickListener(this);
        tab_menu_book.setOnClickListener(this);
        tab_menu_community.setOnClickListener(this);
        tab_menu_balcony.setOnClickListener(this);
    }
    private void setSelected(){
        tab_menu_balcony.setSelected(false);
        tab_menu_community.setSelected(false);
        tab_menu_book.setSelected(false);
        tab_menu_store.setSelected(false);
        tab_menu_my.setSelected(false);
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(store_fragment != null)fragmentTransaction.hide(store_fragment);
        if(book_fragment != null)fragmentTransaction.hide(book_fragment);
        if(find_fragment != null)fragmentTransaction.hide(find_fragment);
        if(my_fragment != null)fragmentTransaction.hide(my_fragment);
    }

    @Override
    public void onClick(View v){
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()){
            case R.id.tab_menu_balcony:
                setSelected();
                tab_menu_balcony.setSelected(true);
                break;
            case R.id.tab_menu_book:
                setSelected();
                tab_menu_book.setSelected(true);
                if (book_fragment==null){
                    book_fragment = new BookFragment();
                    fTransaction.add(R.id.ly_content,book_fragment);
                }else{
                    fTransaction.show(book_fragment);
                }
                break;
            case R.id.tab_menu_store:
                setSelected();
                tab_menu_store.setSelected(true);
                if (store_fragment==null){
                    store_fragment = new StoreFragment();
                    fTransaction.add(R.id.ly_content,store_fragment);
                }else{
                    fTransaction.show(store_fragment);
                }
                break;
            case R.id.tab_menu_community:
                setSelected();
                tab_menu_community.setSelected(true);
                if (find_fragment==null){
                    find_fragment = new FindFragment();
                    fTransaction.add(R.id.ly_content,find_fragment);
                }else{
                    fTransaction.show(find_fragment);
                }
                break;
            case R.id.tab_menu_my:
                setSelected();
                tab_menu_my.setSelected(true);
                if (my_fragment==null){
                    my_fragment = new MyFragment();
                    fTransaction.add(R.id.ly_content,my_fragment);
                }else{
                    fTransaction.show(my_fragment);
                }
                break;
        }
        fTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }
}
