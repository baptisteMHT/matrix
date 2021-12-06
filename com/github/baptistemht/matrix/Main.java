package com.github.baptistemht.matrix;
import in.keyboard.Keyboard;
import com.github.baptistemht.matrix.crew.Personnel;

public class Main {
    public static void main(String args[]){
        //attributs
        final int MAX = 5;
        int choix;
        Personnel sion = new Personnel(MAX);

        //methods


        //mise en place du menu 

        System.out.println("Que voulez vous faire ?");
        System.out.println("1: Créer une personne");              
        System.out.println("2: Afficher la liste du personnel");
        System.out.println("3: Créer un vaisseau");
        System.out.println("4: Afficher la liste des vaisseaux");
        System.out.println("5: Ajouter un membre du personnel dans un certain vaisseau");
        System.out.println("6: Afficher l'ensemble des personnes d'un vaisseau");
        System.out.println("7: Supprimer un membre d'un équipage");
        System.out.println("8: Fin");
        choix = Keyboard.getInt();

        //utilisation de switch pour les différentes réponses
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

                }
                break;

            case 2:
               //afficher l'ensemble des personnes

                break;
            

            case 3:
                //faire la demande pour créer un vaisseau
                break;

            case 4:

                //afficher la liste des vaiseaux
                break;

            case 5:
                //demander dans quel vaisseau
                //créer une personne
                // ou utiliser une personne de la liste du personnel 
                break;
            case 6:
                //demande le nom du vaisseau dont l'on veut afficher la liste 
                //afficher cette liste
                break;
            case 7:
                //demander quel vaisseau
                //demander le nom de la personne
                // le supprimer du vaisseau UNIQUEMENT
                break;
            case 8:
                //dire merci aurevoir et return null tout le tralala
                break;
            default:
                System.out.println("Choix incorrect");
        }



    }
    
}
