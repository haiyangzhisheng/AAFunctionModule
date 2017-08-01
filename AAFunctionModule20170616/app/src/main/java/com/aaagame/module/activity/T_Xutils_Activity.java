package com.aaagame.module.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.aaagame.module.R;
import com.aaagame.module.utils.AACom;
import com.aaagame.module.utils.Ahttp;
import com.aaagame.module.utils.ArequestCallBack;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.t_activity_xutils)
public class T_Xutils_Activity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reqData();
    }

    //=============================初始化view
    @ViewInject(R.id.iv_circle_header)
    ImageView iv_circle_header;
    @ViewInject(R.id.iv_show)
    ImageView iv_show;
    @ViewInject(R.id.tv_bank)
    TextView tv_bank;
    @ViewInject(R.id.iv_gif)
    ImageView iv_gif;

    @Override
    public void initView() {

    }

    //=============================初始化监听


    @Override
    public void initListener() {

    }

    //=============================初始化数据和变量
    @Override
    public void initData() {
        AACom.displayCircleImage(iv_circle_header, "http://image.baidu.com/search/down?tn=download&word=download&ie=utf8&fr=detail&url=http%3A%2F%2Fimg3.fengniao.com%2Fforum%2Fattachpics%2F214%2F158%2F8551415.jpg&thumburl=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D2299116731%2C22865354%26fm%3D23%26gp%3D0.jpg");
        AACom.displayFitImage(iv_show, "http://image.baidu.com/search/down?tn=download&word=download&ie=utf8&fr=detail&url=http%3A%2F%2Fimg3.fengniao.com%2Fforum%2Fattachpics%2F214%2F158%2F8551415.jpg&thumburl=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D2299116731%2C22865354%26fm%3D23%26gp%3D0.jpg");
        AACom.displayGifFitImage(iv_gif, "https://image.baidu.com/search/down?tn=download&ipn=dwnl&word=download&ie=utf8&fr=result&url=http%3A%2F%2Fupload.chinapet.com%2Fforum%2F201312%2F18%2F105107ujcucbls9x1uzbjb.gif&thumburl=https%3A%2F%2Fss0.bdstatic.com%2F70cFvHSh_Q1YnxGkpoWK1HF6hhy%2Fit%2Fu%3D576892000%2C1749133700%26fm%3D23%26gp%3D0.jpg");


    }

    //=============================网络请求数据
    @Override
    public void reqData() {
//银行卡信息查询
        final String cardNo = "6228481369088809478";
        final String myaddr = "http://api.avatardata.cn/Bank/Query?key=828b337dbe434c53ba95850173ea5ec8&cardnum="
                + cardNo;
        final Ahttp ahttp = new Ahttp(myActivity, myaddr, true);
        ahttp.sendGet(new ArequestCallBack<String>(myActivity, ahttp) {
            @Override
            public void onSuccess(String responseInfo) {
                super.onSuccess(responseInfo);
                MyData myData = getGson().fromJson(responseInfo, MyData.class);
                toastShow(myData.result.bankname);
                tv_bank.setText("银行卡信息：\n" + cardNo + "\n" + myData.result.bankname + "\n" + myData.result.cardtype);
            }
        });

    }

    class MyData {
        public int error_code;// ;//0,
        public String reason;// : "Succes",
        public BankCard_Info result;
    }

    public class BankCard_Info {
        public String bankname;// ;//"交通银行",
        public String banknum;// ;//"3010000",
        public int cardlength;// ;//19,
        public String cardname;// ;//"太平洋借记卡",
        public String cardprefixnum;// ;//"622260",
        public String cardtype;// ;//"借记卡"

    }
    //=============================其他操作
}
