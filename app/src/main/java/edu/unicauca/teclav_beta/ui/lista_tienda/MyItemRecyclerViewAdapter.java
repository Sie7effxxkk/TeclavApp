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
    private static View.OnClickListener mOnItemClickListener;
    private static View.OnClickListener mOnButtonClickListener;
   //CONSTRUCTORES
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }
    public void setmOnButtonClickListener(View.OnClickListener buttonClickListener) {
        mOnButtonClickListener = buttonClickListener;
    }
    public MyItemRecyclerViewAdapter(ArrayList<Producto> productos) {
        this.mProductos = productos;
    }

    //LIstamos los items y a su vez le asignamos sus datos corresponedientes
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        ItemListTiendaBinding binding = ItemListTiendaBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }
    //envia el obejto a data binding
    @Override
    public void onBindViewHolder( ViewHolder holder, int i) {
        Producto producto = mProductos.get(i);
        holder.binding.setProducto(producto);
        holder.binding.executePendingBindings();
    }
 //tamaño de la lista
    @Override
    public int getItemCount(){
        return mProductos.size();
    }
    //funcion on click
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener!=null){
            mOnItemClickListener.onClick(v);
        }else{
            if(mOnButtonClickListener!=null){
                mOnButtonClickListener.onClick(v);
            }
        }

    }
    public void setOnClickListener(View.OnClickListener itemClickListener){
        this.mOnItemClickListener = itemClickListener;
    }

    //asigna los binding y a su vez la funcion click

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final ItemListTiendaBinding binding;
        public ViewHolder(ItemListTiendaBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);

        }
    }


}
