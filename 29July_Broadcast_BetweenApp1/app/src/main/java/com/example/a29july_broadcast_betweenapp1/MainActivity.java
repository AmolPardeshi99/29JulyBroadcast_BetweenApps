package com.example.a29july_broadcast_betweenapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mbnGoNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbnGoNext = findViewById(R.id.btnGonext);
        mbnGoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.broadcast.betweenApps");
                intent.putExtra("name","This is messsage from App-1");
                sendBroadcast(intent);
            }
        });
    }
}