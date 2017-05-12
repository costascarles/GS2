package com.example.gs.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.gs.R;
import com.example.gs.Controller.Requests.Notasget;

public class Notas extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String Userid;
    ListView listanotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Userid= getIntent().getStringExtra("UserId");
        listanotas=(ListView)findViewById(R.id.listNotas);
        listanotas.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        new Notasget(this,listanotas).execute(Userid);

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
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    Intent intent=new Intent(this,NotasDetails.class);
        intent.putExtra("UserId",Userid);
        intent.putExtra("asignatura", Notasget.data.get(position).getId() );
        startActivity(intent);


    }


}
