package cat.dam.ivan.activity_en_memoria;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import android.widget.TextView;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //Array amb els noms de les persones que volem que apareguin al AutoCompleteTextView
    String[] noms = new String[]{
            "ADRIANA","AINA","ALBA","ALEXANDRA","ANDREA","ANNA","ARIADNA","AZIZA","BEATRIZ","BERTA",
            "BLANCA","CARLA","CARLOTA","CLARA","CLÀUDIA","CRISTINA","DELILA","DIANA","ELISABET",
            "ESTER","EVA","FÀTIMA","GEORGINA","HELENA", "HOUDA","INÉS","IRENE","JUDIT","JÚLIA",
            "KARIMA","LAIA","LORENA","MAR","MARIA","MARINA","MARTA","MIREIA","MÍRIA M","MÒNICA",
            "NATÀLIA","NEREA","NEUS","NOÈLIA","NÚRIA","OLAYA","PATRÍCIA","PAULA","QUERALT","RAQUEL",
            "SANDR A","SARA","SOFIA","SÍLVIA","SÒNIA","TURA","TÀNIA","ÚRSULA","VIOLETA","WASSIMA",
            "YASIRA","ZAFIRA","IVAN"
    };
    String nom;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment3 newInstance(String param1, String param2) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // recover data from the viewmodel
        MainViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_3, container, false);
        //boto que s'encarrega de posar el nom de la persona seleccionada al textview
        Button btn = root.findViewById(R.id.btn_14);

        //Creem un ArrayAdapter amb els noms de les persones i que desplegui els noms en un llistat
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, noms);
        //setContentView(R.layout.fragment_3);
        AutoCompleteTextView atv_Noms = root.findViewById(R.id.atv_Noms);
        atv_Noms.setAdapter(adapter);

//        if (savedInstanceState != null) {
//            nom = savedInstanceState.getString("nom");
        nom = mainViewModel.getname();
        TextView tv = root.findViewById(R.id.tv);
        tv.setText(nom);

        //Boto que quan es selecciona un nom del llistat, es posa al textview
        btn.setOnClickListener(view -> {
            // Agafar text del AutoCompleteTextView
            String valor = atv_Noms.getText().toString();

            // Mostrar el valor per pantalla
            tv.setText(valor);
            nom = tv.getText().toString();
            mainViewModel.setname(nom);

            // Treure el text del AutoComplete
            //source.setText("");
        });

        return root;

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        // No necessari
        //        bundle.putString("nom", nom);
        //        super.onSaveInstanceState(bundle);

    }
}
