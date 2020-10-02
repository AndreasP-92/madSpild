package com.example.demo.Models;

public class PersonFact {
    private String name;
    private String text;
    private String img;

    public PersonFact(String name, String text, String img){
        this.name   = name;
        this.text   = text;
        this.img    = img;
    }
    public String getName(){
        return name;
    }

    public String getText() {
        return text;
    }

    public String getImg() {
        return img;
    }
}
