package br.com.gabyrel.model;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class Student extends AbstractEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
