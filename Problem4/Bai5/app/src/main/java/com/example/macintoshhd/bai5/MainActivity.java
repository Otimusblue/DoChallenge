package com.example.macintoshhd.bai5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity{

    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.provinces));


        mListView = findViewById(R.id.list_view);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,ProvinceActivity.class);
                intent.putExtra("Province",mListView.getItemAtPosition(position).toString());

                startActivity(intent);
            }
        });
        mListView.setAdapter(mAdapter);

    }
}
