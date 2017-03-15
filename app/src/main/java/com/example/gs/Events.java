package com.example.gs;

/**
 * Created by carles on 13/02/2017.
 */

public class Events {
    private String Curso;
    private String name;
    private String timeStart;
    private String timeEnd;

    public Events(String timeEnd, String timeStart, String name, String curso) {
        this.timeEnd = timeEnd;
        this.timeStart = timeStart;
        this.name = name;
        Curso = curso;
    }

    public String getName() {
        return name;
    }

    public String getCurso() {
        return Curso;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }
}
