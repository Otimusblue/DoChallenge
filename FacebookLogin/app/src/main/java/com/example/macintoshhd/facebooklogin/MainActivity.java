package com.example.macintoshhd.facebooklogin;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {
    private TextView mSignUp;
    private Button mSignIn;
    private EditText mEdtMail;
    private EditText mEdtPass;
    private RelativeLayout mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayout = findViewById(R.id.rl_layout);

        mEdtMail = findViewById(R.id.edt_email);
        mEdtPass = findViewById(R.id.edt_pass);

        mSignUp = findViewById(R.id.tv_signup);
        mSignUp.setPaintFlags(mSignUp.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);

        mSignIn = findViewById(R.id.btn_login);
        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Shake)
                        .duration(700)
                        .repeat(0)
                        .playOn(mEdtMail);


            }
        });

       mLayout.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               hideKeyBoard(v);
               return false;
           }
       });


    }
    private void hideKeyBoard(View v) {
         InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
         inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
    }

}
