package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import static com.example.myapplication.MainActivity.KEY_INTENT_FILTER;
import static com.example.myapplication.MainActivity.KEY_VALUE;

/**
 * Created by Вадим on 15.08.2017.
 */

public class MyService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Intent intent1 = new Intent(KEY_INTENT_FILTER); //создаем интент и ложим в его ложим в его фильт
        intent1.putExtra(KEY_VALUE, 100);
        sendBroadcast(intent1); //отправляем


        return START_NOT_STICKY; //говорим сервесу чтоб он не продолжал работу
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
