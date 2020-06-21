package com.apkzube.paytmpaymentgatewaydemo.response.initiateResponse;

import com.google.gson.annotations.SerializedName;

/**
 * PayTMPaymentGatewayDemo
 * Created by Vishal Nagvadiya on 21-06-2020.
 */


/* Success Response
    {
        "head": {
        "responseTimestamp": "1526969112101",
        "version": "v1",
        "clientId": "C11",
        "signature": "TXBw50YPUKIgJd8gR8RpZuOMZ+csvCT7i0/YXmG//J8+BpFdY5goPBiLAkCzKlCkOvAQip/Op5aD6Vs+cNUTjFmC55JBxvp7WunZ45Ke2q0="
        },
        "body": {
        "resultInfo": {
        "resultStatus": "S",
        "resultCode": "0000",
        "resultMsg": "Success"
        },
        "txnToken": "fe795335ed3049c78a57271075f2199e1526969112097",
        "isPromoCodeValid": false,
        "authenticated": false
        }
        }*/


public class Body {

    @SerializedName("resultInfo")
    private ResultInfo resultInfo;

    @SerializedName("txnToken")
    private String txnToken;

    @SerializedName("isPromoCodeValid")
    private String isPromoCodeValid;

    @SerializedName("authenticated")
    private boolean authenticated;

    @SerializedName("extraParamsMap")
    private String extraParamsMap;

    public Body() {
    }

    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    public String getTxnToken() {
        return txnToken;
    }

    public void setTxnToken(String txnToken) {
        this.txnToken = txnToken;
    }

    public String getIsPromoCodeValid() {
        return isPromoCodeValid;
    }

    public void setIsPromoCodeValid(String isPromoCodeValid) {
        this.isPromoCodeValid = isPromoCodeValid;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getExtraParamsMap() {
        return extraParamsMap;
    }

    public void setExtraParamsMap(String extraParamsMap) {
        this.extraParamsMap = extraParamsMap;
    }
}
