package edu.unicauca.teclav_beta.ui.tienda;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.unicauca.teclav_beta.R;
import edu.unicauca.teclav_beta.ui.slideshow.SlideshowViewModel;


public class TiendaFragment extends Fragment {
    private SlideshowViewModel slideshowViewModel;


    public TiendaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tienda, container, false);
        return root;
    }
}