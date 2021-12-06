package com.github.baptistemht.matrix.crew;

public class Libere extends Personne {
    //attributs
    private int entrees;
    private int sorties;
    //methods

    public Libere(String nom, boolean estHomme, int age, Grade grade, int entrees, int sorties){
        super(nom,estHomme,age,grade);
        this.entrees = entrees;
        this.sorties = sorties;
    }    

    public void setEntrees(int entrees) {
        this.entrees = entrees;
    }

    public int getEntrees() {
        return entrees;
    }

    public void setSorties(int sorties) {
        this.sorties = sorties;
    }

    public int getSorties() {
        return sorties;
    }

}
