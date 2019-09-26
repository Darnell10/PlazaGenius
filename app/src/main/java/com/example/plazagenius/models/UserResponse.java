package com.example.plazagenius.models;

import java.util.List;

public class UserResponse {

    private int page;
    private int per_page;
    private int total;

    private List<Data> data;

    public List<Data> getData() {
        return data;
    }
}
