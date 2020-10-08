package com.marcosledesma.ejemplo05listview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.marcosledesma.ejemplo05listview.R;
import com.marcosledesma.ejemplo05listview.modelos.Nota;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NotasAdapter extends ArrayAdapter<Nota> {

    /**
     * HEREDAMOS SUPER DE LA CLASE ADAPTER, CON EL CONSTRUCTOR DE ESTOS 3 ATRIBUTOS:
     * @param context -> Sirve para saber qué actividad está montando el listado
     * @param resource -> Es la plantilla para ir mostrando cada nota
     * @param objects -> Es el conjunto de elementos que voy a mostrar
     */

    // Los definimos
    private Context context;
    private int resource;
    private ArrayList<Nota> objects;

    // Modificamos el tercer parámetro para que reciba ArrayList en lugar de List
    public NotasAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Nota> objects) {
        super(context, resource, objects);
        //Inicializamos las variables
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    // Implementamos método getView y borramos la llamada al padre (return super.getView)
    /**
     *
     * @param position -> Elemento del Array en el que estoy
     * @param convertView -> El View que devuelve (filaNotas)
     * @param parent ->
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obtenemos la fila
        View filaNota = LayoutInflater.from(context).inflate(resource, null);
        // La sacamos
        Nota nota = objects.get(position);

        TextView txtTitulo = filaNota.findViewById(R.id.txtTituloFilaNota);
        TextView txtFecha = filaNota.findViewById(R.id.txtFechaFilaNota);

        txtTitulo.setText(nota.getTitulo());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtFecha.setText(simpleDateFormat.format(nota.getFecha()));

        return filaNota;
    }
}
