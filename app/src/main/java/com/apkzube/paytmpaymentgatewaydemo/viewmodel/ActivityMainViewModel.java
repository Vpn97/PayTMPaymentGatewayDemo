package com.apkzube.paytmpaymentgatewaydemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

/**
 * PayTMPaymentGatewayDemo
 * Created by Vishal Nagvadiya on 21-06-2020.
 */
public class ActivityMainViewModel extends AndroidViewModel {

    private Application application;

    public ActivityMainViewModel(@NonNull Application application) {
        super(application);
        this.application=application;
    }
}
