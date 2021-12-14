package com.github.baptistemht.matrix;

import com.github.baptistemht.matrix.ships.Flotte;
import com.github.baptistemht.matrix.ships.Vaisseau;
import com.github.baptistemht.matrix.crew.Libere;
import com.github.baptistemht.matrix.crew.Sion;
import com.github.baptistemht.matrix.ships.Equipage;
import com.github.baptistemht.matrix.crew.Personne;

import in.keyboard.Keyboard;

public class Main {
    public static void main(String args[]){

        // constantes
        final int MAX_PERSONNEL = 100;
        final int MAX_EQUIPAGE  = 5; 

        // Nouvelle flotte et Liste du personnel
        Flotte fleet    = new Flotte("Flotte de Sion");
        Equipage sion  = new Equipage(MAX_PERSONNEL);



        //--------------------------------------------------------------------------
        //For testing and winning time. Create 2 members and a ship. The two members are in the same ship call 'v'
        Libere Eric = new Libere("Eric",true,798,null);
        Sion Didier = new Sion("didier",true,45,null,null);
        Vaisseau V = new Vaisseau("v",5);
        fleet.addVaisseau(V);
        fleet.getVaisseau("v").getEquipage().addPersonne(Didier);
        Sion a = new Sion("a",true,45,null,null);
        fleet.getVaisseau("v").getEquipage().addPersonne(a);
        Libere Maurice = new Libere("Maurice",true,4,null);
        fleet.getVaisseau("v").getEquipage().addPersonne(Maurice);
        sion.addPersonne(Eric);
        sion.addPersonne(Didier);
        sion.addPersonne(a);
        sion.addPersonne(Maurice);

        //--------------------------------------------------------------------------

        //Affichage du menu
        System.out.println("Bienvenue in the Matrice");
        displayMenu();

        int choix = Keyboard.getInt();
        String name;

        //utilisation de switch pour les différentes réponses
        while(choix != 8){

            switch(choix){
                case 1:
                    createCrew(sion);
                    break;

                case 2:
                    System.out.println("Liste des membres du personnel : ");
                    System.out.println(sion);
                    break;

                case 3:
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
                    
                    name = findExistingShip(fleet);
                    System.out.println("Le membre d'équipage que vous voulez ajouter à votre vaisseau existe-il déjà ?");
                    System.out.println("1: Oui");
                    System.out.println("2: Non");
                    
                    choix = Keyboard.getInt();
                    while(choix != 1 && choix != 2){
                        System.out.println("Le membre d'équipage que vous voulez ajouter à votre vaisseau existe-il déjà ?");
                        System.out.println("1: Oui");
                        System.out.println("2: Non");
                        choix = Keyboard.getInt();
                    }

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

                    System.out.println("Quel est le nom de la personne que vous voulez supprimer du vaisseau ?");
                    String np = Keyboard.getString();
                    while(fleet.getVaisseau(name).getEquipage().getPersonne(np)==null){
                        System.out.println("Cette personne n'est pas dans l'équipage");
                        System.out.println("Quel est le nom de la personne que vous voulez supprimer du vaisseau ?");
                        np = Keyboard.getString();
                        
                    }
                    
                    
                    fleet.getVaisseau(name).getEquipage().removePersonne(np);
                    break;
                
                default:
                    System.out.println("Choix incorrect.");
                    break;
            }
            displayMenu();
            choix = Keyboard.getInt();
        }
        System.out.println("Goodbye my friend...");



         /* -----------------------------------------------------------------------------------------------------
         
         
         deuxieme mission:
    Je sais pas si faut le mettre après ce main ou ailleurs
    

    */

    System.out.println("Deuxième mission");
    displayMenu2();
    int s = Keyboard.getInt();
    while(s != 7){
        switch(s){
            case 1: 
                afficheInfiltrables(fleet);


                break;

            case 2: //vérifier si peut infiltrer puis utiliser infiltré de matrix

            break;

            case 3:

                break;

            case 4: // penser a faire +1 au nombre d'entrée sortie

                break;

            case 5: // afficher la matrix Utiliser la fonction faite dans matrix

                break;
            case 6: // afficher dans l'ordre alphabétique/ Utiliser la fonction faite dans matrix

                break;
            
            default:
            System.out.println("Choix incorrect");
                break;
        }
        displayMenu2();
        s = Keyboard.getInt();
    }

    
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
    //deuxieme menu 
    private static void displayMenu2(){
        System.out.println("");
        System.out.println("Que voulez vous faire ?");
        System.out.println("1: Afficher les membres d'équipages pouvant s'infiltrer dans la matrix");              
        System.out.println("2: Infiltrer un mepmbre dans la matrix");
        System.out.println("3: Afficher les membres d'équipages actuellement dans la matrix"); //doit  on mettre les 3 agents de bases dans cette liste ? 
        System.out.println("4: Sortir un membre de la matrix");
        System.out.println("5: Afficher la matrix");
        System.out.println("6: Afficher les membres de la matrix par ordre alphabétique");
        System.out.println("7: Fin");
        System.out.println("");
        System.out.print("> ");

    }
    

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
        System.out.println("Quel est le nom de l'agent que vous souhaitez ajouter?");
        String name = Keyboard.getString();
        System.out.println(eq.getPersonne(name));
        while(eq.getPersonne(name) == null){
            System.out.println("Cette personne n'existe pas.");
            System.out.println("Quel est le nom de l'agent que vous souhaitez ajouter?");
            name = Keyboard.getString();
        }
        return eq.getPersonne(name);
    }

    private static Personne createCrew(Equipage crew){
        System.out.print("Nom de la personne : ");
        String name = Keyboard.getString();
        
        while(crew.getPersonne(name) != null){
            System.out.println("Ce nom existe déjà.");
            System.out.print("Nom de la personne : ");
            name = Keyboard.getString();
        }

        System.out.print("Age de la personne : ");
        int age = Keyboard.getInt();
        
        System.out.println("Sexe de la personne :");
        System.out.println("1: Masculin");
        System.out.println("2: Féminin");
        System.out.println("");
        System.out.print("> ");
        int choix = Keyboard.getInt();
        
        while(choix != 1 && choix != 2){
            System.out.println("Sexe de la personne :");
            System.out.println("1: Masculin");
            System.out.println("2: Féminin");
            System.out.println("");
            System.out.print("> ");
            choix = Keyboard.getInt();
        }

        boolean estHomme;

        if(choix == 1){
            estHomme = true;
        }else{
            estHomme = false;
        } 

        System.out.println("Voulez vous créer un Sion ou un membre libéré ?");
        System.out.println("1: Sion");
        System.out.println("2: Membre libéré");
        System.out.println("");
        System.out.print("> ");
        choix = Keyboard.getInt();
        
        while(choix != 1 && choix != 2){
            System.out.println("Voulez vous créer un Sion ou un membre libéré ?");
            System.out.println("1: Sion");
            System.out.println("2: Membre libéré");
            System.out.println("");
            System.out.print("> ");
            choix = Keyboard.getInt();
        }

        if(choix == 1){
            crew.addPersonne(new Sion(name, estHomme, age, null, null));
            System.out.println(name + " ajouté à la liste du personnel. (Type: Sion, Homme: " + estHomme + ", Age: " +age + ")");
        }else{
            crew.addPersonne(new Libere(name, estHomme, age, null));
            System.out.println(name + " ajouté à la liste du personnel. (Type: Membré libéré, Homme: " + estHomme + ", Age: " +age + ")");
        }

        return new Personne(name,estHomme, age,null);







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
