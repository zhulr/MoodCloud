package com.futureinnovation.moodcloud.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.futureinnovation.moodcloud.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhulr on 2015/8/31.
 */
public class StartupActivity extends Activity implements View.OnClickListener {

    private TimerTask mTask;
    private Timer mTimer = new Timer();
    private long mMills = 3 * 1000;
    private Button startup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        init();
        mTask = new TimerTask() {
            @Override
            public void run() {
                if (mMills > 0) {
                    mMills -= 1000;
                } else {
                    startActivity(new Intent(StartupActivity.this, MainActivity.class));
                    mTimer.cancel();
                    finish();
                }
            }
        };
        mTimer.schedule(mTask, 1000, 1000);
    }

    private void init() {
        startup = (Button) findViewById(R.id.app_startup_start);
        startup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_startup_start: {
                mMills = 0;
//                startActivity(new Intent(this, MainActivity.class));
//                this.finish();
                break;
            }
        }
    }
}
