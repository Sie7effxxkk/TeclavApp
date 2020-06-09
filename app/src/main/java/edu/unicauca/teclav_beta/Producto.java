package edu.unicauca.teclav_beta;
import android.location.Location;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class Producto {
    private String mUrlImage;
    private String mId;
    private Location mLocalizacion;
    private String mDescripcion;
    private Double mPrecio;
    private boolean mNuevo;
    private boolean mEstado;
    private String mMarca;

    public Producto(String urlImage, String id, Location localizacion, String descripcion, Double precio, boolean nuevo, boolean estado,String marca) {
        this.mUrlImage = urlImage;
        this.mId = id;
        this.mLocalizacion = localizacion;
        this.mDescripcion = descripcion;
        this.mPrecio = precio;
        this.mNuevo = nuevo;
        this.mEstado = estado;
        this.mMarca = marca;
    }

    public Double getPrecio() {
        return mPrecio;
    }

    public String getmUrlImage() {
        return mUrlImage;
    }

    public boolean ismNuevo() {
        if (mNuevo == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ismEstado() {
        return mEstado;
    }

    public String getmMarca() {
        return mMarca;
    }

    public String getmId() {
        return mId;
    }

    public Location getmLocalizacion() {
        return mLocalizacion;
    }


    public Double getmPrecio() {
        return mPrecio;
    }



    public String getId() {
        return mId;
    }

    public Location getLocalizacion() {
        return mLocalizacion;
    }

    public String getDescripcion() {
        return mDescripcion;
    }




    public String esNuevo() {
        if (mNuevo == true) {
            return "Nuevo";
        } else {
            return "Segunda Mano";
        }

    }
    public String esEstado(){
        if (mEstado==true){
            return "En Venta";
        }else {
            return "Vendido";
        }

    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Producto)
            return (((Producto) obj).getId().contentEquals(mId));
        else
            return false;
    }


    public String DubleaTexto() {
        return String.valueOf(mPrecio);
    }

    @BindingAdapter("android:src")
    public static void setImageUrl(ImageView view, String urlImage) {
        Glide.with(view.getContext()).
                load(urlImage).
                placeholder(R.drawable.ic_baseline_image_24).
                into(view);
    }


}