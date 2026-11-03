package com.example.sortilegem2test.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Maisons")
public class MaisonEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "nom")
    private String nom;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_maison")
    List<SorcierEntity> list_sorcier;

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

    public List<SorcierEntity> getList_sorcier() {
        return list_sorcier;
    }

    public void setList_sorcier(List<SorcierEntity> list_sorcier) {
        this.list_sorcier = list_sorcier;
    }
}
