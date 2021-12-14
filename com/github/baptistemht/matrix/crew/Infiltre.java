package com.github.baptistemht.matrix.crew;

import java.util.Random;

public class Infiltre extends Personne{

    private int efficacite;
    private Position position;

    public Infiltre(String nom, boolean estHomme, int age, Grade grade, Position position) {
        super(nom, estHomme, age, grade);
        this.efficacite     = new Random().nextInt(6);
        this.position       = position;
    }

    public int getEfficacite() {
        return efficacite;
    }

    public void setEfficacite(int efficacite) {
        this.efficacite = efficacite;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
}
