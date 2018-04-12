package co.com.gguatibonza.deontologia;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntaFragment extends Fragment {
    private ImageView avatar;
    private int opcion;


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
            opcion = bundle.getInt("avatar");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pregunta, container, false);

        avatar = root.findViewById(R.id.avatar);
        avatar.setImageDrawable(getResources().getDrawable(opcion));
        return root;
    }

}
