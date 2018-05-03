package co.com.gguatibonza.deontologia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class EleccionAvatar extends AppCompatActivity implements View.OnClickListener {

    private CardView gian, nandy, leo, kolarte;
    private ImageView Igian, Inandy, Ileo, Ikolarte;
    private String path, aux;
    private Button continuar;
    private String name;
    private DatabaseReference myDatabases;
    private TextInputEditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion_avatar);
        myDatabases = FirebaseDatabase.getInstance().getReference();
        username = findViewById(R.id.nombreUsuario);
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
                path = "gk/original";
                aux = "gk";
                break;
            case R.id.nandy:
                path = "nandy/original";
                aux = "nandy";
                break;
            case R.id.leo:
                path = "leo/original";
                aux = "leo";
                break;
            case R.id.kolarte:
                path = "Kolarte/original";
                aux = "Kolarte";
                break;
            case R.id.continuar:
                name = username.getText().toString();
                Usuario usuario = new Usuario(0, path, aux, 0, "medio", 1, name);
                Intent i = new Intent(getApplicationContext(), Jugar.class);
                i.putExtra("id", usuario.getUsername());
                myDatabases.child("usuario").child(usuario.getUsername()).setValue(usuario);
                startActivity(i);
                break;


        }
        continuar.setVisibility(View.VISIBLE);
    }
}
