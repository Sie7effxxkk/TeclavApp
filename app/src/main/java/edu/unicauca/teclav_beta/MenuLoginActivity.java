package edu.unicauca.teclav_beta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.manager.Lifecycle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;

import edu.unicauca.teclav_beta.databinding.NavMainLoginBinding;

public class MenuLoginActivity extends AppCompatActivity implements Serializable , LifecycleObserver {
    private static final String NOMBRE_LO = "NOMBRE_LO";
    private static final String CORREO_LO = "CORREO_LO";
    private static final String FOTO_LO = "FOTO_LO";
    private static final String MENU_LOG_KEY = "MENU_LOG_KEY";
    private AppBarConfiguration mAppBarConfiguration;
    String nombre_Navh;
    String correo_Navh;
    int foto_Navh;
    TextView nombre;
    TextView correo;
    ImageView foto;
    String estadoLogin;
    Usuario mUsuario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Usuario usuario = new Usuario();
        // recovering the instance state
        if (savedInstanceState != null) {
            estadoLogin = savedInstanceState.getString(MENU_LOG_KEY);
        }

        setContentView(R.layout.activity_login_main);
        NavigationView navigationView =(NavigationView) findViewById(R.id.nav_view_login);
      // NavMainLoginBinding binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.nav_header_main, navigationView, false);
        View view = navigationView.getHeaderView(0);
        nombre = (TextView) view.findViewById(R.id.text_nombre_login);
        correo = view.findViewById(R.id.text_correo_login);
        foto = view.findViewById(R.id.imageView_login);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        correo_Navh = b.getString("CORREO");
        nombre_Navh = b.getString("NOMBRE");
        foto_Navh =b.getInt("FOTO");
        nombre.setText(nombre_Navh);
        correo.setText(correo_Navh);
     //
        //   foto.setImageResource(foto_Navh);



/************************************ Add this code ****************************************/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout_login);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_tienda, R.id.nav_login, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
       NavigationUI.setupWithNavController(navigationView, navController);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        nombre.setText(savedInstanceState.getString(NOMBRE_LO));
        correo.setText(savedInstanceState.getString(CORREO_LO));
       foto.setImageResource(Integer.parseInt(savedInstanceState.getString(FOTO_LO)));
    }
    // invoked when the activity may be temporarily destroyed, save the instance state here
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(MENU_LOG_KEY, estadoLogin);
        outState.putString(NOMBRE_LO, nombre.getText().toString());
        outState.putString(NOMBRE_LO, correo.getText().toString());
       outState.putSerializable(NOMBRE_LO, foto.getImageAlpha());

        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first


    }

    @Override
    public void onBackPressed() {
        //Si llamas super.onBackPressed(), esto internamente ejecuta finish().
        super.onBackPressed();
    }


}