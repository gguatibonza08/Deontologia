package co.com.gguatibonza.deontologia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

public class EleccionAvatar extends AppCompatActivity implements View.OnClickListener {

    private CardView gian, nandy, leo, kolarte;
    private ImageView Igian, Inandy, Ileo, Ikolarte;
    private TextView seleccion;
    private LinearLayout textos;
    private Button continuar;
    private String avatar;
    private DatabaseReference myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion_avatar);

        Igian = findViewById(R.id.ImagenGian);
        Inandy = findViewById(R.id.ImagenNandy);
        Ileo = findViewById(R.id.ImagenLeo);
        Ikolarte = findViewById(R.id.ImagenKolarte);

        Picasso.get().load("https://i.imgur.com/EYadhi1.png").into(Igian);
        Picasso.get().load("https://i.imgur.com/darPqBv.png").into(Inandy);
        Picasso.get().load("https://i.imgur.com/L4beccz.png").into(Ileo);
        Picasso.get().load("https://i.imgur.com/rve4RZ8.png").into(Ikolarte);

        gian = findViewById(R.id.gian);
        leo = findViewById(R.id.leo);
        kolarte = findViewById(R.id.kolarte);
        nandy = findViewById(R.id.nandy);
        seleccion = findViewById(R.id.seleccion);
        textos = findViewById(R.id.textos);
        continuar = findViewById(R.id.continuar);

        gian.setOnClickListener(this);
        leo.setOnClickListener(this);
        kolarte.setOnClickListener(this);
        nandy.setOnClickListener(this);
        continuar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.gian:
                seleccion.setText(getResources().getString(R.string.gk));
                avatar = "https://i.imgur.com/EYadhi1.png";

                break;
            case R.id.nandy:
                seleccion.setText(getResources().getString(R.string.nandy));
                avatar = "https://i.imgur.com/darPqBv.png";
                break;
            case R.id.leo:
                seleccion.setText(getResources().getString(R.string.leo));
                avatar = "https://i.imgur.com/L4beccz.png";
                break;
            case R.id.kolarte:
                seleccion.setText(getResources().getString(R.string.kolarte));
                avatar = "https://i.imgur.com/rve4RZ8.png";
                break;
            case R.id.continuar:
                Intent i = new Intent(getApplicationContext(), Jugar.class);
                i.putExtra("avatar", avatar);
                startActivity(i);
                break;


        }
        textos.setVisibility(View.VISIBLE);
        continuar.setVisibility(View.VISIBLE);
    }


}
