package com.softulp.componentes.ui.gallery;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.softulp.componentes.R;

public class ServicioMusical extends Service {
    private MediaPlayer mp;

    public void onCreate(){

        mp=MediaPlayer.create(this, R.raw.musica_4_3);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mp.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}