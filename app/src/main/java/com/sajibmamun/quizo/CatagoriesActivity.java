package com.sajibmamun.quizo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CatagoriesActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagories);
        toolbar=findViewById(R.id.ToolBarid);
        recyclerView=findViewById(R.id.RecyclerViewid);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        List<CatagoryModel> list=new ArrayList<>();
        list.add(new CatagoryModel("R.drawable.ic_launcher_background","Java"));
        list.add(new CatagoryModel("",""));
        list.add(new CatagoryModel("",""));
        list.add(new CatagoryModel("",""));
        list.add(new CatagoryModel("",""));
        list.add(new CatagoryModel("",""));
        list.add(new CatagoryModel("",""));
        list.add(new CatagoryModel("",""));

        CatagoryAdapter adapter=new CatagoryAdapter(this,list);
        recyclerView.setAdapter(adapter);

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}