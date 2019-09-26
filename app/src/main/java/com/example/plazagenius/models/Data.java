package com.example.plazagenius.models;

public class Data {

    private int id;
    private String first_name;
    private String last_name;
    private String avatar;

    public Data(int id, String first_name, String last_name, String avatar) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String combineName(){

        return first_name + " " + last_name;
    }
}
