package com.example.gs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.example.gs.Register.md5;


public class MainActivity extends AppCompatActivity {
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
    public void login(View view){
        String username = usernameField.getText().toString();
        String password = md5(passwordField.getText().toString());

        new SigninActivity(this,status).execute(username,password);

    }

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
