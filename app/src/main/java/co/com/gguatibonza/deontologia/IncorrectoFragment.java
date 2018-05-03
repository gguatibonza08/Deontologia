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
public class IncorrectoFragment extends Fragment {

    private TextView explicacion;
    private ImageView imagenIncorrect;
    private String imagen, explication;
    private String path;
    private DatabaseReference myDatabases;
    private Usuario user;
    private Button boton;
    private MediaPlayer md;

    public IncorrectoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            path = bundle.getString("id");
            explication = bundle.getString("explicacion");
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boton.setVisibility(View.VISIBLE);
            }
        }, 1500);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_incorrecto, container, false);
        md = MediaPlayer.create(getContext(), R.raw.muerte);
        md.start();
        myDatabases = FirebaseDatabase.getInstance().getReference();
        explicacion = view.findViewById(R.id.traerExplicacion);
        imagenIncorrect = view.findViewById(R.id.imagenIncorrecta);
        boton = view.findViewById(R.id.continuarIncorrecta);

        myDatabases.child("usuario").child(path).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(Usuario.class);
                myDatabases.child(user.getAvatar()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        imagen = dataSnapshot.getValue().toString();
                        Picasso.get().load(imagen).into(imagenIncorrect);
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

        explicacion.setText(explication);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (user.getFallos() > 3) {
                    Intent i = new Intent(getContext(), Resultado.class);
                    i.putExtra("id", path);
                    startActivity(i);
                    getContext().stopService(new Intent(getContext(), MyService.class));
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
                    getContext().startService(new Intent(getContext(), MyService.class));
                }
            }
        });


        return view;


    }

}
