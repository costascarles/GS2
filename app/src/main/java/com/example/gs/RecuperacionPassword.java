package com.example.gs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RecuperacionPassword extends AppCompatActivity {
 TextView status;
    EditText correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperacion_password);
        status = (TextView) findViewById(R.id.recuText);
        correo=(EditText) findViewById(R.id.recuCorreo);
    }
    public void enviar(View view){
    new NewPasswordGet(this,status).execute(correo.getText().toString());
    }
}
