package com.example.gs;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Contacta extends AppCompatActivity {
    Spinner etEmail;EditText etSubject;EditText etBody;CheckBox chkAttachment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacta);
         etEmail = (Spinner) findViewById(R.id.email);
         etSubject = (EditText) findViewById(R.id.etSubject);
         etBody = (EditText) findViewById(R.id.etBody);

        new CorreosGet(this,etEmail).execute();
    }
    public void envia(View view){
        Spinner etEmail = (Spinner) findViewById(R.id.email);
        EditText etSubject = (EditText) findViewById(R.id.etSubject);
        EditText etBody = (EditText) findViewById(R.id.etBody);
        

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
// vamos a enviar texto plano a menos que el checkbox esté marcado
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
       String[]text= etEmail.getSelectedItem().toString().split(" ");
        emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{ text[1]});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,  etSubject.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT   , etBody.getText());





        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Contacta.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
