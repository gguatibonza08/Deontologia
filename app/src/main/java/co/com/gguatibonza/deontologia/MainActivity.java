package co.com.gguatibonza.deontologia;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MediaPlayer md;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        md = MediaPlayer.create(this, R.raw.juego);
        md.start();
        md.setLooping(true);
    }
}
