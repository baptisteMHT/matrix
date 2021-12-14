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

    public Libere getMembre(String nom){
        for(int i = 0; i<personnes.size(); i++){
            if(personnes.get(i).getNom().equalsIgnoreCase(nom) && personnes.get(i) instanceof Libere){
                return (Libere) personnes.get(i);
            }
        }

        return null;
    }

    public void afficherMatrice(){
        
        
        
        if(victoire()){

        }else{

        }
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

    private ArrayList<Libere> getMembres(){
        ArrayList<Libere> m = new ArrayList<>();
        for(int i = 0; i<personnes.size(); i++){
            if(personnes.get(i) instanceof Libere) m.add((Libere) personnes.get(i));
        }
        return m;
    }
    
    private double distanceAgent(Agent agent, Libere membre){
        return Math.sqrt(agent.getPosition().distance(membre.getPosition()));
    }

    private Agent agentPlusProche(Libere membre){
        Agent plusProche = null;
        for(int i = 0; i<personnes.size(); i++){
            if(personnes.get(i) instanceof Agent){
                if(plusProche == null || distanceAgent(plusProche, membre) > distanceAgent((Agent) personnes.get(i), membre)){
                    plusProche = (Agent) personnes.get(i);
                }
            }
        }
        return plusProche;
    }

    private boolean estInfecte(Libere membre){
        Agent g = agentPlusProche(membre);
        return g.getEfficacite()/distanceAgent(g, membre) > membre.getES();
    }

    private boolean victoire(){
        for(int i = 0; i<personnes.size(); i++){
            if(personnes.get(i) instanceof Agent){
                if(((Agent) personnes.get(i)).getEfficacite() > 0) return false;
            }
        }
        return true;
    }

}
