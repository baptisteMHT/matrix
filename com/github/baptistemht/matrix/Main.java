package com.github.baptistemht.matrix;

import com.github.baptistemht.matrix.ships.Flotte;
import com.github.baptistemht.matrix.ships.Vaisseau;
import com.github.baptistemht.matrix.crew.Libere;
import com.github.baptistemht.matrix.crew.Sion;
import com.github.baptistemht.matrix.ships.Equipage;

import in.keyboard.Keyboard;

public class Main {
    public static void main(String args[]){

        // constantes
        final int MAX_PERSONNEL = 100;
        final int MAX_EQUIPAGE  = 5; 

        // Nouvelle flotte et Liste du personnel
        Flotte fleet    = new Flotte("Flotte de Sion");
        Equipage sion  = new Equipage(MAX_PERSONNEL);


        //Affichage du menu
        System.out.println("Bienvenue in the Matrice");
        displayMenu();

        int choix = Keyboard.getInt();
        String name;

        //utilisation de switch pour les différentes réponses
        while(choix != 8){

            switch(choix){
                case 1:

                    System.out.print("Nom de la personne : ");
                    name = Keyboard.getString();
                    
                    while(sion.getPersonne(name) != null){
                        System.out.println("Ce nom existe déjà.");
                        System.out.print("Nom de la personne : ");
                        name = Keyboard.getString();
                    }

                    System.out.println("Voulez vous créer un Sion ou un membre libéré ?");
                    System.out.println("1: Sion");
                    System.out.println("2: Membre libéré");
                    System.out.println("");
                    System.out.print("> ");
                    choix = Keyboard.getInt();
                    
                    while(choix != 1 || choix != 2){
                        System.out.println("Voulez vous créer un Sion ou un membre libéré ?");
                        System.out.println("1: Sion");
                        System.out.println("2: Membre libéré");
                        System.out.println("");
                        System.out.print("> ");
                        choix = Keyboard.getInt();
                    }

                    if(choix == 1){
                        sion.addPersonne(new Sion(name, true, 18, null, null));
                        System.out.println("Sion " + name + " ajouté à la liste du personnel.");
                    }else{
                        System.out.println("Membre libéré " + name + " ajouté à la liste du personnel.");
                        sion.addPersonne(new Libere(name, true, 18, null, 0, 0));
                    }
                    
                    break;

                case 2:
                    System.out.println("La liste des membres du personnel est : ");
                    //afficher l'ensemble des personnes

                    break;
                

                case 3:
                    //faire la demande pour créer un vaisseau
                    System.out.print("Choisissez un nom de vaisseau : ");
                    name = Keyboard.getString();

                    
                    while(fleet.getVaisseau(name) != null){
                        System.out.println("Ce vaisseau existe déjà.");
                        System.out.print("Choissisez un nom de vaisseau : ");
                        name = Keyboard.getString();
                    }

                    fleet.addVaisseau(new Vaisseau(name, MAX_EQUIPAGE));
                    System.out.println("Vaisseau " + name + " ajouté à la flotte.");
                    break;

                case 4:
                    if(fleet.getVaisseaux().size() == 0){
                        System.out.println("Il n'y a aucun vaisseau d'enregistré.");
                        break;
                    }
                    System.out.println("Liste des vaisseaux : ");
                    for(int i = 0; i<fleet.getVaisseaux().size(); i++){
                        System.out.println(i + ". " + fleet.getVaisseaux().get(i));
                    }
                    break;

                case 5:
                    //demander dans quel vaisseau
                    //créer une personne
                    // ou utiliser une personne de la liste du personnel 
                    break;
                case 6:
                    System.out.print("Nom du vaisseau : ");
                    String n = Keyboard.getString();

                    System.out.println(fleet.getVaisseau(n));
                    
                    while(fleet.getVaisseau(n) == null){
                        System.out.println("Ce vaisseau n'existe pas.");
                        System.out.print("Nom du vaisseau : ");
                        n = Keyboard.getString();
                    }

                    System.out.println("Liste des membres du vaisseau " + n + " :");
                    System.out.println(fleet.getVaisseau(n).getEquipage());

                    break;
                case 7:
                    //demander quel vaisseau
                    //demander le nom de la personne
                    // le supprimer du vaisseau UNIQUEMENT
                    break;
                
                default:
                    System.out.println("Choix incorrect.");
                    break;

            }

            displayMenu();
            choix = Keyboard.getInt();
        }

        System.out.println("Goodbye my friend...");
    }

    private static void displayMenu(){
        System.out.println("");
        System.out.println("Que voulez vous faire ?");
        System.out.println("1: Créer une personne");              
        System.out.println("2: Afficher la liste du personnel");
        System.out.println("3: Créer un vaisseau");
        System.out.println("4: Afficher la liste des vaisseaux");
        System.out.println("5: Ajouter un membre du personnel dans un certain vaisseau");
        System.out.println("6: Afficher l'ensemble des personnes d'un vaisseau");
        System.out.println("7: Supprimer un membre d'un équipage");
        System.out.println("8: Fin");
        System.out.println("");
        System.out.print("> ");
    }
    
}
