package com.aaagame.module.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aaagame.module.R;
import com.aaagame.module.utils.AppManager;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.t_activity_appmanager)
public class T_AppManager_Activity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reqData();
    }

    //=============================初始化view
    @ViewInject(R.id.btn_close_activity)
    Button btn_close_activity;
    @ViewInject(R.id.btn_exit_app)
    Button btn_exit_app;

    @Override
    public void initView() {

    }

    //============================初始化监听
    @Override
    public void initListener() {

    }

    @Event(value = {R.id.btn_exit_app, R.id.btn_close_activity})
    private void setClick(View view) {
        switch (view.getId()) {
            case R.id.btn_close_activity:
                AppManager.getInstance().killActivity(T_MainActivity.class);
                break;
            case R.id.btn_exit_app:
                AppManager.getInstance().AppExit(myActivity);
                break;
            default:
                break;
        }
    }

    //=============================初始化数据和变量
    @Override
    public void initData() {

    }

    //=============================网络请求数据
    @Override
    public void reqData() {

    }
    //=============================其他操作
}
