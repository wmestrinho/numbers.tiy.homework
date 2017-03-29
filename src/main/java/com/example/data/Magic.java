package com.example.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by WagnerMestrinho on 3/28/17.
 */
@Entity
public class Magic {

    @Id @GeneratedValue
    private long id;
    private int number;

    public Magic() {
    }

    public Magic(int number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
