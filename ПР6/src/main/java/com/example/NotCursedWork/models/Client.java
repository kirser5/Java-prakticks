package com.example.NotCursedWork.models;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String CName, CSurname, CTelephone, Alpha, Beta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCSurname() {
        return CSurname;
    }

    public void setCSurname(String CSurname) {
        this.CSurname = CSurname;
    }

    public String getCTelephone() {
        return CTelephone;
    }

    public void setCTelephone(String CTelephone) {
        this.CTelephone = CTelephone;
    }

    public Client() {
    }

    public Client(String CName, String CSurname, String CTelephone, String alpha, String beta) {
        this.CName = CName;
        this.CSurname = CSurname;
        this.CTelephone = CTelephone;
        Alpha = alpha;
        Beta = beta;
    }

    public String getAlpha() {
        return Alpha;
    }

    public void setAlpha(String alpha) {
        Alpha = alpha;
    }

    public String getBeta() {
        return Beta;
    }

    public void setBeta(String beta) {
        Beta = beta;
    }
}
