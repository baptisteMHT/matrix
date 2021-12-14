package com.github.baptistemht.matrix.matrix;

import java.util.ArrayList;

import com.github.baptistemht.matrix.crew.Agent;
import com.github.baptistemht.matrix.crew.Libere;
import com.github.baptistemht.matrix.crew.Personne;

public class Matrix {
    
    private final ArrayList<Personne> personnes;

    public Matrix(){
        this.personnes = new ArrayList<Personne>();
    }

    public void infiltrer(Libere membre){

    }

    public void sortir(String nom){

    }

    public Agent agentPlusProche(Libere membre){
        return null;
    }

    public double distanceAgent(Agent agent, Libere membre){
        return 0;
    }

    public boolean estInfecte(Libere membre){
        return true;
    }

    public boolean victoire(){
        return true;
    }

    public void afficherMatrice(){

    }

    public void afficherMembres(){

    }

    public void afficherMembresTries(){

    }

}
