package com.apkzube.paytmpaymentgatewaydemo.network;

import com.apkzube.paytmpaymentgatewaydemo.util.CommonRestURL;
import com.apkzube.paytmpaymentgatewaydemo.util.GsonUtil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * PayTMPaymentGatewayDemo
 * Created by Vishal Nagvadiya on 21-06-2020.
 */
public class PayTmInitServiceImpl {

    private static Retrofit retrofit = null;

    public static PayTmInitService getService(){

        if(retrofit==null){

            retrofit=new Retrofit
                    .Builder()
                    .baseUrl(CommonRestURL.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(GsonUtil.getGson()))
                    .client(GsonUtil.getOkHttpClientBuilder().build())
                    .build();
        }

        return retrofit.create(PayTmInitService.class);

    }
}
