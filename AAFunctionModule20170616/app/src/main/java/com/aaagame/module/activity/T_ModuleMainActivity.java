package com.aaagame.module.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.aaagame.module.R;
import com.aaagame.module.utils.AAComAdapter;
import com.aaagame.module.utils.AAPath;
import com.aaagame.module.utils.AAViewHolder;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * 功能模板入口列表
 */
@ContentView(R.layout.t_activity_modulemain)
public class T_ModuleMainActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reqData();
        System.out.println("根路径：：：：" + AAPath.getRootPath());
    }

    //=============================初始化view
    @ViewInject(R.id.lv_list)
    ListView lv_list;

        @Override     public void initView() {

    }

    //=============================初始化监听
        @Override     public void initListener() {
        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        animStartActivity((Class) map.keySet().toArray()[i]);
            }
        });
    }

    //=============================初始化数据和变量
    private LinkedHashMap<Class, String> map;

        @Override     public void initData() {
        map = new LinkedHashMap<Class, String>();
        map.put(lbsmark.LocationDemo.class, "地图选点");
        map.put(WeightLayout_Activity.class, "weight布局方式");
        map.put(Data_Send_Activity1.class,"putExtras数据传递");
        map.put(ViewPager_Activity.class,"ViewPager设置自定义动画");
        map.put(Fragment_Animation_Activity.class,"Fragment设置动画");
        map.put(ZoomActivity.class,"ImageButton放大动画");
        map.put(LayoutChangesActivity.class,"动态添加控件开启动画效果");

        AAComAdapter<String> adapter = new AAComAdapter<String>(myActivity, R.layout.t_activity_main_item, new ArrayList<>(map.values())) {
            @Override
            public void convert(AAViewHolder holder, String mt) {
                holder.setText(R.id.tv_name, mt);
            }
        };
        lv_list.setAdapter(adapter);
    }

    //=============================网络请求数据
        @Override     public void reqData() {

    }
    //=============================其他操作
}
