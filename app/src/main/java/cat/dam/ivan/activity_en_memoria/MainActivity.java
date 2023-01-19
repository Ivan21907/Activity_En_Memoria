package cat.dam.ivan.activity_en_memoria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //botons que canviaran de fragment depenent del que es premi
        final Button btn_lyt1 = findViewById(R.id.btn_lyt1);
        final Button btn_lyt2 = findViewById(R.id.btn_lyt2);
        final Button btn_lyt3 = findViewById(R.id.btn_lyt3);

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