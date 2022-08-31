package ru.haulmont.demo.Dto;

import javax.persistence.Column;
import java.util.UUID;

public class BookDto {
    private UUID id;

    private String name;

    private int year;

    private String man;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }
}
