package com.example.fetchandroidinterntestapp.models;

import java.util.List;

public class Group {
    private int listId;
    private List<Item> items;
    private boolean isExpanded = false;

    public Group(int listId, List<Item> items) {
        this.listId = listId;
        this.items = items;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
