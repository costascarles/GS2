package com.example.gs;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Register extends AppCompatActivity {
    EditText Userid,name,password,surname,nameSudent;
    String passHashed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Userid=(EditText) findViewById(R.id.Userid);
        name=(EditText) findViewById(R.id.name);
        password=(EditText) findViewById(R.id.pass);
        surname=(EditText) findViewById(R.id.surname);
        nameSudent=(EditText) findViewById(R.id.nameStudent);


    }
    public void regist(View view){
        if(password.length()<8 ){
            Context context = getApplicationContext();
            CharSequence text = "Contraseña muy corta";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


        }else {
            passHashed = md5(password.getText().toString());
            new RegisterPost(this).execute(Userid.getText().toString(), passHashed, name.getText().toString(), surname.getText().toString(), nameSudent.getText().toString());
        }
    }
    public static String md5(String encTarget){
        MessageDigest mdEnc = null;
        try {
            mdEnc = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception while encrypting to md5");
            e.printStackTrace();
        } // Encryption algorithm
        mdEnc.update(encTarget.getBytes(), 0, encTarget.length());
        String md5 = new BigInteger(1, mdEnc.digest()).toString(16);
        while ( md5.length() < 32 ) {
            md5 = "0"+md5;
        }
        return md5;
    }
}
