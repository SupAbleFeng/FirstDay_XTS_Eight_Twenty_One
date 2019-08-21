package com.example.fcy.firstday_xts_eight_twenty_one;

import android.app.Application;
import android.content.Context;

/**
 * Created by fcy on 2019/8/21.
 */

public class App extends Application{
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
         context = getApplicationContext();
    }
}
