package com.example.ud5_ejemplo3;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private FragmentUno fragmentUno;
    private FragmentDos fragmentDos;
    private int fragmentMostrado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentUno = new FragmentUno();
        fragmentDos = new FragmentDos();

        // Prepareamos la transacción entre Fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Añadimos el Fragment uno
        fragmentTransaction.add(R.id.frameLayout, fragmentUno);

        // Antes del commit para poder volver a atrás
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();

        fragmentMostrado = 1;

        Button boton = findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Prepareamos la transacción entre Fragments
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if (fragmentMostrado == 1) {
                    // Reemplazamos por el Fragment dos
                    fragmentTransaction.replace(R.id.frameLayout, fragmentDos);
                    fragmentMostrado = 2;
                }
                else {
                    // Reemplazamos por el Fragment uno
                    fragmentTransaction.replace(R.id.frameLayout, fragmentUno);
                    fragmentMostrado = 1;
                }

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}
