package com.github.baptistemht.matrix.ships;

import com.github.baptistemht.matrix.crew.Sion;

public class Vaisseau {

    private final String nom;
    private Equipage equipage;

    public Vaisseau(String nom, int limit){
        this.nom = nom;
        this.equipage = new Equipage(limit);
    }

    public String getNom() {
        return nom;
    }

    public Equipage getEquipage() {
        return equipage;
    }

    public boolean estSecurise(){
        for(int i=0; i<equipage.getPersonnel().size(); i++){
            if(equipage.getPersonnel().get(i) instanceof Sion) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Vaisseau " + nom + " est composé de " + equipage.getPersonnel().size() + " membres d'équipage.";
    }
    
}
