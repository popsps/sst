package com.ss.hw.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
    private long id;
    private String fName;
    private String lName;

    public Customer(@JsonProperty("id") long id,
                    @JsonProperty("fname") String fname,
                    @JsonProperty("lname") String lname) {
        this.id = id;
        this.fName = fname;
        this.lName = lname;
    }

    public Customer() {
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    public long getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
