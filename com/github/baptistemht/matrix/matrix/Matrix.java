package com.github.baptistemht.matrix.matrix;

import java.util.ArrayList;

import com.github.baptistemht.matrix.crew.Agent;
import com.github.baptistemht.matrix.crew.Libere;
import com.github.baptistemht.matrix.crew.Personne;

public class Matrix {
    
    private final ArrayList<Personne> personnes;

    public Matrix(){
        this.personnes = new ArrayList<Personne>();
        this.personnes.add(new Agent("agent_0", true, 36, trouverPositionLibre()));
        this.personnes.add(new Agent("agent_1", true, 29, trouverPositionLibre()));
        this.personnes.add(new Agent("agent_2", true, 48, trouverPositionLibre()));
    }

    public void infiltrer(Libere membre){
        membre.setPosition(trouverPositionLibre());
        if(estInfecte(membre)){
            membre.setEstInfecte(true);
        }else{
            agentPlusProche(membre).reduireEfficacite();
        }
        personnes.add(membre);
    }

    public boolean sortir(String nom){
        for(int i = 0; i<personnes.size(); i++){
            if(personnes.get(i).getNom().equalsIgnoreCase(nom) && personnes.get(i) instanceof Libere){
                if(((Libere) personnes.get(i)).isEstInfecte()) return false;
                personnes.remove(i);
                return true;
            }
        }
        return false;
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
        System.out.println("");
        System.out.println("    0  1  2  3  4  5  6  7  8  9  ");
        for(int i = 0; i<10; i++){
            System.out.print(" "+ i +" ");
            for(int j = 0; j<10; j++){

                Personne p = getPersonneFromPosition(new Position(i, j));
                
                if(p instanceof Agent){
                    System.out.print(" A" + ((Agent) p).getEfficacite());
                }else if(p instanceof Libere){
                    if(((Libere) p).isEstInfecte()){
                        System.out.print(" m ");
                    }else{
                        System.out.print(" M ");
                    }
                }else {
                    System.out.print(" . ");
                }

            }
            System.out.println("");
        }
        
        if(victoire()) System.out.println("Tous les agents sont vaincus. Victore de la flotte de Sion !");
    }

    private Personne getPersonneFromPosition(Position position){
        for(int i = 0; i<personnes.size(); i++){
            if(personnes.get(i) instanceof Agent){
                if(((Agent) personnes.get(i)).getPosition().equals(position)) return personnes.get(i);
            }else if(personnes.get(i) instanceof Libere){
                if(((Libere) personnes.get(i)).getPosition().equals(position)) return personnes.get(i);
            }
        }
        return null;
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
        double d = agent.getPosition().distance(membre.getPosition());
        System.out.println(membre.getNom() + " | " + agent.getNom() + " " + agent.getEfficacite() + " | dist : " + d);
        return d;
    }

    private Agent agentPlusProche(Libere membre){
        Agent plusProche = null;
        for(int i = 0; i<personnes.size(); i++){
            if(personnes.get(i) instanceof Agent){
                if(plusProche == null){
                    plusProche = (Agent) personnes.get(i);
                }else{
                    if(distanceAgent(plusProche, membre) > distanceAgent((Agent) personnes.get(i), membre)){
                        plusProche = (Agent) personnes.get(i);
                    }
                }             
            }
        }
        return plusProche;
    }

    private boolean estInfecte(Libere membre){
        Agent g = agentPlusProche(membre);
        System.out.println(g.getNom() + g.getEfficacite() + " est l'agent le plus proche.");
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

    private Position trouverPositionLibre(){
        Position pos = new Position();
        while(getPersonneFromPosition(pos) != null){
            pos = new Position();
        }
        return pos;
    }

}
