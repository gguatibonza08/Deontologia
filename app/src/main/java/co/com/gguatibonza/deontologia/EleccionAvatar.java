package co.com.gguatibonza.deontologia;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class EleccionAvatar extends AppCompatActivity implements View.OnClickListener {

    private CardView gian, nandy, leo, kolarte;
    private ImageView Igian, Inandy, Ileo, Ikolarte;
    private String path;
    private TextView seleccion;
    private LinearLayout textos;
    private Button continuar;
    MediaPlayer md;
    private String name;
    private DatabaseReference myDatabases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion_avatar);
        myDatabases = FirebaseDatabase.getInstance().getReference();
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
                path = "gk/original";
                name = "gk";
                break;
            case R.id.nandy:
                seleccion.setText(getResources().getString(R.string.nandy));
                path = "nandy/original";
                name = "nandy";
                break;
            case R.id.leo:
                seleccion.setText(getResources().getString(R.string.leo));
                path = "leo/original";
                name = "leo";
                break;
            case R.id.kolarte:
                seleccion.setText(getResources().getString(R.string.kolarte));
                path = "Kolarte/original";
                name = "Kolarte";
                break;
            case R.id.continuar:

                Usuario usuario = new Usuario((int) (Math.random() * 1000 + 1), 0, path, name, 0);
                Intent i = new Intent(getApplicationContext(), Jugar.class);
                i.putExtra("id", usuario.getId() + "");
                myDatabases.child("usuario").child(usuario.getId() + "").setValue(usuario);
                startActivity(i);
                break;


        }
        textos.setVisibility(View.VISIBLE);
        continuar.setVisibility(View.VISIBLE);
    }


}
