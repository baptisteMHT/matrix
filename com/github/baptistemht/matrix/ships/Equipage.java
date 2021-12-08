package com.github.baptistemht.matrix.ships;

import java.util.ArrayList;

import com.github.baptistemht.matrix.crew.Personne;

public class Equipage {
    //attributs
    private final int limit;
    private final ArrayList<Personne> personnel;
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
        int i = 0;
        while (i< personnel.size() && personnel.get(i).getNom() != n){
            i++;
        }
        personnel.remove(i);
        i= 0;
    }

    public Personne getPersonne(String n){
        int i = 0;
        while (i< personnel.size() && personnel.get(i).getNom()!= n){
            i++;

        }
        if(i+1 == personnel.size()){
            return null;
        }

        return personnel.get(i);
    }

    @Override
    public String toString() {
        if(personnel.size() == 0) return "Aucun membre d'équipage à bord.";
        
        String s = "";

        for(int i = 0; i<personnel.size(); i++){
            s=s+("- "+personnel.get(i).getNom() + "\n");
        }
        return s;
    }

}