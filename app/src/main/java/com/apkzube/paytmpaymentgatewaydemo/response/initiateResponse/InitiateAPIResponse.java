package com.apkzube.paytmpaymentgatewaydemo.response.initiateResponse;

import com.google.gson.annotations.SerializedName;

/**
 * PayTMPaymentGatewayDemo
 * Created by Vishal Nagvadiya on 21-06-2020.
 */
public class InitiateAPIResponse {

    @SerializedName("head")
    private Head head;

    @SerializedName("body")
    private Body body;


    public InitiateAPIResponse() {
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
