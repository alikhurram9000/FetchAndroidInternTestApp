package com.example.fetchandroidinterntestapp.models;

public class Item {
    private int id;
    private String name;

    private int listId;


    public Item(int id, String name, int listId) {
        this.id = id;
        this.name = name;
        this.listId = listId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }
}
