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
@ContentView(R.layout.t_activity_main)
public class T_MainActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reqData();
        System.out.println("根路径：：：：" + AAPath.getRootPath());
    }

    //=============================初始化view
    @ViewInject(R.id.lv_list)
    ListView lv_list;

    @Override
    public void initView() {

    }

    //=============================初始化监听
    public void initListener() {
        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    animStartActivity(Class.forName(getPackageName() + ".activity." + map.keySet().toArray()[i]));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //=============================初始化数据和变量
    private LinkedHashMap<String, String> map;

    @Override
    public void initData() {
        map = new LinkedHashMap<String, String>();
        map.put("T_Banner_Activity", "轮播图");
        map.put("T_RefreshTwinkling_Activity", "下拉刷新上拉加载");
        map.put("T_PaletteActivity", "提取和设置主题颜色");
        map.put("T_SmartTabActivity", "选项卡");
        map.put("T_CameraActivity", "拍照和选择照片");
        map.put("T_Xutils_Activity", "Xutils的使用");
        map.put("T_Pay_Activity", "支付");
        map.put("T_ListEmpty_Activity", "列表为空显示为空界面");
        map.put("T_AppManager_Activity", "Activity管理");
        map.put("T_AreaChoice_Activity", "地址选择器");
        map.put("T_Widget_BottomCircle_Activity", "自定义绘制控件--向下弧度的扇形");

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
