package com.harry;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by Harry on 8/22/15.
 */
public class MyServiceImplementation extends Service {
    // this object is acting as Binder here
    MyService.Stub stub = new MyService.Stub() {
        @Override
        public String returnString(String string) throws RemoteException {
            return "hello"+string;
        }
    };
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return stub.asBinder();
    }
}
