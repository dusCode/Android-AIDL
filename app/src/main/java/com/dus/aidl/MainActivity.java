package com.dus.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private IRemoteService mRemoteService = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        tv.setText("the client pid is " + Process.myPid());
        Intent intent = new Intent(this,RemoteService.class);
        this.bindService(intent,mConnection,BIND_AUTO_CREATE);
    }

    private ServiceConnection mConnection= new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mRemoteService = (IRemoteService) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };


    public void hello(View view) throws RemoteException {
        Log.i("MainActivity","sayHello:"+mRemoteService.sayHello().getMsg());
    }

    public void showServicePid(View view) throws RemoteException {
        Log.i("MainActivity","servicePid:"+mRemoteService.sayHello().getId());
    }

}
