package edu.unicauca.teclav_beta;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;

public class Producto {
    private int mImagenId;
    private String mId;
    private Location mLocalizacion;
    private String mDescripcion;
    private Double mPrecio;
    private boolean mNuevo;
    private boolean mEstado;
    private String mMarca;

    public Producto(int imagenId, String id, Location localizacion, String descripcion, Double precio, boolean nuevo, boolean estado,String marca) {
        this.mImagenId = imagenId;
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

    public int getmImagenId() {
        return mImagenId;
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

    public String getmDescripcion() {
        return mDescripcion;
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


    //  @BindingAdapter({"imageUrl"})
    //  public static void loadImage(ImageView view, String imageUrl) {
    //   Picasso.with(view.getContext()).load("https://falabella.scene7.com/is/image/Falabella/3850092_1?q=i?wid=1500&hei=1500&qlt=70"+imageUrl).into(view);
    //   }


}