package com.example.gs.Controller.Requests;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/**
 * Created by Carles on 12/04/2017.
 */

public class NewPasswordGet extends AsyncTask<String,String,String> {
    private TextView statusField;
    private Context context;

    private String email;

    //flag 0 means get and 1 means post.(By default it is get.)
    public NewPasswordGet(Context context,TextView statusField) {
        this.context = context;
        this.statusField = statusField;


    }



    protected void onPreExecute(){
    }


    public String doInBackground(String... arg0) {


        try{
            String mail = (String)arg0[0];
            email=mail;

            String link = "http://goodstudent.es/goodStudentPHP/mail.php?correo="+email;

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
 String a=result;
if(result.equals("1")){
    statusField.setText("Tu correo ha sido enviado comprueba no deseados si no ha llegado.");
}else {
    statusField.setText("Dirección de correo erronea:"+result);
}



    }
}
