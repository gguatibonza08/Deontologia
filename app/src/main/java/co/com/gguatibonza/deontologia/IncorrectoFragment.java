package co.com.gguatibonza.deontologia;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class IncorrectoFragment extends Fragment {

    private TextView explicacion;
    private ImageView imagenIncorrect;
    private String explication,imagen;

    public IncorrectoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            explication = bundle.getString("explicacion");
            imagen=bundle.getString("imagenInCorrecta");
        }
        Picasso.get().load("imagenIncorrecta").into(imagenIncorrect);
        explicacion.setText(explication);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_incorrecto, container, false);

        explicacion=view.findViewById(R.id.traerExplicacion);
        imagenIncorrect=view.findViewById(R.id.imagenIncorrecta);

        // Inflate the layout for this fragment
        return  view;



    }

}
