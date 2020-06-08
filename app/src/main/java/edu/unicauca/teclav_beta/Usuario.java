package edu.unicauca.teclav_beta;

public class Usuario {
    private String mNombre="Andres";
    private String mContraseña="1234";
    private String mId="24";
    private String mCorreo="andresisman@hotmail.com";
    private int mFoto= R.drawable.ic_lavadora_azul_background;
    private String mTelefono;

    public Usuario(String nombre, String contraseña, String id, String correo, int foto, String telefono) {
        this.mNombre = nombre;
        this.mContraseña = contraseña;
        this.mId = id;
        this.mCorreo = correo;
        this.mFoto = foto;
        this.mTelefono = telefono;
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

    public String getmTelefono() {
        return mTelefono;
    }

}
