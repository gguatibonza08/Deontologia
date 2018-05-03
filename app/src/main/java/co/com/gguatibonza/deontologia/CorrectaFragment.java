package co.com.gguatibonza.deontologia;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class CorrectaFragment extends Fragment {
    private ImageView correcto;
    private TextView puntaje;
    private DatabaseReference myDatabases;
    private MediaPlayer md;
    private String path;
    private Usuario user;
    private String urlAvatar;
    private Button siguiente;


    public CorrectaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            path = bundle.getString("id");
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                siguiente.setVisibility(View.VISIBLE);
            }
        }, 1500);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_correcta, container, false);
        md = MediaPlayer.create(getContext(), R.raw.gana);
        md.start();
        myDatabases = FirebaseDatabase.getInstance().getReference();
        correcto = root.findViewById(R.id.imagenCorrecta);
        puntaje = root.findViewById(R.id.traerPuntaje);
        siguiente = root.findViewById(R.id.siguientePregunta);


        myDatabases.child("usuario").child(path).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(Usuario.class);
                puntaje.setText(user.getPuntaje() + "");
                myDatabases.child(user.getAvatar()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        urlAvatar = dataSnapshot.getValue().toString();
                        Picasso.get().load(urlAvatar).into(correcto);

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

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getRespondidas().size() == 10) {
                    Intent i = new Intent(getContext(), Resultado.class);
                    i.putExtra("id", path);
                    startActivity(i);
                    getActivity().finish();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("id", path);
                    PreguntaFragment pregunta = new PreguntaFragment();
                    pregunta.setArguments(bundle);
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contenedor, pregunta)
                            .commit();

                }
            }
        });

        return root;
    }

}
