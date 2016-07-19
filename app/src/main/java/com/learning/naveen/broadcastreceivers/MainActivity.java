package com.learning.naveen.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver mMessageReceiver = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Register mMessageReceiver to receive messages.
        registerReceiver(mMessageReceiver, new IntentFilter("com.learning.CUSTOM_INTENT"));
    }

    // broadcast a custom intent.
    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("com.learning.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    public void broadcastIntent2(View view){
        Intent intent = new Intent();
        intent.setAction("com.learning.naveen.CUSTOMINTENT2");
        sendBroadcast(intent);
    }

    public void deregister(View view){
        unregisterReceiver(mMessageReceiver);
    }

    public void reregister(View view){
        registerReceiver(mMessageReceiver, new IntentFilter("com.learning.CUSTOM_INTENT"));
    }
}
