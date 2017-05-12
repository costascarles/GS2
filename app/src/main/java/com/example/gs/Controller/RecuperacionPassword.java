package com.example.gs.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gs.R;
import com.example.gs.Controller.Requests.NewPasswordGet;

public class RecuperacionPassword extends AppCompatActivity {
 TextView status;
    EditText correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperacion_password);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        status = (TextView) findViewById(R.id.recuText);
        correo=(EditText) findViewById(R.id.recuCorreo);
    }
    public void enviar(View view){
    new NewPasswordGet(this,status).execute(correo.getText().toString());
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
