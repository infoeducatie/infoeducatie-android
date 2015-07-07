package com.infoeducatie.app.activities;

import android.app.Application;

import com.infoeducatie.app.helpers.FontHelper;

/**
 * Created by Browsing on 7/7/2015.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FontHelper.load(this);
    }
}
