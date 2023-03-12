package co.edu.uptc.pojo;

import java.util.Date;

public class BillHeader {
    private int id;
    private String date;
    private Person person;

    public BillHeader(int id, Person person) {
        date = String.valueOf(new Date());
        this.id = id;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public String getDate() {
        return date;
    }
}
