package co.com.gguatibonza.deontologia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class Jugar extends AppCompatActivity {
    private String avatar;
    private Bundle bundle;
    private String path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        path=getIntent().getStringExtra("path");
        avatar = getIntent().getStringExtra("avatar");

        bundle = new Bundle();
        bundle.putString("avatar", avatar);
        bundle.putString("path", path);

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
