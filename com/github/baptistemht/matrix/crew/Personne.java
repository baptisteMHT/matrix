package com.github.baptistemht.matrix.crew;

public class Personne {
    //atributs
    private final String nom;
    private final boolean estHomme;
    private int age;
    private Grade grade; // on utilise une énumération pour le grade plutot qu'un string car il y a des rôles bien précis
    
    //methods


    public Personne(String nom, boolean estHomme, int age, Grade grade){
        this.nom = nom;
        this.estHomme = estHomme;
        this.age = age;
        this.grade = grade;
    }

    public String getnom() {
        return nom;
    }

    public int getage() {
        return age;
    }
    public Grade getgrade() {
        return grade;
    }

    public boolean isestHomme() {
        return estHomme;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }


    
}
