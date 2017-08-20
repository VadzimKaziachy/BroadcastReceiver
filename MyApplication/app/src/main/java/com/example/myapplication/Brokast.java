package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static com.example.myapplication.MainActivity.KEY_INTENT_FILTER;
import static com.example.myapplication.MainActivity.KEY_VALUE_2;

/**
 * Created by Вадим on 20.08.2017.
 */

public class Brokast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int i = intent.getIntExtra(KEY_VALUE_2, -1);

        Intent intent1 = new Intent(KEY_INTENT_FILTER); //создаем интент и ложим в его ложим в его фильт
        intent1.putExtra(KEY_VALUE_2, i);
        context.sendBroadcast(intent1);
    }

}
