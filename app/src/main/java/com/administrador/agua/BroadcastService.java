package com.administrador.agua;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;


public class BroadcastService extends Service {

    private String TAG = "BroadcastService";
    public static final String COUNTDOWN_BR = "com.administrador.agua";

    Intent intent = new Intent(COUNTDOWN_BR);

    CountDownTimer countDownTimer = null;

    @Override
    public void onCreate() {
        super.onCreate();
        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.i(TAG, "tiempo restante"+millisUntilFinished);
                intent.putExtra("CountDown", millisUntilFinished);
                sendBroadcast(intent);
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }

    @Override
    public void onDestroy() {
        countDownTimer.cancel();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
