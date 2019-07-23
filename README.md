# Ud5_Ejemplo3
_Ejemplo 3 de la Unidad 5._ 

En este ejemplo vamos a añadir y borrar _Fragments_ del _layout_, donde tendremos un botón con el que iremos cambiando entre un _Fragment_ y otro.
Para ello vamos a basarnos en [Ud5_Ejemplo2](https://github.com/Fpcarlosc/Ud5_Ejemplo2). Los ficheros _fragment_uno.xml_, _fragment_dos.xml_, 
_FragmentUno.java_ y _FragmentDos.java_ serán idénticos.

## _activity_main.xml_

Creamos un _layout_ compuesto por un _FrameLayout_ donde se mostrará el _Fragment_ y un botón para cambiar de uno a otro.

```
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <FrameLayout
        android:id="@+id/frameLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_alignParentTop="true"
        app:layout_constraintBottom_toTopOf="@+id/boton">

    </FrameLayout>

    <Button
        android:id="@+id/boton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerInParent="true"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginBottom="32dp"
        android:text="@string/cambiar"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

</android.support.constraint.ConstraintLayout>
```

## _MainActivity.java_

En la actividad principal crearemos los dos Fragments y utilizaremos las clases FragmentManager_ y _FragmentTransaction_ para 
gestionar el cambio de un _Fragment_ a otro, añadiéndolos (_add_) y eliminándolos (_replace_) de la transacción y posteriormente 
confirmando la acción (_commit_).

Antes de hacer _commit_ es interesante llamar al método _addToBackStack_ para añadir la transacción a una pila de retroceso de tal 
forma que si el usuario pulsa el botón _Atrás_ puede volver a un estado anterior.

Además implementaremos el evento del botón para controlar qué _Fragment_ es el siguiente a mostrar.
```
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

```
