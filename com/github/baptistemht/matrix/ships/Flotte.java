package com.github.baptistemht.matrix.ships;

import java.util.ArrayList;

public class Flotte {

    private final String nom;
    private final ArrayList<Vaisseau> vaisseaux;

    public Flotte(String nom) {
        this.nom        = nom;
        this.vaisseaux  = new ArrayList<Vaisseau>();
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Vaisseau> getVaisseaux() {
        return vaisseaux;
    }

    public void addVaisseau(Vaisseau v) {
        vaisseaux.add(v);
    }

    public void removeVaisseau(String n) {
        int i = 0;
        while (i < vaisseaux.size() && vaisseaux.get(i).getNom() != n) {
            i++;
        }
        vaisseaux.remove(i);
    }

    public Vaisseau getVaisseau(String n){
        if(vaisseaux.size() == 0) return null;

        for(int i = 0; i<vaisseaux.size(); i++){
            if(vaisseaux.get(i).getNom().equalsIgnoreCase(n)) return vaisseaux.get(i);
        }

        return null;
    }

}
