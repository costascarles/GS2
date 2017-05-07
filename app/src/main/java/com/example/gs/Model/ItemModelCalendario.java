package com.example.gs.Model;

/**
 * Created by Carles on 07/05/2017.
 */

public class ItemModelCalendario {
    private String curs,activity,date;


    public ItemModelCalendario(String curs, String activity,String date)  {
        this.curs=curs;
        this.activity=activity;
        this.date=date;
    }

    public String getCurs() {
        return curs;
    }

    public String getActivity() {
        return activity;
    }

    public String getDate() {
        return date;
    }
}
