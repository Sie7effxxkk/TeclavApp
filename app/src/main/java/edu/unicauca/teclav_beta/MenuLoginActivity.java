package edu.unicauca.teclav_beta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;

import edu.unicauca.teclav_beta.databinding.FragmentDatallesBinding;
import edu.unicauca.teclav_beta.databinding.NavMainLoginBinding;
import edu.unicauca.teclav_beta.ui.login.LoginFragment;

public class MenuLoginActivity extends AppCompatActivity implements Serializable {
    private AppBarConfiguration mAppBarConfiguration;
    String nombre_Navh;
    String correo_Navh;
    int foto_Navh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Usuario usuario = new Usuario();
        setContentView(R.layout.activity_confirma_compra);
        NavigationView navigationView =(NavigationView) findViewById(R.id.nav_view_login);
      // NavMainLoginBinding binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.nav_header_main, navigationView, false);
        View view = navigationView.getHeaderView(0);
        TextView nombre = (TextView) view.findViewById(R.id.text_nombre_login);
        TextView correo = view.findViewById(R.id.text_correo_login);
        ImageView foto = view.findViewById(R.id.imageView_login);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        correo_Navh = b.getString("CORREO");
        nombre_Navh = b.getString("NOMBRE");
        foto_Navh =b.getInt("FOTO");
        nombre.setText(nombre_Navh);
        correo.setText(correo_Navh);
        foto.setImageResource(foto_Navh);

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



}