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

    private double distanceAgent(Agent agent, Libere membre){
        return 0;
    }

    private Agent agentPlusProche(Libere membre){
        return null;
    }

    private boolean estInfecte(Libere membre){
        return true;
    }

    private boolean victoire(){
        return true;
    }

    public Libere getMembre(String nom){
        for(int i = 0; i<personnes.size(); i++){
            if(personnes.get(i).getNom().equalsIgnoreCase(nom) && personnes.get(i) instanceof Libere){
                return (Libere) personnes.get(i);
            }
        }

        return null;
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
