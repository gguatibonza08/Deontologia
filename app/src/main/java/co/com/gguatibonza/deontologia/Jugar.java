package co.com.gguatibonza.deontologia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class Jugar extends AppCompatActivity {
    private String avatar;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        avatar = getIntent().getStringExtra("avatar");
        bundle = new Bundle();
        bundle.putString("avatar", avatar);

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
