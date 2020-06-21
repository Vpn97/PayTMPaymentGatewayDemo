package com.apkzube.paytmpaymentgatewaydemo.response.initiateResponse;

import com.google.gson.annotations.SerializedName;

/**
 * PayTMPaymentGatewayDemo
 * Created by Vishal Nagvadiya on 21-06-2020.
 */
public class ResultInfo {

    @SerializedName("resultStatus")
    private String resultStatus;

    @SerializedName("resultCode")
    private String resultCode;

    @SerializedName("resultMsg")
    private String resultMsg;

    @SerializedName("bankRetry")
    private String bankRetry;

    @SerializedName("retry")
    private String retry;

    public ResultInfo() {
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getBankRetry() {
        return bankRetry;
    }

    public void setBankRetry(String bankRetry) {
        this.bankRetry = bankRetry;
    }

    public String getRetry() {
        return retry;
    }

    public void setRetry(String retry) {
        this.retry = retry;
    }
}
