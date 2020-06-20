package edu.unicauca.teclav_beta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import edu.unicauca.teclav_beta.ui.EnHoraBuena;
import edu.unicauca.teclav_beta.ui.detalles.DetallesFragment;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ConfirmarCompra extends AppCompatActivity {
    private static final String TITULO_CON = "TITULO_CON";
    TextView titulo=null, precio=null;
    int medio_de_pago=R.mipmap.ic_launcher_foreground;
    int medio_de_giro=R.mipmap.ic_launcher_foreground;
    String titulo_co, precio_co,envio,domicilio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_compra);
        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        titulo = findViewById(R.id.text_titulo_con);
        precio = findViewById(R.id.text_precio_con);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        titulo_co = b.getString("TITULO");
        precio_co = b.getString("PRECIO");
        titulo.setText(titulo_co);
        precio.setText(precio_co);


    }
    public void action_button(View view) {
        if(medio_de_pago==R.mipmap.ic_launcher_foreground||medio_de_giro==R.mipmap.ic_launcher_foreground){
            Toast toast = Toast.makeText(getApplicationContext(),"Efecty",Toast.LENGTH_LONG);
            toast.show();

        }else {
            Intent intent = new Intent(this, EnHoraBuena.class);
            intent.putExtra("TITULO", titulo_co);
            intent.putExtra("PRECIO", precio_co);
            intent.putExtra("ENVIO",envio);
            intent.putExtra("DOMICILIO",domicilio);
            intent.putExtra("IMAGEN_PAGO",medio_de_pago);
            intent.putExtra("IMAGEN_GIRO",medio_de_giro);
            startActivity(intent);
        }

    }

    public void action_button_efecty(View view){
        Toast toast = Toast.makeText(getApplicationContext(),"Efecty",Toast.LENGTH_LONG);
        toast.show();
        medio_de_pago=R.mipmap.efecty_foreground;

    }
    public void action_button_bancolombia(View view){
        Toast toast = Toast.makeText(getApplicationContext(),"Bancolombia",Toast.LENGTH_LONG);
        toast.show();
        medio_de_pago=R.mipmap.bancolombia_sisas_foreground;
    }
    public void action_button_fedex(View view){
        Toast toast = Toast.makeText(getApplicationContext(),"Fedex",Toast.LENGTH_LONG);
        toast.show();
        medio_de_giro=R.mipmap.fedex_foreground;
    }
    public void action_button_interrapidisimo(View view){
        Toast toast = Toast.makeText(getApplicationContext(),"InterRapidisimo",Toast.LENGTH_LONG);
        toast.show();
        medio_de_giro=R.mipmap.inter_rapidisimo_foreground;
    }
    public void action_button_daviplata(View view){
        Toast toast = Toast.makeText(getApplicationContext(),"BancaMia",Toast.LENGTH_LONG);
        toast.show();
        medio_de_pago=R.mipmap.bancamia_foreground;
    }
    public void action_button_visa(View view){
        Toast toast = Toast.makeText(getApplicationContext(),"Visa",Toast.LENGTH_LONG);
        toast.show();
        medio_de_pago=R.mipmap.visa_sisas_foreground;
    }
    public void action_button_mastercard(View view){
        Toast toast = Toast.makeText(getApplicationContext(),"Master Card",Toast.LENGTH_LONG);
        toast.show();
        medio_de_pago=R.mipmap.mastercard_sisas_foreground;
    }
    public void action_button_servientraga(View view){
        Toast toast = Toast.makeText(getApplicationContext(),"Servi Entrega",Toast.LENGTH_LONG);
        toast.show();
        medio_de_giro=R.mipmap.servi_entrega_foreground;
    }
    public void action_button_paypal(View view){
        Toast toast = Toast.makeText(getApplicationContext(),"Paypal",Toast.LENGTH_LONG);
        toast.show();
        medio_de_pago=R.mipmap.paypal_foreground;
    }
    public void onCheckboxClicked(View view) {
        boolean checed = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox_envio:
                if (checed) {
                      envio="El envio llegara Gratis";
                } else {
                    envio=null;
                }
            case R.id.checkBox_domicilio:
                if (checed) {
                    domicilio="El envio llegara a Domicilio";
                } else {
                    domicilio=null;
                }

        }

    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
     //   outState.putString("PRECIO_COM",precio.getText().toString());

        titulo = findViewById(R.id.text_titulo_con);
        precio = findViewById(R.id.text_precio_con);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        titulo_co = b.getString("TITULO");
        precio_co = b.getString("PRECIO");

        outState.putString("TITULO_COM",titulo_co);
        super.onSaveInstanceState(outState);

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
       precio.setText(savedInstanceState.getString("PRECIO_COM"));
        titulo.setText((savedInstanceState.getString("TITULO_COM")));
    }
    @Override protected void onPause() {
        super.onPause();
// Store values between instances here
        SharedPreferences preferences = getPreferences(MODE_PRIVATE); SharedPreferences.Editor editor = preferences.edit(); // Put the values from the UI
        TextView txtTitulo = findViewById(R.id.text_titulo_con);
        String strName = txtTitulo.getText().toString();
        editor.putString(TITULO_CON, strName);
        editor.commit(); }

        public void mostrarMensajeDatos(View view){
        Toast toast = Toast.makeText(getApplicationContext(),"ingrese Datos",Toast.LENGTH_LONG);
        toast.show();
    }


}
