package com.aaagame.module.activity;

import android.os.Bundle;
import android.view.View;

import com.aaagame.module.R;
import com.aaagame.module.areachoice.Area_Choice;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

@ContentView(R.layout.t_activity_areachoice)
public class T_AreaChoice_Activity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reqData();
    }

    Area_Choice area_Choice;

    //=============================初始化view
    @Override
    public void initView() {

    }

    //=============================初始化监听
    @Override
    public void initListener() {
    }

    @Event(value = {R.id.btn_show})
    private void setClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show:
                area_Choice.showPopupWindow_Bottom(R.layout.t_activity_areachoice).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        area_Choice.mPopWindow.dismiss();
                    }
                });
                break;
            default:
                break;
        }
    }

    //=============================初始化数据和变量
    @Override
    public void initData() {
        area_Choice = new Area_Choice(this);
        area_Choice.initProvinceDatasOtherAsy();
    }

    //=============================网络请求数据
    @Override
    public void reqData() {

    }
    //=============================其他操作
}
