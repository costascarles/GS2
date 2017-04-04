package com.example.gs.Model;

/**
 * Created by Alumne on 06/03/2017.
 */

public class ItemModel {
    private String title,nota,id;
    private int image;

  public ItemModel(String title, String nota,String id)  {
      this.title=title;
      this.nota=nota;
    this.id=id;
  }

    public String getTitle(){return title;}

    public String getNota() {
        return nota;
    }

    public String getId() {
        return id;
    }

    public void setNota(String dificultad) {
        this.nota = dificultad;
    }







}

