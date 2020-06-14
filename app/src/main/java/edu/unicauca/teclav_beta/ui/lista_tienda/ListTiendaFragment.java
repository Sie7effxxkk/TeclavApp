package edu.unicauca.teclav_beta.ui.lista_tienda;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import edu.unicauca.teclav_beta.Producto;
import edu.unicauca.teclav_beta.R;
import edu.unicauca.teclav_beta.ui.detalles.DetallesFragment;
import edu.unicauca.teclav_beta.ui.detalles.iDetallesFragment;
import edu.unicauca.teclav_beta.ui.registrar.RegistroFragment;

/**
 * A fragment representing a list of Items.
 */
public class ListTiendaFragment extends Fragment {
    private ArrayList<Producto> mProducto = new ArrayList<>();
    private Button botonComprar;
    private RecyclerView recyclerViewTienda;
    private MyItemRecyclerViewAdapter mProductoAdapter =
            new MyItemRecyclerViewAdapter(mProducto);


    //Referancias para comunicar Fragments
    Activity activity;
    iDetallesFragment  interfaceDetallesFragment;
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
    //*************************** Add this code *************************************
    // set a listener to handle events from RecyclerView

    private final View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Step 4 of 4: Finally call getTag() on the view.
            // This viewHolder will have all required values.
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            // viewHolder.getItemId();
            // viewHolder.getItemViewType();
            // viewHolder.itemView;
            Producto thisItem = mProducto.get(position);
            Toast.makeText(getContext(), "You Clicked: " + thisItem.getmMarca(), Toast.LENGTH_SHORT).show();
          //  interfaceDetallesFragment.enviarProducto(mProducto.get(recyclerViewTienda.getChildAdapterPosition(view)));
            DetallesFragment detallesFragment = new DetallesFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("objeto",thisItem);
            detallesFragment.setArguments(bundle);
            FragmentTransaction fr=getFragmentManager().beginTransaction();
            fr.add(R.id.nav_host_fragment,detallesFragment);
            fr.addToBackStack(null);
            fr.commit();
        }
    };



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
        return view;
    }

  @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
// Set the Recycler View adapter
        Context context=view.getContext();
        recyclerViewTienda.setLayoutManager(new LinearLayoutManager(context));
      recyclerViewTienda.setAdapter(mProductoAdapter);
        //Step 1 of 4: Create and set OnItemClickListener to the adapter.
      //crear boton comprar
        mProductoAdapter.setOnItemClickListener(onItemClickListener);
       // botonComprar.setOnClickListener(corkyListener);
    }



    private void llenarLista() {
        mProducto.add(new Producto("https://media.aws.alkosto.com/media/catalog/product/cache/6/image/69ace863370f34bdf190e4e164b6e123/8/8/8806088921914_003.jpg" , "1", null, "Lava muy bien,pero es mas vieja que decir viejo cacorro", 800.000, true, 5, "Samsung"));
        mProducto.add(new Producto("https://pepeganga.vteximg.com.br/arquivos/ids/305721-600-600/790372-1.jpg?v=636553536591730000", "2", null, "apenas para la abuela, que mucho lava", 9000.00, true, 1, "LG"));
        mProducto.add(new Producto("https://metrocolombiafood.vteximg.com.br/arquivos/ids/243773-750-750/image-6bf83c9d64054618b0edd5e12888cc5c.jpg?v=637014886620900000", "3", null, "la vendo por necesidad, ayuda plis!", 100000.00, false, 2, "Central"));
        mProducto.add(new Producto("https://hosteleria10.com/recursos/fotos/whirlpool-lavadora-awg-812-pro-01.jpg", "4", null, "suena muy rara,pero lava claro ", 16000.00, false, 0, "Home"));
        mProducto.add(new Producto("https://mundoinnovos.com/wp-content/uploads/2018/10/LavSecHaceb-15kg-2-1.jpg", "5", null, "de las mejores del mercado", 1000.00, true, 1, "Wirlpool"));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        if(context instanceof Activity){
            interfaceDetallesFragment= (iDetallesFragment) this.activity;
        }
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}