package co.edu.uptc.pojo;

import java.util.Date;

public class BillHeader {
    private String id;
    private String date;
    private Person person;

    public BillHeader(String id, Person person) {
        date = String.valueOf(new Date());
        this.id = id;
        this.person = person;
    }

    public String getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "BillHeader{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", person=" + person +
                '}';
    }
}
