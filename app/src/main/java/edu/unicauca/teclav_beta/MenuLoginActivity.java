package edu.unicauca.teclav_beta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.LifecycleObserver;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;

import edu.unicauca.teclav_beta.ui.detalles.DetallesFragment;
import edu.unicauca.teclav_beta.ui.lista_tienda.ListTiendaFragment;

public class MenuLoginActivity extends AppCompatActivity implements Serializable , LifecycleObserver {
    private static final String NOMBRE_LO = "NOMBRE_LO";
    private static final String CORREO_LO = "CORREO_LO";
    private static final String FOTO_LO = "FOTO_LO";
    private AppBarConfiguration mAppBarConfiguration;
    String nombre_Navh;
    String correo_Navh;
    int foto_Navh;
    TextView nombre;
    TextView correo;
    ImageView foto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Usuario usuario = new Usuario();
//CARGAMOS VISTAS
        setContentView(R.layout.activity_login_main);
        NavigationView navigationView =(NavigationView) findViewById(R.id.nav_view_login);
        View view = navigationView.getHeaderView(0);
        nombre = (TextView) view.findViewById(R.id.text_nombre_login);
        correo = view.findViewById(R.id.text_correo_login);
        foto = view.findViewById(R.id.imageView_login);
        //RESIVIMOS INTENT DESDE LA CLASE EnHoraBuena
        Intent i = getIntent();
        Bundle b = i.getExtras();
        correo_Navh = b.getString("CORREO");
        nombre_Navh = b.getString("NOMBRE");
        foto_Navh =b.getInt("FOTO");
        //Mostramos los datos atrapados
        nombre.setText(nombre_Navh);
        correo.setText(correo_Navh);
        foto.setImageResource(foto_Navh);

        //mostramos barra
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //mostramos boton flotante
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
//CONTROLADOR DEL MENU
        DrawerLayout drawer = findViewById(R.id.drawer_layout_login);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_tienda)
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

        outState.putString(NOMBRE_LO, nombre_Navh);
        outState.putString(CORREO_LO, correo_Navh);
        outState.putSerializable(FOTO_LO, foto.getImageAlpha());
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }

    @Override protected void onPause() {
        super.onPause();
// Store values between instances here
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit(); // Put the values from the UI EditText txtName = (EditText)findViewById(R.id.txtName);
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
        editor.putString(CORREO_LO,correo_Navh );
        // value to store
        editor.putString(NOMBRE_LO, nombre_Navh);
        // value to store
        editor.putInt(FOTO_LO, foto_Navh);
// value to store
        // Commit to storage
        editor.commit(); }


    @Override
    public void onBackPressed() {
        //Si llamas super.onBackPressed(), esto internamente ejecuta finish().
        super.onBackPressed();
    }


}