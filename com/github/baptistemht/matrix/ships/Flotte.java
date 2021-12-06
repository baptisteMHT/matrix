package com.github.baptistemht.matrix.ships;

import java.util.ArrayList;

public class Flotte {

    private final ArrayList<Vaisseau> vaisseaux;

    public Flotte() {
        this.vaisseaux = new ArrayList<Vaisseau>();
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
        int i = 0;
        while (i< vaisseaux.size() && vaisseaux.get(i).getNom()!= n){
            i++;

        }
        if(i+1 == vaisseaux.size()) return null;

        return vaisseaux.get(i);
    }

}
