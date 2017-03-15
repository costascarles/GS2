package com.example.gs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Alumne on 03/02/2017.
 */
public class SigninActivity  extends AsyncTask<String,String,String> {
    private TextView statusField;
    private Context context;

    private String name;

    //flag 0 means get and 1 means post.(By default it is get.)
    public SigninActivity(Context context,TextView statusField) {
        this.context = context;
        this.statusField = statusField;


    }



    protected void onPreExecute(){
    }


    public String doInBackground(String... arg0) {


            try{
                String username = (String)arg0[0];
                name=username;
                String password = (String)arg0[1];
                String link = "http://goodstudent.es/goodStudentPHP/LoginGet.php?username="+username+"&password="+password;

                URL url = new URL(link);
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(link));
                HttpResponse response = client.execute(request);
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(response.getEntity().getContent()));

                StringBuffer sb = new StringBuffer("");
                String line="";

                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }

                in.close();
                return sb.toString();
            } catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }

        }



    public void onPostExecute(String result){


        if(!result.equals(name) || result.equals(null)){
            this.statusField.setText("Error Login");
        }
        if(result.equals(name)&& !name.equals("")) {
            this.statusField.setText("Login Successful");
            Intent intent = new Intent(context, Menu.class);
            intent.putExtra("UserId", result);
            context.startActivity(intent);
            ((Activity) context).finish();
        }


    }
}
