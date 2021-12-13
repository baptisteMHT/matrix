package com.github.baptistemht.matrix.ships;

import java.util.ArrayList;

import com.github.baptistemht.matrix.crew.Personne;

public class Equipage {
    //attributs
    private final int limit;
    private ArrayList<Personne> personnel; //j'ai enlever le final car peut etre que c ca qui  pue
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
        //    System.out.println(personnel.get(i).getNom());
        // System.out.println(n + "      Vérifie qu'il ressort bien la variable entreé");
            if (personnel.get(i).getNom().equalsIgnoreCase(n)){
                //System.out.println("Check that we are inside the if");
                personnel.remove(i);
                return;
            }

        
        }


    }
    /*
            while (i< personnel.size() && personnel.get(i).getNom() != n){
            i++;
            System.out.println("I'm a test");
        }
        System.out.println("I'm another test");
        personnel.remove(i);
        i= 0;

        */

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
            s=s+("- "+personnel.get(i).getNom() + "\n");
        }
        return s;
    }

}



