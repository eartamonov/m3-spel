package com.luxoft.springel.example02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component("languageBean")
public class Language implements Serializable {
    private static final long serialVersionUID = 1234L;
    @Value("1")
    private int id;

    @Value("ru_RU")
    private String code;

    @Value("Russian language")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return id + ". " + name + " (" + code + ")";
    }
}
