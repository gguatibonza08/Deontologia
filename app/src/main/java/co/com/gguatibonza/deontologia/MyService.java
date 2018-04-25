package co.com.gguatibonza.deontologia;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private MediaPlayer md;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        md = MediaPlayer.create(this, R.raw.duranteotro);
        Log.e("inicio", "INICIO SERVICE");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        md.start();
        md.setLooping(true);
        Log.e("corriedno", "CORRIENDO SERVICE");
        return START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        md.stop();
        Log.e("detendio", "detener SERVICE");
    }
}
