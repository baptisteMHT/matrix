package com.github.baptistemht.matrix.crew;

public class Libere extends Personne {
    //attributs
    private int entreesSorties;
    private Position position;
    //methods

    public Libere(String nom, boolean estHomme, int age, Grade grade){
        super(nom,estHomme,age,grade);
        this.entreesSorties = 0;
        this.position = null;
    }    

    public int getES() {
        return entreesSorties;
    }

    public void incrementES(){
        this.entreesSorties +=1;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
