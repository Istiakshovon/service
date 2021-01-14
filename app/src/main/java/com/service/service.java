package com.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class service extends Service {

    // declaring object of MediaPlayer
    private MediaPlayer player;

    public service() {
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        onTaskRemoved(intent);
        Toast.makeText(getApplicationContext(),"This is a Service running in Background",
                Toast.LENGTH_SHORT).show();
        player = MediaPlayer.create(getApplicationContext(),R.raw.ringtone);
        player.start();
        startForegroundService(intent);
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Intent restartServiceIntent = new Intent(getApplicationContext(),this.getClass());
        restartServiceIntent.setPackage(getPackageName());
        startService(restartServiceIntent);
        super.onTaskRemoved(rootIntent);
    }
    @Override
    public ComponentName startForegroundService(final Intent service) {
        return startForegroundService(service);
    }
}