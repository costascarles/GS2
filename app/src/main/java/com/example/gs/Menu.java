package com.example.gs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {
String Userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Userid= getIntent().getStringExtra("UserId");
    }

    public void notas(View view){
        Intent intent = new Intent(this,Notas.class);
        intent.putExtra("UserId", Userid);
        startActivity(intent);

    }
    public void contacta(View view){
        Intent intent= new Intent(this,Contacta.class);
        startActivity(intent);
    }
    public void calendario(View view){
        Intent intent= new Intent(this,Calendario.class);
        startActivity(intent);
    }

}
