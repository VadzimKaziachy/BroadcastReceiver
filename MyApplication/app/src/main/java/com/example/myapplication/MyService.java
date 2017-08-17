package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Вадим on 15.08.2017.
 */

public class MyService extends Service {
    int i, c;

    public static final String NEW_CAT_DETECTED = "ru.alexanderklimov.action.NEW_CAT";




    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.i = intent.getIntExtra("ru.startandroid.develop.p0961servicebackbroadcast", 1);
        c =  1 + i;
        Intent intent1 = new Intent();
        intent1.setAction(NEW_CAT_DETECTED);
        intent1.putExtra("ru.alexanderklimov.broadcast.Message", c);
        intent1.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent1);
        return super.onStartCommand(intent, flags, startId);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
