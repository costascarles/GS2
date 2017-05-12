package com.example.gs.Controller;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;

import com.example.gs.R;
import com.example.gs.Controller.Requests.DetailsNotasGet;

public class NotasDetails extends AppCompatActivity {
    TextView curso,profesor,actividad,nota,comentario;
    String Userid,asign;
    ActionBar actionBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_details);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
      //  getSupportActionBar().setHomeButtonEnabled(true);

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
            case android.R.id.home:
                finish();
                //NavUtils.navigateUpFromSameTask(this);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}
