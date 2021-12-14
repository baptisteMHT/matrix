package com.github.baptistemht.matrix.crew;

import com.github.baptistemht.matrix.matrix.Position;

public class Libere extends Personne {
    //attributs
    private final String nom;
    private final boolean estHomme;
    private int age;
    private Grade grade;
    private int entreesSorties;
    private Position position;
    //methods

    public Libere(String nom, boolean estHomme, int age, Grade grade){
        this.nom            = nom;
        this.estHomme       = estHomme;
        this.age            = age;
        this.grade          = grade;
        this.entreesSorties = 0;
        this.position       = null;
    }    

    public int getES() {
        return entreesSorties;
    }

    public void incrementES(){
        this.entreesSorties +=1;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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

}
