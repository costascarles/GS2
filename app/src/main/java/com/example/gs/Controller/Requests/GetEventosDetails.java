package com.example.gs.Controller.Requests;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gs.Controller.Adapter.AdapterCalendario;
import com.example.gs.Model.ItemModelCalendario;
import com.example.gs.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carles on 07/05/2017.
 */

public class GetEventosDetails extends AsyncTask<String,String,String> {

    private Context context;
    ListView listaevents;
    static public List<ItemModelCalendario> data;
String userid;
    public GetEventosDetails(Context context, ListView listaevents) {
        this.context = context;

        this.listaevents=listaevents;
    }
    protected void onPreExecute(){
    }
    public String doInBackground(String... arg0) {
        try {
            String Userid = (String)arg0[0];
            userid=Userid;
            String date = (String)arg0[1];
            String link = "http://goodstudent.es/goodStudentPHP/getDatesDetails.php?UserId=" + Userid+"&&date="+date;
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
        data=new ArrayList<ItemModelCalendario>();

        String[] todas= result.split(";");
if(result!="") {
    for (int i = 0; i < todas.length; i++) {
        String[] events = todas[i].split("/");
        ItemModelCalendario model = new ItemModelCalendario(events[2], events[1], events[0]);
        data.add(model);
    }
    AdapterCalendario adapter = new AdapterCalendario((Activity) context, data, R.layout.list_item_calendar);
    listaevents.setAdapter(adapter);
}else{

    CharSequence text = "No hay eventos programados";
    int duration = Toast.LENGTH_SHORT;

    Toast toast = Toast.makeText(context, text, duration);
    toast.show();
    new GetDates(context).execute(userid);

}


    }
}
