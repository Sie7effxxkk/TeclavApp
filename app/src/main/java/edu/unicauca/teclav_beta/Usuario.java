package edu.unicauca.teclav_beta;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import java.io.Serializable;

public class Usuario implements Serializable {
    //DATOS QUEMADOS
    private String mNombre="Andres";
    private String mContraseña="1234";
    private String mId="24";
    private String mCorreo="andresisman@hotmail.com";
    private int mFoto= R.mipmap.caradelchino;
    private String mTelefono;
    private String  mUrlImage="https://co.pinterest.com/pin/711076228641816822/";

    public Usuario(String mNombre, String mContraseña, String mId, String mCorreo, int mFoto, String mTelefono, String mUrlImage) {
        this.mNombre = mNombre;
        this.mContraseña = mContraseña;
        this.mId = mId;
        this.mCorreo = mCorreo;
        this.mFoto = mFoto;
        this.mTelefono = mTelefono;
        this.mUrlImage = mUrlImage;
    }

    public String getmUrlImage() {
        return mUrlImage;
    }

    public Usuario() {

    }


    public String getmNombre() {
        return mNombre;
    }

    public String getmContraseña() {
        return mContraseña;
    }

    public String getmId() {
        return mId;
    }

    public String getmCorreo() {
        return mCorreo;
    }

    public int getmFoto() {
        return mFoto;
    }





}
