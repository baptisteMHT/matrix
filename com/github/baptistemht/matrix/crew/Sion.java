package com.github.baptistemht.matrix.crew;

public class Sion extends Personne {
    private Poste poste; // de même énumération car les postes sont définis
    

    public Sion(String nom, boolean estHomme, int age, Grade grade, Poste poste){
        super(nom,estHomme,age,grade);
        this.poste = poste;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    
}
