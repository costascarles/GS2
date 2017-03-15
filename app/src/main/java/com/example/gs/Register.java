package com.example.gs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class Register extends AppCompatActivity {
    EditText Userid,name,password,surname,nameSudent;
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
        new RegisterPost(this).execute(Userid.getText().toString(),password.getText().toString(),name.getText().toString(),surname.getText().toString(),nameSudent.getText().toString());
    }
}
