package com.futureinnovation.moodcloud.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.futureinnovation.moodcloud.R;

public class MainActivity extends Activity implements View.OnClickListener {

    Button myCenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        myCenter = (Button) findViewById(R.id.my_center);
        myCenter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,PersonalCenterActivity.class));
    }
}
