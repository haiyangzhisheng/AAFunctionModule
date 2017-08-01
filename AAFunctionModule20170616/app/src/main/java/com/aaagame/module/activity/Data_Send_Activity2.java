package com.aaagame.module.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aaagame.module.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_data_send2)
public class Data_Send_Activity2 extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reqData();
    }

    //=============================初始化view
    @ViewInject(R.id.tv_data)
    TextView tv_data;

        @Override     public void initView() {

    }

    //=============================初始化监听
        @Override     public void initListener() {

    }

    @Event(value = {R.id.btn_send2})
    private void setClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send2:
                Intent intent = new Intent(myActivity, Data_Send_Activity1.class);
                intent.putExtras(getIntent());
                animStartActivity(intent);
                break;
            default:
                break;
        }
    }

    //=============================初始化数据和变量
        @Override     public void initData() {
        tv_data.setText(getIntent().getStringExtra("mytitle") + "--------" + getIntent().getStringExtra("mycontent"));

    }

    //=============================网络请求数据
        @Override     public void reqData() {

    }
    //=============================其他操作
}
