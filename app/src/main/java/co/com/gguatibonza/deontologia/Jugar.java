package co.com.gguatibonza.deontologia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;

public class Jugar extends AppCompatActivity {
    private int avatar;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        realm = Realm.getDefaultInstance();

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
