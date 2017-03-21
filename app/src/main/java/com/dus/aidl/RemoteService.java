package com.dus.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by dusheng on 2017/3/21.
 */
public class RemoteService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private IRemoteService.Stub mBinder = new IRemoteService.Stub() {
        @Override
        public HelloMsg sayHello() throws RemoteException {
            return new HelloMsg("msg from service at Thread " + Thread.currentThread().toString() + "\n" +
                    "tid is " + Thread.currentThread().getId() + "\n" +
                    "main thread id is " + getMainLooper().getThread().getId(), Process.myPid());
        }
    };

}
