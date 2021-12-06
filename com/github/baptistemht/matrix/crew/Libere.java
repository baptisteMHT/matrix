package com.github.baptistemht.matrix.crew;

public class Libere extends Personne {
    private int entrees;
    private int sorties;


    public Libere(String nom, boolean estHomme, int age, Grade grade, int entrees, int sorties){
        super(nom,estHomme,age,grade);
        this.entrees = entrees;
        this.sorties = sorties;
    }    
}
