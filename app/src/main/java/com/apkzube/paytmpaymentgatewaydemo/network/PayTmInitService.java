package com.apkzube.paytmpaymentgatewaydemo.network;

import com.apkzube.paytmpaymentgatewaydemo.response.initiateResponse.InitiateAPIResponse;
import com.apkzube.paytmpaymentgatewaydemo.util.CommonRestURL;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * PayTMPaymentGatewayDemo
 * Created by Vishal Nagvadiya on 21-06-2020.
 */
public interface PayTmInitService {

    @POST(CommonRestURL.V_1_INITIATE_TRANSACTION_TEST)
    Call<InitiateAPIResponse> initiateTransactionAPI(
                                                      @Query("MID") String mid,
                                                      @Query("ORDER_ID") String order_id,
                                                      @Query("AMOUNT") String amount);
}
