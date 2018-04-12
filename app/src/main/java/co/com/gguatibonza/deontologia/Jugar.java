package co.com.gguatibonza.deontologia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class Jugar extends AppCompatActivity {
    private int avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        avatar = getIntent().getIntExtra("avatar", 0);
        Bundle bundle = new Bundle();
        bundle.putInt("avatar", avatar);

        Fragment pregunta = PreguntaFragment.newInstance();
        pregunta.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedor, pregunta);
        transaction.commit();
    }

}
