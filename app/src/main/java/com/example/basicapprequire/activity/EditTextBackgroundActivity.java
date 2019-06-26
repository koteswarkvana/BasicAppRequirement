package com.example.basicapprequire.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.basicapprequire.R;

/*
* Hide title bar. We need to change style and add code
* getSupportActionBar().hide();
* */
public class EditTextBackgroundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Below line of code can remove the title bar.
        getSupportActionBar().hide();
        setContentView(R.layout.activity_edit_text_background);
    }
}
