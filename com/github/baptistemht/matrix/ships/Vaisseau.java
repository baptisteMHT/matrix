package com.github.baptistemht.matrix.ships;

import com.github.baptistemht.matrix.crew.Personnel;

public class Vaisseau {

    private final String nom;
    private final Personnel equipage;

    public Vaisseau(String nom, int limit){
        this.nom = nom;
        this.equipage = new Personnel(limit);
    }

    public String getNom() {
        return nom;
    }

    public Personnel getEquipage() {
        return equipage;
    }
    
}
