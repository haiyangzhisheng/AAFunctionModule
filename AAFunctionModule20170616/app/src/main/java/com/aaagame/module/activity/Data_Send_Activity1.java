package com.aaagame.module.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import com.aaagame.module.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_data_send1)
public class Data_Send_Activity1 extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reqData();
    }

    //=============================初始化view
    @ViewInject(R.id.tv_data)
    TextView tv_data;

    @Override
    public void initView() {

    }

    //=============================初始化监听
    @Override
    public void initListener() {

    }

    @Event(value = {R.id.btn_tz})
    private void setClick(View view) {
        switch (view.getId()) {
            case R.id.btn_tz:
                Intent intent = new Intent(this, Data_Send_Activity2.class);
                intent.putExtra("mytitle", "我的标题");
                intent.putExtra("mycontent", "我的内容");
                animStartActivity(intent);
                break;
            default:
                break;
        }
    }

    //=============================初始化数据和变量
    public void initData() {
        String url = "data/mytest/ok/124.jpg";
        String fileName = Uri.parse(url).getLastPathSegment();
        System.out.println(fileName);
        String url2 = "http://www.baidu.com/124.jpg";
        String fileName2 = Uri.parse(url2).getLastPathSegment();
        String p1 = getExternalFilesDir(null).getPath();
        String p2 = getExternalCacheDir().getPath();
        String p3 = Environment.getExternalStorageDirectory().getPath();
        String p4 = null;
        try {
            p4 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tv_data.setText(p1 + "---" + p2 + "---" + p3 + "---" + p4 + "-----" + fileName + "***********" + fileName2 + getFilesDir().getPath() + "====" + getCacheDir().getPath());

        if (getIntent().getStringExtra("mytitle") != null) {
            tv_data.setText(getIntent().getStringExtra("mytitle") + "---GetDataSuccess---" + getIntent().getStringExtra("mycontent"));
        }

    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    //=============================网络请求数据
        @Override     public void reqData() {

    }
    //=============================其他操作
}
