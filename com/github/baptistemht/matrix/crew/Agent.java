package com.github.baptistemht.matrix.crew;

import java.util.Random;

public class Agent extends Personne{

    private int efficacite;
    private Position position;

    public Agent(String nom, boolean estHomme, int age, Position position) {
        super(nom, estHomme, age, Grade.AGENT);
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
    
}
