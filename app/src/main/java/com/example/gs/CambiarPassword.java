package com.example.gs;

import android.opengl.EGLDisplay;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CambiarPassword extends AppCompatActivity {
    EditText edit1,edit2;
String Userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_password);
        Userid= getIntent().getStringExtra("UserId");
        edit1=(EditText) findViewById(R.id.editText);
        edit2=(EditText) findViewById(R.id.editTextnew);

    }

    public void cambia(View view){
        String passantic=edit1.getText().toString();
        String passnew =edit2.getText().toString();
    new CambiaPasswordGet(this).execute(passantic,passnew,Userid);
    }
}
