package com.example.gs.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.gs.R;
import com.example.gs.Controller.Requests.GetDates;

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
        new GetDates(this).execute(Userid);
        /*
        Intent intent= new Intent(this,Calendario.class);
        startActivity(intent);*/
    }
    public void progres(View view){
        Intent intent= new Intent(this,Progres.class);
        intent.putExtra("UserId", Userid);
        startActivity(intent);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exitLog:
                Intent intent1 =new Intent(this,Login.class);
                startActivity(intent1);
                return true;
            case R.id.CambiarPassword:
                Intent intent = new Intent(this,CambiarPassword.class);
                intent.putExtra("UserId", Userid);
                startActivity(intent);

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
