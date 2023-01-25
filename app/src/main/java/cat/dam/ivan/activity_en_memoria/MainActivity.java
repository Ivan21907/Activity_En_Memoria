package cat.dam.ivan.activity_en_memoria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //botons que canviaran de fragment depenent del que es premi
        final Button btn_lyt1 = findViewById(R.id.btn_lyt1);
        final Button btn_lyt2 = findViewById(R.id.btn_lyt2);
        final Button btn_lyt3 = findViewById(R.id.btn_lyt3);

        //mainViewModel = new MainViewModel();//no es pot fer aixi, cal fer-ho amb el ViewModelProvider
        //MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);//No es crea un nou MainViewModel, sino que es recupera el que ja existeix

        //fragment que mostrarem si el botó 1 es prem
        btn_lyt1.setOnClickListener(v ->
        {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragment1 fragment1 = new Fragment1();
            transaction.replace(R.id.fragment_container_view, fragment1);
            transaction.commit();

        });

        //fragment que mostrarem si el botó 2 es prem
        btn_lyt2.setOnClickListener(v ->
        {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragment2 fragment2 = new Fragment2();
            transaction.replace(R.id.fragment_container_view, fragment2);
            transaction.commit();

        });

        //fragment que mostrarem si el botó 3 es prem
        btn_lyt3.setOnClickListener(v ->
        {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragment3 fragment3 = new Fragment3();
            transaction.replace(R.id.fragment_container_view, fragment3);
            transaction.commit();

        });

    }

}