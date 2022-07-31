package com.sajibmamun.quizo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

public class QuestionSetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_set);
        GridView gridView=findViewById(R.id.Gridviewid);
        Toolbar toolbar=findViewById(R.id.QuestionSetToolBarid);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra("title"));


        GridAdapter adapter=new GridAdapter(16);
        gridView.setAdapter(adapter);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}