package com.example.gs.Controller.Requests;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.gs.Controller.Login;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/**
 * Created by carles on 12/02/2017.
 */

public class RegisterPost extends AsyncTask<String,String,String> {
    private Context context;



    public RegisterPost(Context context) {
        this.context = context;


    }
    protected void onPreExecute(){
    }
    public String doInBackground(String... arg0) {
        try {
            String Userid = (String)arg0[0];
            String Password = (String)arg0[1];
            String name = (String)arg0[2];
            String correo = (String)arg0[3];
            String usernameStudnet = (String)arg0[4];
            String link = "http://goodstudent.es/goodStudentPHP/RegisterUserPost.php?UserID="+Userid+"&&email="+correo+"&&name="+name+"&&password="+Password+"&&nombreStudnet="+usernameStudnet;
            URL url = new URL(link);
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(link));
            HttpResponse response = client.execute(request);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(response.getEntity().getContent()));

            StringBuffer sb = new StringBuffer("");
            String line = "";

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
if(result.equals("1")){
    System.out.println("Register");
    Intent intent = new Intent(context, Login.class);

    context.startActivity(intent);
    ((Activity) context).finish();
}else{
    System.out.println("error");
}


    }
}
