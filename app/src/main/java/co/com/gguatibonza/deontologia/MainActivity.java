package co.com.gguatibonza.deontologia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button jugar, acerca, como;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jugar = findViewById(R.id.MainJugar);
        como = findViewById(R.id.MainComo);
        acerca = findViewById(R.id.MainAcerca);
        //   md.setLooping(true);
        jugar.setOnClickListener(this);
        como.setOnClickListener(this);
        acerca.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.MainJugar:
                Intent i = new Intent(this, EleccionAvatar.class);
                startActivity(i);
                break;
            case R.id.MainComo:
                Intent j = new Intent(this, ComoJugar.class);
                startActivity(j);
                break;
            case R.id.MainAcerca:
                Intent k = new Intent(this, AcercaDe.class);
                startActivity(k);
                break;
        }
    }
}
