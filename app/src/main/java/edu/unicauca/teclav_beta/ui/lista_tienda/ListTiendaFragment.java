package edu.unicauca.teclav_beta.ui.lista_tienda;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.unicauca.teclav_beta.Producto;
import edu.unicauca.teclav_beta.R;

/**
 * A fragment representing a list of Items.
 */
public class ListTiendaFragment extends Fragment {
    private  ArrayList<Producto> mProducto =new ArrayList<>();

    RecyclerView recyclerViewTienda;
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListTiendaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListTiendaFragment newInstance(int columnCount) {
        ListTiendaFragment fragment = new ListTiendaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_tienda, container, false);
        recyclerViewTienda =(RecyclerView) view.findViewById(R.id.list);
        recyclerViewTienda.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();
        MyItemRecyclerViewAdapter adapter=new MyItemRecyclerViewAdapter(mProducto);
        recyclerViewTienda.setAdapter(adapter);
        // Set the adapter
        /*if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(mProductos, DummyContent.ITEMS));
        }

         */
        return view;
    }

    private void llenarLista() {
        mProducto.add(new Producto(R.drawable.ic_lavadora_azul_background, "1", null, "Lava muy bien,", 800.000, true, false, "Samsung"));
        mProducto.add(new Producto(R.mipmap.ic_lavadora_azul, "2", null, "apenas para la abuela, que mucho lava", 9000.00, true, true, "LG"));
        mProducto.add(new Producto(R.mipmap.ic_lavadora_azul_round, "3", null, "la vendo por necesidad, ayuda plis!", 100000.00, false, true, "Central"));
        //mProducto.add(new Producto(R.mipmap.ic_lavadora_frontal_gris, "4", null, "suena muy rara,pero lava claro ", 16000.00, false, true, "Home"));
        //mProducto.add(new Producto(R.mipmap.ic_lavadora_wirlpool, "5", null, "de las mejores del mercado", 1000.00, true, true, "Wirlpool"));
    }
}