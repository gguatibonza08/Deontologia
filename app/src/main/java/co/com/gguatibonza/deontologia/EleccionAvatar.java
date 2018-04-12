package co.com.gguatibonza.deontologia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EleccionAvatar extends AppCompatActivity implements View.OnClickListener {

    private CardView gian, nandy, leo, kolarte;
    private TextView seleccion;
    private LinearLayout textos;
    private Button continuar;
    private int avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion_avatar);

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
                avatar = R.drawable.gk;
                break;
            case R.id.nandy:
                seleccion.setText(getResources().getString(R.string.nandy));
                avatar = R.drawable.nandy;
                break;
            case R.id.leo:
                seleccion.setText(getResources().getString(R.string.leo));
                avatar = R.drawable.leo;
                break;
            case R.id.kolarte:
                seleccion.setText(getResources().getString(R.string.kolarte));
                avatar = R.drawable.kolarte;
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
