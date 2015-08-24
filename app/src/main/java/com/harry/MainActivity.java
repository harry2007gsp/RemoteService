package com.harry;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MyService myService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void connect(View view) {
        Intent intent = new Intent(this, MyServiceImplementation.class);
        bindService(intent, serviceConnection, 1);
    }

    public void use(View view) {
        try {
            Log.d("test", myService.returnString("mister"));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(View view) {
        unbindService(serviceConnection);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("test", "connected");
            myService = (MyService)service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("test", "disconnected");
        }
    };

}
