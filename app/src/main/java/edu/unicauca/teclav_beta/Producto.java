package edu.unicauca.teclav_beta;
import android.location.Location;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import java.io.Serializable;

public class Producto implements Serializable {
    private String mUrlImage;
    private String mId;
    private Location mLocalizacion;
    private String mDescripcion;
    private Double mPrecio;
    private boolean mEstado;
    private int mDisponible;
    private String mMarca;

    public Producto(String mUrlImage, String mId, Location mLocalizacion, String mDescripcion, Double mPrecio, boolean mEstado, int mDisponible, String mMarca) {
        this.mUrlImage = mUrlImage;
        this.mId = mId;
        this.mLocalizacion = mLocalizacion;
        this.mDescripcion = mDescripcion;
        this.mPrecio = mPrecio;
        this.mEstado = mEstado;
        this.mDisponible = mDisponible;
        this.mMarca = mMarca;
    }


    public String getmUrlImage() {
        return mUrlImage;
    }

    public String getmId() {
        return mId;
    }

    public Location getmLocalizacion() {
        return mLocalizacion;
    }

    public String getmDescripcion() {
        return mDescripcion;
    }

    public Double getmPrecio() {
        return mPrecio;
    }

    public boolean ismEstado() {
        return mEstado;
    }

    public int getmDisponible() {
        return mDisponible;
    }

    public String getmMarca() {
        return mMarca;
    }

    public String comprobarEstado() {
        if (mEstado == true) {
            return "Estado: Nuevo";
        } else {
            return "Estado:Segunda Mano";
        }

    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Producto)
            return (((Producto) obj).getmId().contentEquals(mId));
        else
            return false;
    }

    public String Dispinibilidad(){
        return "Disponibles:"+ String.valueOf(mDisponible);
    }

    public String DubleaPrecio() {
        return String.valueOf(mPrecio);
    }

    @BindingAdapter("android:src")
    public static void setImageUrl(ImageView view, String urlImage) {
        Glide.with(view.getContext()).
                load(urlImage).
                placeholder(R.drawable.ic_baseline_image_24).
                into(view);
    }
public int imagenToIn(){
        return Integer.parseInt(mUrlImage);
}


}