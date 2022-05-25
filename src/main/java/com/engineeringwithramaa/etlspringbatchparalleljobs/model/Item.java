package com.engineeringwithramaa.etlspringbatchparalleljobs.model;

import java.time.LocalDate;

public class Item {
    private String id;
    private LocalDate date;

    public Item() {
    }

    public Item(String id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", date=" + date +
                '}';
    }
}
