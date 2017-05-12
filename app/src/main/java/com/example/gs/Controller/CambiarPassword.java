package com.example.gs.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.gs.R;
import com.example.gs.Controller.Requests.CambiaPasswordGet;

public class CambiarPassword extends AppCompatActivity {
    EditText edit1,edit2;
String Userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_password);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Userid= getIntent().getStringExtra("UserId");
        edit1=(EditText) findViewById(R.id.editText);
        edit2=(EditText) findViewById(R.id.editTextnew);

    }

    public void cambia(View view){
        String passantic=edit1.getText().toString();
        String passnew =edit2.getText().toString();
    new CambiaPasswordGet(this).execute(passantic,passnew,Userid);
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
