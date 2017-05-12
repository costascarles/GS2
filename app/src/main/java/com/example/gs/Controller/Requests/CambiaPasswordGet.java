package com.example.gs.Controller.Requests;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.gs.Controller.Menu;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/**
 * Created by Carles on 15/04/2017.
 */

public class CambiaPasswordGet extends AsyncTask<String,String,String> {

    private Context context;
String User;


    //flag 0 means get and 1 means post.(By default it is get.)
    public CambiaPasswordGet(Context context) {
        this.context = context;



    }



    protected void onPreExecute(){
    }


    public String doInBackground(String... arg0) {


        try{
            String passantic = (String)arg0[0];
            String passnew = (String)arg0[1];
            String user = (String)arg0[2];
            User=user;
            String link = "http://goodstudent.es/goodStudentPHP/cambiaPassword.php?passantic="+passantic+"&&passnew="+passnew+"&&UserId="+user;

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

        Toast.makeText(context,
                "Contraseña modificada", Toast.LENGTH_SHORT)
                .show();
        Intent intent=new Intent(context,Menu.class);
        intent.putExtra("UserId",User);
        context.startActivity(intent);

    }
}
