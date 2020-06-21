package com.apkzube.paytmpaymentgatewaydemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.apkzube.paytmpaymentgatewaydemo.R;
import com.apkzube.paytmpaymentgatewaydemo.databinding.ActivityMainBinding;
import com.apkzube.paytmpaymentgatewaydemo.network.PayTmInitService;
import com.apkzube.paytmpaymentgatewaydemo.network.PayTmInitServiceImpl;
import com.apkzube.paytmpaymentgatewaydemo.response.initiateResponse.InitiateAPIResponse;
import com.google.gson.Gson;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;
import com.paytm.pgsdk.TransactionManager;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ApkZube";
    private static final int REQ_CODE_ORDER = 1221;
    private ActivityMainBinding mBinding;
    private final String MID="zTlxeC36082760394076";
    private String orderIdString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);


        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    initiatePayment();
                } catch (Exception e) {
                    Log.d(TAG, "onClick: "+e.getMessage());
                }
            }
        });


    }

    private void initiatePayment()  {

        PayTmInitService service=PayTmInitServiceImpl.getService();

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
        String date = df.format(c.getTime());
        Random rand = new Random();
        int min =1000, max= 9999;
        // nextInt as provided by Random is exclusive of the top value so you need to add 1
        int randomNum = rand.nextInt((max - min) + 1) + min;
        orderIdString =  date+String.valueOf(randomNum);


        service.initiateTransactionAPI(MID,orderIdString,"1.00").enqueue(new Callback<InitiateAPIResponse>() {
            @Override
            public void onResponse(Call<InitiateAPIResponse> call, Response<InitiateAPIResponse> response) {
                   InitiateAPIResponse apiResponse=response.body();


                Log.d(TAG, "onResponse: "+new Gson().toJson(response.body()));
                if(apiResponse.getBody().getResultInfo().getResultStatus().equalsIgnoreCase("S")){
/*
                    On completion of transaction, Paytm payment gateway will send the response on this URL. This can be a static response URL as mentioned below:
                    Staging Environment: "https://securegw-stage.paytm.in/theia/paytmCallback?ORDER_ID=<order_id>"
                    Production Environment: "https://securegw.paytm.in/theia/paytmCallback?ORDER_ID=<order_id>"*/
                    // for test mode use it
                    // String host = "https://securegw-stage.paytm.in/";
                    // for production mode use it
                    String host = "https://securegw.paytm.in/";
                    String callBackUrl = host + "theia/paytmCallback?ORDER_ID="+orderIdString;


                    PaytmOrder order=new PaytmOrder(orderIdString,MID,apiResponse.getBody().getTxnToken(),"1.00",callBackUrl);

                    TransactionManager transactionManager = new TransactionManager(order, new PaytmPaymentTransactionCallback() {
                        @Override
                        public void onTransactionResponse(Bundle bundle) {
                            Toast.makeText(getApplicationContext(), "Payment Transaction response " + bundle.toString(), Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void networkNotAvailable() {
                            Toast.makeText(MainActivity.this, "networkNotAvailable", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onErrorProceed(String s) {
                            Toast.makeText(MainActivity.this, "onErrorProceed "+s, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void clientAuthenticationFailed(String s) {
                            Toast.makeText(MainActivity.this, "clientAuthenticationFailed : "+s, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void someUIErrorOccurred(String s) {
                            Toast.makeText(MainActivity.this, "someUIErrorOccurred : "+s, Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onErrorLoadingWebPage(int i, String s, String s1) {
                            Toast.makeText(MainActivity.this, "onErrorLoadingWebPage : "+s+" : "+s1, Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onBackPressedCancelTransaction() {
                            Toast.makeText(MainActivity.this, "onBackPressedCancelTransaction : ", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onTransactionCancel(String s, Bundle bundle) {
                            Toast.makeText(MainActivity.this, "onTransactionCancel : "+s, Toast.LENGTH_SHORT).show();

                        }
                    });

                    transactionManager.setAppInvokeEnabled(false);
                    transactionManager.startTransaction(MainActivity.this, REQ_CODE_ORDER);

                }else {

                    Log.d(TAG, "initiatePayment: "+apiResponse.getBody().getResultInfo().getResultMsg());

                }
            }

            @Override
            public void onFailure(Call<InitiateAPIResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE_ORDER && data != null) {
            Toast.makeText(this, "vpn : "+data.getStringExtra("nativeSdkForMerchantMessage") + data.getStringExtra("response"), Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onActivityResult: "+new Gson().toJson(data));
        }
    }
}