package co.com.gguatibonza.deontologia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AcercaDe extends AppCompatActivity {

    private CardView gian, nandy, leo, kolarte;
    private ImageView Igian, Inandy, Ileo, Ikolarte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        Igian = findViewById(R.id.gianAcerca);
        Inandy = findViewById(R.id.nandyAcerca);
        Ileo = findViewById(R.id.leoAcerca);
        Ikolarte = findViewById(R.id.kolarteAcerca);

        Picasso.get().load("https://i.imgur.com/EYadhi1.png").into(Igian);
        Picasso.get().load("https://i.imgur.com/darPqBv.png").into(Inandy);
        Picasso.get().load("https://i.imgur.com/L4beccz.png").into(Ileo);
        Picasso.get().load("https://i.imgur.com/rve4RZ8.png").into(Ikolarte);

        gian = findViewById(R.id.gian);
        leo = findViewById(R.id.leo);
        kolarte = findViewById(R.id.kolarte);
        nandy = findViewById(R.id.nandy);


    }
}
