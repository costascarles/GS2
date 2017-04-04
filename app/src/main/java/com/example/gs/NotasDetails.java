package com.example.gs;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import android.widget.Toast;

public class NotasDetails extends AppCompatActivity {
    TextView curso,profesor,actividad,nota,comentario;
    String Userid,asign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_details);
        Userid= getIntent().getStringExtra("UserId");
        asign= getIntent().getStringExtra("asignatura");

        curso=(TextView) findViewById(R.id.curso_details);
        profesor=(TextView) findViewById(R.id.professor_details);
        actividad=(TextView) findViewById(R.id.activity_details);
        nota=(TextView) findViewById(R.id.nota_details);
        comentario=(TextView) findViewById(R.id.comentario_details);
        new DetailsNotasGet(this,curso,profesor,actividad,nota,comentario).execute(Userid,asign);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exitLog:
                Intent intent1 =new Intent(this,Menu.class);
                startActivity(intent1);
                return true;
            case R.id.ayuda:

                return true;
            case R.id.Ajustes:

                return true;



            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_details, menu);
        return true;
    }
}
