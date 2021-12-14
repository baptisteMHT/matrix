package com.github.baptistemht.matrix.crew;

public class Libere extends Personne {
    //attributs
    private int entreesSorties;
    //methods

    public Libere(String nom, boolean estHomme, int age, Grade grade){
        super(nom,estHomme,age,grade);
        this.entreesSorties = 0;
    }    

    public int getES() {
        return entreesSorties;
    }

    public void incrementES(){
        this.entreesSorties +=1;
    }

}
