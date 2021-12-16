package com.github.baptistemht.matrix.ships;

import java.util.ArrayList;

import com.github.baptistemht.matrix.crew.Personne;

public class Equipage {
    //attributs
    private final int limit;
    private ArrayList<Personne> personnel; 
    //methods

    public Equipage(int limit){
        this.limit = limit;
        this.personnel = new ArrayList<Personne>();
    }

    public void addPersonne(Personne p){
        if(personnel.size() >= limit) return; 
        personnel.add(p);
    }
    public ArrayList<Personne> getPersonnel() {
        return personnel;
    }


    public void removePersonne(String n){
        for (int i = 0; i < personnel.size();i++) {
            if (personnel.get(i).getNom().equalsIgnoreCase(n)){
                personnel.remove(i);
                return;
            } 
        }
    }


    public Personne getPersonne(String n){
        if(personnel.size() == 0) return null;

        for(int i = 0; i<personnel.size(); i++){
            if(personnel.get(i).getNom().equalsIgnoreCase(n)) return personnel.get(i);
        }
        return null;
    }

    @Override
    public String toString() {
        if(personnel.size() == 0) return "Aucun membre d'équipage à bord.";
        
        String s = "";

        for(int i = 0; i<personnel.size(); i++){
            s=s+(i+". "+personnel.get(i) + "\n");
        }
        return s;
    }

}



