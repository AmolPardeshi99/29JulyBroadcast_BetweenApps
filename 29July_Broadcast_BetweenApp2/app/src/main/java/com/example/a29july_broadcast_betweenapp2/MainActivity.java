package com.example.a29july_broadcast_betweenapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTvMessage;
    private BroadcastReceiverfromApp receiverfromApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiverfromApp = new BroadcastReceiverfromApp();
        mTvMessage =findViewById(R.id.tvMessage);
        IntentFilter intentFilter = new IntentFilter("com.broadcast.betweenApps");
        registerReceiver(receiverfromApp,intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiverfromApp);
    }

    public class BroadcastReceiverfromApp extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent != null){
                String name  = intent.getStringExtra("name");
                mTvMessage.setText(name);
            }
        }
    }

}