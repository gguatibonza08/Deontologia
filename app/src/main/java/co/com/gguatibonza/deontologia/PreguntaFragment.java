package co.com.gguatibonza.deontologia;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntaFragment extends Fragment implements View.OnClickListener {
    private ImageView avatar;
    private String opcion;
    private Button rtaA, rtaB, rtaC, rtaD;


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
}
