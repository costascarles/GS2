package com.example.gs.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gs.R;
import com.example.gs.Controller.Requests.SigninGet;


public class Login extends AppCompatActivity {
    private EditText usernameField,passwordField;
    private TextView status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameField = (EditText)findViewById(R.id.editText1);
        passwordField = (EditText)findViewById(R.id.editText2);

        status = (TextView)findViewById(R.id.textView4);

    }
    //Login
    public void login(View view){
        String username = usernameField.getText().toString();
        String password = Register.md5(passwordField.getText().toString());

        new SigninGet(this,status).execute(username,password);

    }
//Registro
    public void loginPost(View view){
        Intent intent =new Intent(this,Register.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_login, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.recupass:
                Intent intent = new Intent(this,RecuperacionPassword.class);
                startActivity(intent);
                return true;



            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}
