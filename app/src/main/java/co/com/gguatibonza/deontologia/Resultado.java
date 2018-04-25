package co.com.gguatibonza.deontologia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Resultado extends AppCompatActivity {
    private String id, foto;
    private ImageView imagen;
    private TextView texo;
    private DatabaseReference myDatabases;
    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        myDatabases = FirebaseDatabase.getInstance().getReference();
        id = getIntent().getStringExtra("id");
        imagen = findViewById(R.id.imagenFinal);
        texo = findViewById(R.id.puntosFinales);

        myDatabases.child("usuario").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(Usuario.class);
                myDatabases.child(user.getAvatar()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        foto = dataSnapshot.getValue().toString();
                        Picasso.get().load(foto).into(imagen);
                        texo.setText(user.getPuntaje() + "");
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


    }
}
