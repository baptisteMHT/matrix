package com.github.baptistemht.matrix.ships;

public class Vaisseau {

    private final String nom;
    private Equipage equipage; //enlever le final pour voir si ca vient de là

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

    @Override
    public String toString() {
        return "Vaisseau " + nom + " est composé de " + equipage.getPersonnel().size() + " membres d'équipage.";
    }
    
}
