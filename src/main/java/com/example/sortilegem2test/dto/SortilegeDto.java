package com.example.sortilegem2test.dto;

import java.time.LocalDate;

public class SortilegeDto {

    private String nom;

    private String type_sort;

    private LocalDate date_sort;

    private Integer id_sorcier;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType_sort() {
        return type_sort;
    }

    public void setType_sort(String type_sort) {
        this.type_sort = type_sort;
    }

    public LocalDate getDate_sort() {
        return date_sort;
    }

    public void setDate_sort(LocalDate date_sort) {
        this.date_sort = date_sort;
    }

    public Integer getId_sorcier() {
        return id_sorcier;
    }

    public void setId_sorcier(Integer id_sorcier) {
        this.id_sorcier = id_sorcier;
    }
}
