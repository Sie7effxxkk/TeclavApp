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

import edu.unicauca.teclav_beta.Producto;
import edu.unicauca.teclav_beta.databinding.FragmentDatallesBinding;

import edu.unicauca.teclav_beta.R;
import edu.unicauca.teclav_beta.MenuLoginActivity;

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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetallesFragment() {
        // Required empty public constructor
    }

  /*  /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompraFragment.
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDatallesBinding.inflate(LayoutInflater.from(container.getContext()),container,false);
        Bundle obProducto= getArguments();
        final Producto producto;
        producto =(Producto) obProducto.getSerializable("objeto");
        binding.setProducto(producto);
        binding.executePendingBindings();
        View view = binding.getRoot();

      /*  marca_detalle = view.findViewById(R.id.marca_detalle);
        descripcion_detalle=view.findViewById(R.id.descripcion_detalle);
        precio_detalle=view.findViewById(R.id.descripcion_detalle);
        estado_detalle=view.findViewById(R.id.estado_detalles);
        disponibles_detalle=view.findViewById(R.id.descripcion_detalle);
        imgen_detalle=view.findViewById(R.id.imageView3);
       if (producto==null){

            marca_detalle.setText(producto.getmMarca());
            descripcion_detalle.setText(producto.getmDescripcion());
            precio_detalle.setText(producto.DubleaPrecio());
            estado_detalle.setText(producto.comprobarEstado());
           disponibles_detalle.setText(producto.Dispinibilidad());
           imgen_detalle.setImageResource(integer.);
       }

       */
        Button bComprar = view.findViewById(R.id.button_comprar);
        bComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MenuLoginActivity.class);
                startActivity(i);

            }
        });


      return view;
    }



}