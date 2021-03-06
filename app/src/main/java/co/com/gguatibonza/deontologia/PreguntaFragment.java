package co.com.gguatibonza.deontologia;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntaFragment extends Fragment implements View.OnClickListener {
    private ImageView avatar;
    private String path;
    private static ArrayList<Pregunta> preguntas;
    private TextView textoPregunta;
    private Button rtaA, rtaB, rtaC, rtaD;
    private String urlAvatar;
    private DatabaseReference myDatabases;
    private Bundle bolsita;
    private Usuario user;
    private Pregunta temp;


    public PreguntaFragment() {
    }

    public static PreguntaFragment newInstance() {
        PreguntaFragment fragment = new PreguntaFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            path = bundle.getString("id");
        }
        myDatabases = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pregunta, container, false);

        avatar = root.findViewById(R.id.avatar);
        bolsita = new Bundle();
        rtaA = root.findViewById(R.id.rtaA);
        rtaB = root.findViewById(R.id.rtaB);
        rtaC = root.findViewById(R.id.rtaC);
        rtaD = root.findViewById(R.id.rtaD);

        textoPregunta = root.findViewById(R.id.Pregunta);

        rtaA.setOnClickListener(this);
        rtaB.setOnClickListener(this);
        rtaC.setOnClickListener(this);
        rtaD.setOnClickListener(this);

        myDatabases.child("usuario").child(path).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(Usuario.class);
                Log.e("aiuda", dataSnapshot.toString());
                myDatabases.child(user.getAvatar()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        urlAvatar = dataSnapshot.getValue().toString();
                        Picasso.get().load(urlAvatar).into(avatar);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                myDatabases.child("preguntas").child(user.getDificultadActual()).child(user.getActual() + "").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        temp = dataSnapshot.getValue(Pregunta.class);
                        user.getRespondidas().add(Integer.parseInt(dataSnapshot.getKey()));
                        textoPregunta.setText(temp.getContenido());
                        rtaA.setText(temp.getRespuestas().get(0).getContenido());
                        rtaB.setText(temp.getRespuestas().get(1).getContenido());
                        rtaC.setText(temp.getRespuestas().get(2).getContenido());
                        rtaD.setText(temp.getRespuestas().get(3).getContenido());
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


        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rtaA:
                validarRespuesta(0);
                break;
            case R.id.rtaB:
                validarRespuesta(1);
                break;
            case R.id.rtaC:
                validarRespuesta(2);
                break;
            case R.id.rtaD:
                validarRespuesta(3);
                break;
        }

    }

    private void validarRespuesta(int key) {
        if (user.getActual() == 6) {
            user.setDificultadActual("facil");
        }
        if (user.getActual() == 12) {
            user.setDificultadActual("dificil");
        }
        user.setActual(user.getActual() + 1);
        if (temp.getCorreta().getId() == temp.getRespuestas().get(key).getId()) {
            user.setPuntaje(user.getPuntaje() + temp.getPeso());
            user.setAvatar(user.getNombre() + "/aciertos/" + ((int) (Math.random() * 3 + 1)));
            Map<String, Object> postValues = user.toMap();
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("usuario/" + path, postValues);
            myDatabases.updateChildren(childUpdates);
            Bundle envio = new Bundle();
            envio.putString("id", user.getUsername());
            getContext().stopService(new Intent(getContext(), MyService.class));
            CorrectaFragment correcto = new CorrectaFragment();
            correcto.setArguments(envio);
            getFragmentManager()
                    .beginTransaction().replace(R.id.contenedor, correcto)
                    .commit();

        } else {
            user.setFallos(user.getFallos() + 1);
            user.setAvatar(user.getNombre() + "/equivocacion/" + user.getFallos());
            Map<String, Object> postValues = user.toMap();
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("usuario/" + path, postValues);
            myDatabases.updateChildren(childUpdates);

            Bundle incore = new Bundle();
            incore.putString("id", user.getUsername());
            incore.putString("explicacion", temp.getExplicacion());
            getContext().stopService(new Intent(getContext(), MyService.class));
            IncorrectoFragment incorrecto = new IncorrectoFragment();
            incorrecto.setArguments(incore);
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenedor, incorrecto)
                    .commit();
        }

    }
}
