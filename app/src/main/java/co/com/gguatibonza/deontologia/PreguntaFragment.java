package co.com.gguatibonza.deontologia;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntaFragment extends Fragment implements View.OnClickListener {
    private ImageView avatar;
    private String opcion;
    private TextView textoPregunta;
    private Button rtaA, rtaB, rtaC, rtaD;
    private ArrayList<Pregunta> preguntas;

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
            opcion = bundle.getString("avatar");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pregunta, container, false);
        rtaA = root.findViewById(R.id.rtaA);
        rtaB = root.findViewById(R.id.rtaB);
        rtaC = root.findViewById(R.id.rtaC);
        rtaD = root.findViewById(R.id.rtaD);
        textoPregunta = root.findViewById(R.id.Pregunta);


        int auxiliar = (int) (Math.random() * 10);
        Pregunta temp = preguntas.get(auxiliar);

        textoPregunta.setText(temp.getContenido());
        rtaA.setText(temp.getRespuestas().get(0).getContenido());
        rtaB.setText(temp.getRespuestas().get(1).getContenido());
        rtaC.setText(temp.getRespuestas().get(2).getContenido());
        rtaD.setText(temp.getRespuestas().get(3).getContenido());

        rtaA.setOnClickListener(this);
        rtaB.setOnClickListener(this);
        rtaC.setOnClickListener(this);
        rtaD.setOnClickListener(this);

        avatar = root.findViewById(R.id.avatar);
        Picasso.get().load(opcion).into(avatar);
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rtaA:
                CorrectaFragment correcto = new CorrectaFragment();
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor, correcto)
                        .commit();
                break;
            default:

                IncorrectoFragment incorrecto = new IncorrectoFragment();
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor, incorrecto)
                        .commit();
                break;
        }

    }

    private void llenar() {
        preguntas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * 4);

            Pregunta pregunta = new Pregunta();

            for (int j = 0; j < 4; j++) {
                Respuesta respuesta = new Respuesta();
                respuesta.setId(j + 1);
                respuesta.setContenido("RESPUESTA " + (j + 1));
                if (j == random) {
                    respuesta.setValidar("correcto");
                    pregunta.setCorreta(respuesta);
                } else {
                    respuesta.setValidar("incorrecto");
                }
                pregunta.getRespuestas().add(respuesta);
            }
            pregunta.setId(i);
            pregunta.setContenido("PREGUNTA " + i);
            int aleatorio = (int) (Math.random() * 3 + 1);
            switch (aleatorio) {
                case 1:
                    pregunta.setDificultad("FACIL");
                    pregunta.setPeso(1);
                    break;
                case 2:
                    pregunta.setDificultad("DIFICIL");
                    pregunta.setPeso(5);
                    break;
                case 3:
                    pregunta.setDificultad("MEDIO");
                    pregunta.setPeso(3);
                    break;
            }
            preguntas.add(pregunta);

        }
    }


}
