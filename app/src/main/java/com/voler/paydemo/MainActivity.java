package com.voler.paydemo;

import android.os.Bundle;
import android.view.View;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;

public class MainActivity extends PayBaseActivity implements View.OnClickListener {

    /**
     * demo的支付接口
     */
    public static final String URL = " http://101.201.52.184/api/mmshq/pay/V6/eduSignPay";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.tv_weixin).setOnClickListener(this);
        findViewById(R.id.tv_alipay).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_weixin:
                postWeiXinPay("weixin");
                break;

            case R.id.tv_alipay:
                postWeiXinPay("alipay");
                break;

            default:
                break;
        }
    }

    private PostFormBuilder postWeiXinPay(String payPlatform) {
        PostFormBuilder postFormBuilder = OkHttpUtils
                .post()
                .url(URL)
                .addParams("serviceId", "78a1c57a97e04f658c492a4370c1dca9")
                .addParams("orderId", "4DA6CCB8FCDF447D8E7F3E60B141BCF9")   //各种后台需要的数据
                .addParams("orderType", "1")
                .addParams("orderNo", "20160803030608995679")
                .addParams("buyCount", "1")
                .addParams("cardId", "cardId")
                .addParams("openid", "1")
                .addParams("customerName", "voler")
                .addParams("customerPhone", "13888888888")
                .addParams("price", "0.01")
                .addParams("originalMoney", "0.01")
                .addParams("discountMoney", "0.00")
                .addParams("payMoney", "0.01")
                .addParams("kgParam", "eyJleHBpcmVzIjoxNDc3OTg1NTY0NzM5LCJsb2dpblVzZXIiOnRydWUsInRtcFVzZXIiOmZhbHNlLCJ0b2tlbiI6IjQ2QUY5NCIsInVzZXJJZCI6IjU2ZTdiM2U3NzZjMjkwMDQ1MDNlY2VjZCJ9")
                .addParams("payPlatform", payPlatform);
        toPay(payPlatform,postFormBuilder);
        return postFormBuilder;
    }
}
