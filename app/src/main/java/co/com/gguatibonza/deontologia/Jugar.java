package co.com.gguatibonza.deontologia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Jugar extends AppCompatActivity {
    private Bundle bundle;
    private String id;
    private TextView puntos;
    private DatabaseReference myDatabases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        puntos = findViewById(R.id.traerPuntaje);
        myDatabases = FirebaseDatabase.getInstance().getReference();


        id = getIntent().getStringExtra("id");
        bundle = new Bundle();
        bundle.putString("id", id);

        Fragment pregunta = PreguntaFragment.newInstance();
        pregunta.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedor, pregunta);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        Fragment pregunta = PreguntaFragment.newInstance();
        pregunta.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedor, pregunta);
        transaction.commit();
    }

}
