package com.github.baptistemht.matrix.crew;

import java.util.ArrayList;

import javax.print.attribute.standard.PresentationDirection;

public class Personnel {
    //attributs
    ArrayList<Personne> Personnel = new ArrayList<Personne>();
    //methods

    public void addPersonne(Personne p){
        Personnel.add(p);
    }
    public ArrayList<Personne> getPersonnel() {
        return Personnel;
    }

    public void removePersonne(String n){
        int i = 0;
        while (i< Personnel.size() && Personnel.get(i).getNom() != n){
            i++;
        }
        Personnel.remove(i);
        i= 0;
        

    }

    public Personne getPersonne(String n){
        int i = 0;
        while (i< Personnel.size() && Personnel.get(i).getNom()!= n){
            i++;

        }

        return Personnel.get(i);
    }

}