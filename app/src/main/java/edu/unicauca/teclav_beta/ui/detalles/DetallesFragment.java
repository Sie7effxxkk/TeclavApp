package edu.unicauca.teclav_beta.ui.detalles;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import edu.unicauca.teclav_beta.ConfirmarCompra;
import edu.unicauca.teclav_beta.Producto;
import edu.unicauca.teclav_beta.databinding.FragmentDatallesBinding;

import edu.unicauca.teclav_beta.R;

/*
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetallesFragment extends Fragment   {
    TextView marca_detalle,precio_detalle,descripcion_detalle,estado_detalle,disponibles_detalle;
    ImageView imgen_detalle;
    FragmentDatallesBinding  binding;
    private boolean login= true;
    //Comprobar estado de login
    public void setLogin(boolean login) {
        this.login = login;
    }

    public boolean isLogin() {
        return login;
    }

    Producto producto;


    public DetallesFragment() {

    }
//crea la vista del fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflamos la inforacion que viene del databinding y llenar la lista
        binding = FragmentDatallesBinding.inflate(LayoutInflater.from(container.getContext()),container,false);
        final Bundle obProducto= getArguments();
        producto =(Producto) obProducto.getSerializable("objeto");
        binding.setProducto(producto);
        binding.executePendingBindings();
        View view = binding.getRoot();
        //Asignamos el boto de compra
        Button bComprar = view.findViewById(R.id.button_comprar);
        bComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Atrapa y emvia los datos en un intent , a su vez inician la siguiente actividad
                Intent i = new Intent(getActivity(), ConfirmarCompra.class);
                i.putExtra("PRECIO",producto.DubleaPrecio());
                i.putExtra("TITULO",producto.getmTitulo());
                startActivity(i);
            }
        });
        return view;
    }
}