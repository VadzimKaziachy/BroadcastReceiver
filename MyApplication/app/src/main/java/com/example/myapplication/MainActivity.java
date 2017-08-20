package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_INTENT_FILTER = "KEY_INTENT_FILTER"; //интернт фильтр
    public static final String KEY_VALUE = "KEY_VALUE"; //ключи


    public static final String KEY_VALUE_2 = "KEY_VALUE_2"; //ключи
    private static final Integer A = 5;

    private TextView tvTask1;
    private TextView tvTask2;
    private Button button;
    private BroadcastReceiver br;
    private BroadcastReceiver br2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews(); //иницилизируем
        setOnClickListeners();
        initBroadcast();// ловим брокаст
    }

    @Override
    protected void onStart() { //регестриуем блокст
        super.onStart();
        regReceiver();
    }

    @Override
    protected void onStop() { // дерегистриуем
        super.onStop();
        unregisterReceiver(br);
    }

    private void initBroadcast() {
        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.hasExtra(KEY_VALUE)) {
                    int task = intent.getIntExtra(KEY_VALUE, -1); //первое это ключ, а второе это значение по дефолту
                    tvTask1.setText(String.valueOf(task));
                } else if (intent.hasExtra(KEY_VALUE_2)) {
//                    int task = intent.getIntExtra(KEY_VALUE_2, -1); //первое это ключ, а второе это значение по дефолту
//                    tvTask2.setText(String.valueOf(task));
                }

            }
        };

    }

    private void initViews() {
        tvTask1 = (TextView) findViewById(R.id.tvTask1);
        tvTask2 = (TextView) findViewById(R.id.tvTask2);
        button = (Button) findViewById(R.id.btnStart);
    }


    private void regReceiver() { //регестрируем блокаст ресивер
        registerReceiver(br, new IntentFilter(KEY_INTENT_FILTER));
    }

    private void setOnClickListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.putExtra(KEY_VALUE, A);

                startService(new Intent(MainActivity.this, MyService.class));

//                посылаем в другой класс, прописываея фильтр в манифесте
                Intent intent1 = new Intent("potigpoppgitr");
                intent1.putExtra(KEY_VALUE_2, 5);

                sendBroadcast(intent1);
            }
        });
    }
     static class one extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            int a = intent.getIntExtra(KEY_VALUE_2, -1);

        }
    }
    //ретрофит2
}




