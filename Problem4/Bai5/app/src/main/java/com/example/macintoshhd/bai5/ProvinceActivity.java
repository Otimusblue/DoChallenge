package com.example.macintoshhd.bai5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProvinceActivity extends AppCompatActivity {
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province);

        mTextView = findViewById(R.id.tv_tinhthanh);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String tinh = bundle.getString("Province");
            mTextView.setText(tinh);
        }
    }
}
