package com.example.lenovo.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private ArrayList<President>list = new ArrayList<>();
    final String STATE_TITLE="state_string";
    final String STATE_LIST="state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCategory=findViewById(R.id.rv_Category);
        rvCategory.setHasFixedSize(true);
        list.addAll(PresidenData.getListData());
        showRecyclerList();

        if (savedInstanceState == null) {
            setActionBarTitle("Mode CardView");
            list.addAll(PresidenData.getListData());
            showRecyclerCardView();
            mode = R.id.action_list;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<President> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }
    }
    private void showSelectedPresiden(President president){
        Toast.makeText(this, "kamu memilih"+president.getNama(), Toast.LENGTH_SHORT).show();
    }
    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListPresidentAdapter listPresidentAdapter = new ListPresidentAdapter(this);
        listPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(listPresidentAdapter);
        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {

            @Override
            public void onItemCliked(RecyclerView recyclerView, int position, View v) {
                tampilDetail(list.get(position));
            }
        });
    }
    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this,2));
        GridPresidentAdapter gridPresidentAdapter = new GridPresidentAdapter(this);
        gridPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(gridPresidentAdapter);
        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemCliked(RecyclerView recyclerView, int position, View v) {
                tampilDetail(list.get(position));
            }
        });
    }
    private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewPresidentAdapetr cardViewPresidentAdapetr = new CardViewPresidentAdapetr(this);
        cardViewPresidentAdapetr.setListPresident(list);
        rvCategory.setAdapter(cardViewPresidentAdapetr);
        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {

            @Override
            public void onItemCliked(RecyclerView recyclerView, int position, View v) {
                tampilDetail(list.get(position));

            }
        });
    }
    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    public void tampilDetail(President president){
        String data="data";
        Intent intent = new Intent(MainActivity.this, DetailCard.class);
        intent.putExtra("nama",president.getNama());
        intent.putExtra("gambar",president.getPhoto());
        intent.putExtra("deskripsi",president.getRemaks());

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        setMode(item.getItemId());

        return super.onOptionsItemSelected(item);
    }


    public void setMode(int selectedMode)  {
        String title=null;
        switch (selectedMode){
            case R.id.action_list:
                showRecyclerCardView();
                title=("Mode CardView");
                break;
            case  R.id.action_grid:
                showRecyclerGrid();
                title=("Mode Grid");
                break;
            case R.id.action_cardview:
                showRecyclerList();
                title=("Mode list");
                break;
        }
        mode=selectedMode;
        setActionBarTitle(title);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE,getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST,list);
        outState.putInt(STATE_MODE,mode);
    }
}
