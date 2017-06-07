package com.example.ramiro.transmision_php;


import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
    private final String SERVER = "http://birdec.com/projects/android/android.php";
    private Button btn;
    private EditText nombres;
    private EditText apellidos;
    private EditText correo;
    private EditText twetter;
    private EditText skype;
    private EditText telefono;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Registrando la escucha sobre la actividad Main
        //addListenerOnButton();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);

        btn=(Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nombres=(EditText) findViewById(R.id.nombres);
                apellidos=(EditText) findViewById(R.id.apellidos);
                correo=(EditText) findViewById(R.id.correo);
                twetter=(EditText) findViewById(R.id.twetter);
                skype=(EditText) findViewById(R.id.skype);
                telefono=(EditText) findViewById(R.id.telefono);

                String nom = nombres.getText().toString();
                String ape = apellidos.getText().toString();
                String corr = correo.getText().toString();
                String sk = skype.getText().toString();
                String tw = twetter.getText().toString();
                String tel = telefono.getText().toString();


                httpHandler handler = new httpHandler();
                String txt = handler.post(SERVER, nom, ape, corr, tw, sk, tel);
                TextView t = (TextView) findViewById(R.id.txt1);
                t.setText(txt);

                nombres.setText("");
                apellidos.setText("");
                correo.setText("");
                twetter.setText("");
                skype.setText("");
                telefono.setText("");
            }
        });

        }

    public void addListenerOnButton() {
        //Obteniendo una instancia del boton show_pet_button

       /* btn_regresar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                *//*Intent intent = new Intent
                        (getApplicationContext(), MainActivity.class);
                startActivity(intent);*//*
            }
        });*/
    }
}

