/*
Voici le lien du github utilisé afin de pouvoir collaborer de la meilleure des façons.
https://github.com/baptisteMHT/matrix
*/

package com.github.baptistemht.matrix;
import com.github.baptistemht.matrix.ships.Flotte;
import com.github.baptistemht.matrix.ships.Vaisseau;
import com.github.baptistemht.matrix.crew.Grade;
import com.github.baptistemht.matrix.crew.Libere;
import com.github.baptistemht.matrix.crew.Sion;
import com.github.baptistemht.matrix.matrix.Matrix;
import com.github.baptistemht.matrix.ships.Equipage;
import com.github.baptistemht.matrix.crew.Personne;
import com.github.baptistemht.matrix.crew.Poste;
import in.keyboard.Keyboard;


public class Main {
    public static void main(String args[]){

        // constantes
        final int MAX_PERSONNEL = 100;
        final int MAX_EQUIPAGE  = 5; 

        // Nouvelle flotte et Liste du personnel
        Flotte fleet    = new Flotte("Flotte de Sion");
        Equipage sion  = new Equipage(MAX_PERSONNEL);
        Matrix matrix = new Matrix();

        //Affichage du menu
        System.out.println(" Matrix v1.0 - Par Mathys et Baptiste");
        System.out.println("Bienvenue dans la Matrice !");
        displayMenu();

        int choix = Keyboard.getInt();
        String name;

        //utilisation de switch pour les différentes réponses
        while(choix != 14){

            switch(choix){
                case 1: //permet de créer un personnage on utilise donc la fonction faite pour
                    createCrew(sion);
                    break;

                case 2:
                    System.out.println("Liste des membres du personnel : ");
                    System.out.println(sion);
                    break;

                case 3:
                    System.out.print("Nom du vaisseau : ");
                    name = Keyboard.getString();

                    
                    while(fleet.getVaisseau(name) != null){
                        System.out.println("Ce vaisseau existe déjà.");
                        System.out.print("Nom du vaisseau : ");
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

                    do {
                        name = findExistingShip(fleet);
                        System.out.println("Ajouter un membre existant ?");
                        System.out.println("1: Oui");
                        System.out.println("2: Non");
                        System.out.println("");
                        System.out.print("> ");           
                        choix = Keyboard.getInt();
                    } while (choix != 1 && choix != 2);

                    if (choix==1){
                        fleet.getVaisseau(name).getEquipage().addPersonne(findExistingMember(sion));
                    }else {
                        fleet.getVaisseau(name).getEquipage().addPersonne(createCrew(sion));
                    }

                    break;

                case 6:
                    name = findExistingShip(fleet);

                    System.out.println("Liste des membres du vaisseau " + name + " :");
                    System.out.println(fleet.getVaisseau(name).getEquipage());
                    break;

                case 7:
                    name = findExistingShip(fleet);

                    System.out.print("Nom de la personne à supprimer du vaisseau : ");
                    String np = Keyboard.getString();
                    while(fleet.getVaisseau(name).getEquipage().getPersonne(np)==null){
                        System.out.println("Cette personne n'est pas dans l'équipage");
                        System.out.print("Nom de la personne à supprimer du vaisseau : ");
                        np = Keyboard.getString();
                    }
                    
                    fleet.getVaisseau(name).getEquipage().removePersonne(np);
                    break;

                case 8:
                    afficheInfiltrables(fleet);

                    break;

                case 9:
                    System.out.print("Nom de la personne à infiltrer : ");
                    String nom = Keyboard.getString();

                    boolean done = false; // Cette variable permettra l'affichage utilisateur final.

                    //Un membre est infiltrable si:
                    //                              - Il est dans un vaisseau sécurisé
                    //                              - C'est un membre libre
                    // Voilà pourquoi on suit la démarche suivante.

                    for (int i = 0; i< fleet.getVaisseaux().size() ; i++){ //On parcourt tous les vaisseaux de la flotte
                        if (fleet.getVaisseaux().get(i).estSecurise() ){ // On ne retient que ceux sécurisés

                            for (int k = 0; k<fleet.getVaisseaux().get(i).getEquipage().getPersonnel().size(); k++){ // On parcourt l'équipage de ces vaisseaux
                                
                                // On ne retient que les membres libres ET ayant le même nom rentré par l'utilisateur.
                                if (fleet.getVaisseaux().get(i).getEquipage().getPersonnel().get(k) instanceof Libere && fleet.getVaisseaux().get(i).getEquipage().getPersonnel().get(k).getNom().equalsIgnoreCase(nom)){
   
                                    // On vérifie qu'il n'est pas déjà infiltré.
                                    if(matrix.getMembre(nom) == null){

                                        // On ajoute le membre à la matrice et on incrémente ces ES. (En entrée plutôt qu'en sortie pour ne pas mourir instantanément).
                                        ((Libere) fleet.getVaisseaux().get(i).getEquipage().getPersonnel().get(k)).incrementES();
                                        matrix.infiltrer((Libere) fleet.getVaisseaux().get(i).getEquipage().getPersonnel().get(k));
                                        done = true;
                                    }
                                }
                            } 
                        }
                    }

                    if(done){
                        System.out.println(nom + " vient d'infiltrer la matrice.");
                    }else{
                        System.out.println("Le nom est incorrect ou le membre déjà infiltré.");
                    }

                    break;

                case 10:

                    //Affiche les membres infiltrés dans la matrice.
                    matrix.afficherMembres();

                    break;
                case 11: 
                    System.out.print("Nom du membre à faire sortir : ");
                    String n = Keyboard.getString();
                    //On vérifie dans un premier temps que le membre est bien infiltré.
                    while(matrix.getMembre(n) == null){
                        System.out.println("Cette personne n'est pas infiltrée.");
                        System.out.print("Nom du membre à faire sortir : ");
                        n = Keyboard.getString();
                    }

                    Libere membre = matrix.getMembre(n);
                    
                    // On test si la sortie est réussie ou non. 

                    // Elle est réussi si il n'est pas infecté.
                    if(!matrix.sortir(n)){
                        System.out.println(membre.getNom() + " est infecté. Il ne peut pas sortir de la matrice.");
                        ((Libere) sion.getPersonne(n)).setEstInfecte(true);
                    }

                    break;

                case 12:
                    matrix.afficherMatrice();
                    break;

                case 13:
                    matrix.afficherMembresTries();
                    break;
                    
                default: // Ce message est affiché et la boucle est relancée pour toute entrée par l'utilisateur n'étant pas 
                // un nombre compris entre 1 et 14 correspondant à tous les choix possible (fin incluse).
                    System.out.println("Choix incorrect.");
                    break;
            }
            // On réaffiche le menu et reprenons le choix tant que la fin n'est pas demandée.
            displayMenu();
            choix = Keyboard.getInt();
        }
        System.out.println("Goodbye my friend..."); //ici l'utilisateur met fin au jeu en entrant 14.

    }


    //Afin de rendre le code plus lisible mise en place de la procédure displayMenu permettant d'afficher tout le menu.
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
        System.out.println("8: Afficher les membres d'équipages pouvant s'infiltrer dans la matrice");              
        System.out.println("9: Infiltrer un membre dans la matrice");
        System.out.println("10: Afficher les membres d'équipages infiltrés dans la matrice"); 
        System.out.println("11: Sortir un membre de la matrice");
        System.out.println("12: Afficher la matrice");
        System.out.println("13: Afficher les membres de la matrice par ordre alphabétique");
        System.out.println("14: Fin");
        System.out.println("");
        System.out.print("> ");
    }

    
// ici ce trouve toutes les fonctions rédigées hors du switch car utilisables plusieurs fois, ou alors
// afin d'améliorer la lisibilité.
    private static String findExistingShip(Flotte fleet){
        System.out.print("Nom du vaisseau : ");
        String name = Keyboard.getString();

        System.out.println(fleet.getVaisseau(name));
        
        while(fleet.getVaisseau(name) == null){
            System.out.println("Ce vaisseau n'existe pas.");
            System.out.print("Nom du vaisseau : ");
            name = Keyboard.getString();
        }

        return name;
    }

    private static Personne findExistingMember(Equipage eq){
        System.out.print("Nom de l'agent à ajouter : ");
        String name = Keyboard.getString();

        while(eq.getPersonne(name) == null){
            System.out.println("Cette personne n'existe pas.");
            System.out.print("Nom de l'agent à ajouter : ");
            name = Keyboard.getString();
        }
        return eq.getPersonne(name);
    }

    private static Personne createCrew(Equipage crew){
        System.out.print("Nom : ");
        String name = Keyboard.getString();
        
        while(crew.getPersonne(name) != null){
            System.out.println("Ce nom existe déjà.");
            System.out.print("Nom : ");
            name = Keyboard.getString();
        }

        System.out.print("Age : ");
        int age = Keyboard.getInt();

        int choix;

        do{
            System.out.println("Sexe :");
            System.out.println("1: Masculin");
            System.out.println("2: Féminin");
            System.out.println("");
            System.out.print("> ");
            choix = Keyboard.getInt();
        }while(choix != 1 && choix != 2);

        boolean estHomme;

        if(choix == 1){
            estHomme = true;
        }else{
            estHomme = false;
        }

        System.out.print("Grade ("+ Grade.listeGrades() +") : ");
        Grade grade = Grade.fromString(Keyboard.getString());
        
        while(grade == null){
            System.out.println("Ce grade n'existe pas.");
            System.out.print("Grade : ");
            grade = Grade.fromString(Keyboard.getString());
        }
        

        do{
            System.out.println("Voulez vous créer un Sion ou un membre libéré ?");
            System.out.println("1: Sion");
            System.out.println("2: Membre libéré");
            System.out.println("");
            System.out.print("> ");
            choix = Keyboard.getInt();
        }while(choix != 1 && choix != 2);

        if(choix == 1){
            System.out.print("Poste ("+ Poste.listePostes() +") : ");
            Poste poste = Poste.fromString(Keyboard.getString());
            
            while(poste == null){
                System.out.println("Ce poste n'existe pas.");
                System.out.print("Poste : ");
                poste = Poste.fromString(Keyboard.getString());
            }

            Sion s = new Sion(name,estHomme,age,grade,poste);
            crew.addPersonne(s);
            System.out.println("Ajouté à la liste du personnel : " + s);
            return s;
        }else{
            Libere l = new Libere(name, estHomme,age,grade);
            crew.addPersonne(l);
            System.out.println("Ajouté à la liste du personnel : " + l);
            return l;
        }

    }

    public static void afficheInfiltrables(Flotte fleet){
        for (int i = 0; i< fleet.getVaisseaux().size() ; i++){
            if (fleet.getVaisseaux().get(i).estSecurise()){
                for (int k = 0; k<fleet.getVaisseaux().get(i).getEquipage().getPersonnel().size(); k++){
                     if (fleet.getVaisseaux().get(i).getEquipage().getPersonnel().get(k) instanceof Libere){
                         System.out.println(fleet.getVaisseaux().get(i).getEquipage().getPersonnel().get(k).toString()); 
                    }
                 } 
            }
         }
    }


    

}
