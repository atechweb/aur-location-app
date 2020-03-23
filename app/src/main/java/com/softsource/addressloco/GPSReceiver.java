package com.softsource.addressloco;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Bundle;

public class GPSReceiver extends BroadcastReceiver {
    private final LocationCallBack locationCallBack;

    public void onCreate(Bundle savedInstance){
//---
      /*  registerReceiver(new GPSReceiver(new LocationCallBack() {
            @Override
            public void onLocationTriggered() {
                //Location state changed
            }
        }), new IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION));*/
//---
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().matches("android.location.PROVIDERS_CHANGED")) {
            locationCallBack.onLocationTriggered();
        }
    }

    public GPSReceiver(LocationCallBack iLocationCallBack){
        this.locationCallBack = iLocationCallBack;
    }

    public interface LocationCallBack {
        /**
         * on Location switch triggered
         */
        void onLocationTriggered();
    }
}
