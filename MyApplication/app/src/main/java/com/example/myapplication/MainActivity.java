package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    final String LOG_TAG = "myLogs";

    final int TASK1_CODE = 1;
    final int TASK2_CODE = 2;
    final int TASK3_CODE = 3;

    public final static int STATUS_START = 100;
    public final static int STATUS_FINISH = 200;

    public final static String PARAM_TIME = "time";
    public final static String PARAM_TASK = "task";
    public final static String PARAM_RESULT = "result";
    public final static String PARAM_STATUS = "status";

    public final static String BROADCAST_ACTION = "ru.startandroid.develop.p0961servicebackbroadcast";
    public static final String NEW_CAT_DETECTED = "ru.alexanderklimov.action.NEW_CAT";


    TextView tvTask1;
    TextView tvTask2;
    TextView tvTask3;
    BroadcastReceiver br;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        br = new BroadcastReceiver(){

            @Override
            public void onReceive(Context context, Intent intent) {
                int task = intent.getIntExtra("ru.alexanderklimov.broadcast.Message",1);
                tvTask1 = (TextView) findViewById(R.id.tvTask1);
                tvTask1.setText(task);
                tvTask2 = (TextView) findViewById(R.id.tvTask2);
                tvTask2.setText(MyService.c);

            }
        };
        IntentFilter intFilt = new IntentFilter(NEW_CAT_DETECTED);
        // регистрируем (включаем) BroadcastReceiver
        registerReceiver(br, intFilt);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // дерегистрируем (выключаем) BroadcastReceiver
        unregisterReceiver(br);
    }

     public void onClickStart(View view){
         startService(new Intent(this, MyService.class).putExtra("ru.startandroid.develop.p0961servicebackbroadcast", TASK1_CODE));
     }

}



