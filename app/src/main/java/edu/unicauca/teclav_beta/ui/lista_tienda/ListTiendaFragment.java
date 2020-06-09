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

   private RecyclerView recyclerViewTienda;
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
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(mProducto, DummyContent.ITEMS));
        }

         */


        return view;
    }

    private void llenarLista() {
        mProducto.add(new Producto("https://media.aws.alkosto.com/media/catalog/product/cache/6/image/69ace863370f34bdf190e4e164b6e123/8/8/8806088921914_003.jpg" , "1", null, "Lava muy bien,", 800.000, true, false, "Samsung"));
        mProducto.add(new Producto("https://pepeganga.vteximg.com.br/arquivos/ids/305721-600-600/790372-1.jpg?v=636553536591730000", "2", null, "apenas para la abuela, que mucho lava", 9000.00, true, true, "LG"));
        mProducto.add(new Producto("https://metrocolombiafood.vteximg.com.br/arquivos/ids/243773-750-750/image-6bf83c9d64054618b0edd5e12888cc5c.jpg?v=637014886620900000", "3", null, "la vendo por necesidad, ayuda plis!", 100000.00, false, true, "Central"));
        mProducto.add(new Producto("https://hosteleria10.com/recursos/fotos/whirlpool-lavadora-awg-812-pro-01.jpg", "4", null, "suena muy rara,pero lava claro ", 16000.00, false, true, "Home"));
        mProducto.add(new Producto("https://mundoinnovos.com/wp-content/uploads/2018/10/LavSecHaceb-15kg-2-1.jpg", "5", null, "de las mejores del mercado", 1000.00, true, true, "Wirlpool"));
    }
}