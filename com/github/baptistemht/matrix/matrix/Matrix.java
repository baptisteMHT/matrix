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
        personnes.add(membre);
    }

    public void sortir(String nom){
        for(int i = 0; i<personnes.size(); i++){
            if(personnes.get(i).getNom().equalsIgnoreCase(nom) && personnes.get(i) instanceof Libere){
                personnes.remove(i);
                return;
            }
        }
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

    public ArrayList<Personne> membresInfiltres(){
        ArrayList<Personne> membres = new ArrayList<>();
        for(int i = 0; i<personnes.size(); i++){
            if(personnes.get(i) instanceof Libere)  membres.add(personnes.get(i));
        }
        return membres;
    }

    public void afficherMatrice(){
        
    }

    public void afficherMembres(){
        for(int i = 0; i<personnes.size(); i++){
            if(personnes.get(i) instanceof Libere){
                System.out.println(i + ". " + personnes.get(i));
                return;
            }
        }
    }

    public void afficherMembresTries(){

    }

}
