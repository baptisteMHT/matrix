package com.github.baptistemht.matrix;

import com.github.baptistemht.matrix.crew.Personnel;
import com.github.baptistemht.matrix.ships.Flotte;

import in.keyboard.Keyboard;

public class Main {
    public static void main(String args[]){

        // constantes
        final int MAX_PERSONNEL = 100;
        final int MAX_VAISSEAU  = 5; 

        // Nouvelle flotte et Liste du personnel
        Flotte fleet    = new Flotte("Flotte de Sion");
        Personnel sion  = new Personnel(MAX_PERSONNEL);


        //Affichage du menu
        System.out.println("Bienvenue in the Matrice");
        displayMenu();

        int choix = Keyboard.getInt();

        //utilisation de switch pour les différentes réponses
        while(choix != 8){
            switch(choix){
                case 1:
                    System.out.println("Voulez vous créer une Sion ou membre libéré ?");
                    System.out.println("1: Sion");
                    System.out.println("2: Membre libéré");
                    choix = Keyboard.getInt();
                    switch(choix){
                        case 1:

                            //faire les demandes pour creer un sion
                            break;
                        case 2:
                            //faire les demandes pour creer un membre libre
                            break;
                        default:
                            System.out.println("Choix incorrect");
                            choix = 1;  //permet de retourner a la question précédente si mauvais imput.

                    }
                    break;

                case 2:
                System.out.println("La liste des membres du personnel est : ");
                //afficher l'ensemble des personnes

                    break;
                

                case 3:
                    //faire la demande pour créer un vaisseau
                    break;

                case 4:
                    System.out.println("La liste des vaisseaux est : ");
                    //afficher la liste des vaiseaux
                    break;

                case 5:
                    //demander dans quel vaisseau
                    //créer une personne
                    // ou utiliser une personne de la liste du personnel 
                    break;
                case 6:
                    //demande le nom du vaisseau dont l'on veut afficher la liste 
                    System.out.println("La liste des membres du vaisseau " + "NON DU VAISSEAU" + " est :");
                    //afficher cette liste
                    break;
                case 7:
                    //demander quel vaisseau
                    //demander le nom de la personne
                    // le supprimer du vaisseau UNIQUEMENT
                    break;
                
                default:
                    System.out.println("Choix incorrect");
                    return; //arret la boucle car choix incorect

            }

            displayMenu();
            choix = Keyboard.getInt();
        }

        System.out.println("Goodbye my friends...");
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
