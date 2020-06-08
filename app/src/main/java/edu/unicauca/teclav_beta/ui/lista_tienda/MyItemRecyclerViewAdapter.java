package edu.unicauca.teclav_beta.ui.lista_tienda;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.unicauca.teclav_beta.Producto;
import edu.unicauca.teclav_beta.databinding.ItemListTiendaBinding;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {



    private final ArrayList<Producto> mProductos;
    //listener
    private  View.OnClickListener listener;

    public MyItemRecyclerViewAdapter(ArrayList<Producto> productos) {
        this.mProductos = productos;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        ItemListTiendaBinding binding = ItemListTiendaBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
        /*View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,
                parent, false);
        setOnClickListener(listener);
        return new ViewHolder(view);

         */
    }
    @Override
    public void onBindViewHolder( ViewHolder holder, int i) {
        Producto producto = mProductos.get(i);
        holder.binding.setProducto(producto);
        holder.binding.executePendingBindings();
     /*  holder.producto=mProductos.get(i);
       holder.precio.setText(mProductos.get(i).DubleaTexto());
       holder.descripcion.setText(mProductos.get(i).getDescripcion());
       holder.estado.setText(mProductos.get(i).esEstado());
       holder.imageView.setImageResource(mProductos.get(i).getmImagenId());

      */
    }

    @Override
    public int getItemCount() {
        return mProductos.size();
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }

    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final ItemListTiendaBinding binding;
/*public final TextView precio,estado,descripcion;
public final ImageView imageView;
public  Producto producto;
public final View parentView;

 */

        public ViewHolder(ItemListTiendaBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            /*parentView = itemView;
            descripcion = itemView.findViewById(R.id.textView);
            estado = itemView.findViewById(R.id.textView2);
            precio = itemView.findViewById(R.id.text_precio);
            imageView =itemView.findViewById(R.id.imageView);

             */
        }
    }


}
