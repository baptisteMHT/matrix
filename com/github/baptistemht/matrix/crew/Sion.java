package com.github.baptistemht.matrix.crew;

public class Sion extends Personne {
    //attributs
    private final String nom;
    private final boolean estHomme;
    private int age;
    private Grade grade;
    private Poste poste; // de même énumération car les postes sont définis
    //methods

    public Sion(String nom, boolean estHomme, int age, Grade grade, Poste poste){
        this.nom        = nom;
        this.estHomme   = estHomme;
        this.age        = age;
        this.grade      = grade;
        this.poste      = poste;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public Grade getGrade() {
        return this.grade;
    }

    @Override
    public boolean isEstHomme() {
        return this.estHomme;
    }

    @Override
    public void setAge(int age) {
        this.age = age;        
    }

    @Override
    public void setGrade(Grade grade) {
        this.grade = grade;        
    }

    @Override
    public String toString() {
        return "Opérateur Sion " + this.nom + " (Homme: " + this.estHomme + ", Age: " + this.age + ", Grade: " + this.grade + ") occupe le poste " + this.poste + ".";
    }

    
}
