package com.apkzube.paytmpaymentgatewaydemo.response.initiateResponse;

import com.google.gson.annotations.SerializedName;

/**
 * PayTMPaymentGatewayDemo
 * Created by Vishal Nagvadiya on 21-06-2020.
 */
public class Head {

    @SerializedName("responseTimestamp")
    private String responseTimestamp;

    @SerializedName("version")
    private String version;

    @SerializedName("signature")
    private String signature;


    public Head() {
    }

    public String getResponseTimestamp() {
        return responseTimestamp;
    }

    public void setResponseTimestamp(String responseTimestamp) {
        this.responseTimestamp = responseTimestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
