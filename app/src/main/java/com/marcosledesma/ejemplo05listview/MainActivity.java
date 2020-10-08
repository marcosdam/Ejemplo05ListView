package com.marcosledesma.ejemplo05listview;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.marcosledesma.ejemplo05listview.adapters.NotasAdapter;
import com.marcosledesma.ejemplo05listview.modelos.Nota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // 1. CONJUNTO DE DATOS
    private ArrayList<Nota> listaNotas;
    // 2. PLANTILLA DE LOS ELEMENTOS (carpeta layout -> new LayoutResourceFile
    private int plantillaFilas;
    // 3. ADAPTER para ListView
    private ListView listView;
    // 4. CLASE INDEPENDIENTE DEL TIPO ADAPTER
    private NotasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = inicializaDatos();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private FloatingActionButton inicializaDatos() {
        listaNotas = new ArrayList<>();
        plantillaFilas = R.layout.fila_nota;
        listView = findViewById(R.id.contenedorMain);
        adapter = new NotasAdapter(this, plantillaFilas, listaNotas);
        // Asociamos ListView y Adapter
        listView.setAdapter(adapter);
        return findViewById(R.id.fab);
    }

}