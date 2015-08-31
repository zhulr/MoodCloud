package com.futureinnovation.moodcloud.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.futureinnovation.moodcloud.R;
import com.futureinnovation.moodcloud.view.MainSelectPopupWindow;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button myCenter;
    private Button mainMenu;
    private MainSelectPopupWindow menuWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        myCenter = (Button) findViewById(R.id.my_center);
        myCenter.setOnClickListener(this);
        mainMenu = (Button) findViewById(R.id.mune);
        mainMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_center: {
                startActivity(new Intent(this, PersonalCenterActivity.class));
                break;
            }
            case R.id.mune:{
                //实例化SelectPicPopupWindow
                menuWindow = new MainSelectPopupWindow(MainActivity.this, itemsOnClick);
                //显示窗口
                menuWindow.showAtLocation(MainActivity.this.findViewById(R.id.main), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
                break;
            }
        }
    }
    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener(){

        public void onClick(View v) {
            menuWindow.dismiss();
            switch (v.getId()) {
                case R.id.btn_take_photo:
                    break;
                case R.id.btn_pick_photo:
                    break;
                default:
                    break;
            }


        }

    };
}
