package com.marcosledesma.ejemplo05listview.modelos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Nota implements Parcelable {
    private String titulo;
    private String contenido;
    private Date fecha;

    public Nota(String titulo, String contenido, Date fecha) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public Nota() {
    }

    protected Nota(Parcel in) {
        titulo = in.readString();
        contenido = in.readString();
        // Para la fecha hacemos lo siguiente: (Montarla a partir de un TimeStamp)
        fecha = new Date(in.readLong());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(contenido);
        // Para la fecha hacemos writeLong
        dest.writeLong(fecha.getTime());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Nota> CREATOR = new Creator<Nota>() {
        @Override
        public Nota createFromParcel(Parcel in) {
            return new Nota(in);
        }

        @Override
        public Nota[] newArray(int size) {
            return new Nota[size];
        }
    };

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
