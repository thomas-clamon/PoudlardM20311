package com.example.sortilegem2test.dto;

public class SorcierDto {

    private String display_name; // prenom nom en majuscule.
    private Integer age;

    private String maison;

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMaison() {
        return maison;
    }

    public void setMaison(String maison) {
        this.maison = maison;
    }
}
