package com.example.sortilegem2test.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Sortileges")
public class SortilegeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer ID;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "type_sors", nullable = false)
    private String type_sors;

    @Column(name = "date_sors", nullable = false)
    private LocalDate date_sort;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sorcier_id")
    private SorcierEntity sorcier;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType_sors() {
        return type_sors;
    }

    public void setType_sors(String type_sors) {
        this.type_sors = type_sors;
    }

    public LocalDate getDate_sort() {
        return date_sort;
    }

    public void setDate_sort(LocalDate date_sort) {
        this.date_sort = date_sort;
    }

    public SorcierEntity getSorcier() {
        return sorcier;
    }

    public void setSorcier(SorcierEntity sorcier) {
        this.sorcier = sorcier;
    }
}
