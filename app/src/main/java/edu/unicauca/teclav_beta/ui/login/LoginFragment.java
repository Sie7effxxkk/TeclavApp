package edu.unicauca.teclav_beta.ui.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;
import java.util.Objects;

import edu.unicauca.teclav_beta.R;
import edu.unicauca.teclav_beta.Usuario;
import edu.unicauca.teclav_beta.MenuLoginActivity;
import edu.unicauca.teclav_beta.ui.registrar.RegistroFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment implements Serializable {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistroFragment.
     */
    // Funcion que no uso , solo era para guardar el estado
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    //Funcion para llamar la vista , pero no la uso
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
//llama la vista sonbre el container
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//cargamos vista y vista de los botones
        final View root = inflater.inflate(R.layout.fragment_login, container, false);
        Button bRegistrar = root.findViewById(R.id.button_registrarse);

        Button bEntrar = root.findViewById(R.id.buttonEntrar_login);
//creamos atrivutos
        @SuppressLint("CutPasteId") final EditText editText = root.findViewById(R.id.editTextTextPersonName);
        @SuppressLint("CutPasteId") final EditText editTextc = root.findViewById(R.id.editTextTextPersonName2);
 //BOTON que lo lleva al fragment registro
        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment, new RegistroFragment());
                fr.commit();
            }
        });
//BOTON para inicar Sesion
        bEntrar.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                //Atributos que se usan para comprobar si el usuario existe
                Usuario mUsuario = new Usuario();
                String nombreNav;
                String ContraseñaNav;
                String contraseña=mUsuario.getmContraseña();
                String comparar = mUsuario.getmNombre();
                nombreNav = editText.getText().toString();
                ContraseñaNav = editTextc.getText().toString();
                //excepcion de ingreso
                if (Objects.equals(nombreNav, comparar)&&Objects.equals(contraseña,ContraseñaNav)) {
                    //cargamos el intento que nos llevara al menu de login
                    Intent i = new Intent(getActivity(), MenuLoginActivity.class);
                    //eviamos los datos del objeto  persona, necesarios para cargarse en el menu
                    i.putExtra("NOMBRE",mUsuario.getmNombre());
                    i.putExtra("CORREO",mUsuario.getmCorreo());
                    i.putExtra("FOTO",mUsuario.getmFoto());
                    i.putExtra("LOGEADO",true);
                    startActivityForResult(i,0);
                } else
                    Snackbar.make(v, "INGRESE DATOS CORRECTOS", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }



}