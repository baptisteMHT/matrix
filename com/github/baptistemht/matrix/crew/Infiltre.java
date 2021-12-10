package com.github.baptistemht.matrix.crew;

import java.util.Random;

public class Infiltre extends Personne{

    private final int efficacite;
    private final int x;
    private final int y;

    public Infiltre(String nom, boolean estHomme, int age, Grade grade) {
        super(nom, estHomme, age, grade);
        this.efficacite = new Random().nextInt(6);
        this.x          = new Random().nextInt(10);
        this.y          = new Random().nextInt(10);
    }

    public int getEfficacite() {
        return efficacite;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    
}
