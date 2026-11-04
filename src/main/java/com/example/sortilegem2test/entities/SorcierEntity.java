package com.example.sortilegem2test.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Sorciers")
public class SorcierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer ID;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "date_naissance", nullable = false)
    private LocalDate date_naissance;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "sorcier_id")
    private List<SortilegeEntity> list_sortilege;

    public List<SortilegeEntity> getList_sortilege() {
        return list_sortilege;
    }

    public void setList_sortilege(List<SortilegeEntity> list_sortilege) {
        this.list_sortilege = list_sortilege;
    }

    public MaisonEntity getMaison() {
        return maison;
    }

    public void setMaison(MaisonEntity maison) {
        this.maison = maison;
    }

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_maison")
    private MaisonEntity maison;

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }
}
