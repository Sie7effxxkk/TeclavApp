package edu.unicauca.teclav_beta.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import edu.unicauca.teclav_beta.MenuLoginActivity;
import edu.unicauca.teclav_beta.R;
import edu.unicauca.teclav_beta.Usuario;

public class EnHoraBuena extends AppCompatActivity {
   TextView titulo,precio,envio,giro;
   ImageView imagen_pago,imagen_giro;
   String titulo_co,precio_co,envio_co,giro_co;
   int imagen_pago_o,imagen_giro_o;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //CARGAMOS LA VISTA
        setContentView(R.layout.activity_en_hora_buena);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        titulo =  findViewById(R.id.text_titulo_fin);
        precio = findViewById(R.id.text_precio_fin);
        envio = findViewById(R.id.textView_se_envia_gratis);
        giro= findViewById(R.id.textView_domicilio);
        imagen_pago =findViewById(R.id.imageView_pago_fin);
        imagen_giro=findViewById(R.id.imageView_encomienda_fin);
        //Recibe el intent enviado desde el fragmento
        Intent i = getIntent();
        Bundle b = i.getExtras();
        titulo_co = b.getString("TITULO");
        precio_co = b.getString("PRECIO");
        envio_co = b.getString("ENVIO");
        giro_co=b.getString("DOMICILIO");
        imagen_pago_o=b.getInt("IMAGEN_PAGO");
        imagen_giro_o=b.getInt("IMAGEN_GIRO");
        //Mostramos en pantalla los datos
        titulo.setText(titulo_co);
        precio.setText(precio_co);
        envio.setText(envio_co);
        imagen_pago.setImageResource(imagen_pago_o);
        imagen_giro.setImageResource(imagen_giro_o);
        giro.setText(giro_co);
        
    }
 //Bton Fin Compra
    public void fin_compra_button(View view) {
        //Atrapamos Los datos necesario para enviarlos a menu logi
        Usuario mUsuario = new Usuario();
        Intent intent = new Intent(this, MenuLoginActivity.class);
        intent.putExtra("NOMBRE",mUsuario.getmNombre());
        intent.putExtra("CORREO",mUsuario.getmCorreo());
        intent.putExtra("FOTO",mUsuario.getmFoto());
        startActivity(intent);
    }
}