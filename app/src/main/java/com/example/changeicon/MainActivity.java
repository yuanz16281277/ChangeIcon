package com.example.changeicon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.changeicon.util.IconUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button my_btn1;
    private Button my_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my_btn1 = findViewById(R.id.change_btn);
        my_btn2 = findViewById(R.id.reduction_btn);
        my_btn1.setOnClickListener(this);
        my_btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.change_btn:
                IconUtil.setIcon(this,Constants.ACTIVITY_ALIAS_Main2);
                break;
            case R.id.reduction_btn:
                IconUtil.setIcon(this,Constants.ACTIVITY_ALIAS_Main1);
                break;
        }
    }
}
