package com.github.baptistemht.matrix.crew;

import java.util.Random;

import com.github.baptistemht.matrix.matrix.Position;

public class Agent extends Personne{

    private final String nom;
    private final boolean estHomme;
    private Grade grade;
    private int age;
    private int efficacite;
    private Position position;

    public Agent(String nom, boolean estHomme, int age, Position position) {
        this.nom            = nom;
        this.estHomme       = estHomme;
        this.grade          = Grade.AGENT;
        this.age            = age;
        this.efficacite     = new Random().nextInt(6);
        this.position       = position;
    }

    public int getEfficacite() {
        return efficacite;
    }

    public void reduireEfficacite() {
        this.efficacite -= 1;
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
