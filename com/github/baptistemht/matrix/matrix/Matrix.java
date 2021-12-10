package com.github.baptistemht.matrix.matrix;

import java.util.ArrayList;

import com.github.baptistemht.matrix.crew.Grade;
import com.github.baptistemht.matrix.crew.Infiltre;
import com.github.baptistemht.matrix.crew.Libere;

public class Matrix {

    private final ArrayList<Infiltre> infiltres;

    public Matrix(){
        this.infiltres = new ArrayList<Infiltre>();
        infiltres.add(new Infiltre("agent_0", true, 26, Grade.AGENT));
        infiltres.add(new Infiltre("agent_1", false, 49, Grade.AGENT));
        infiltres.add(new Infiltre("agent_2", true, 18, Grade.AGENT));
    }

    public void infiltrerMembre(Libere p){
        
    }

    public void sortirMembre(String name){

    }

    public void membresInfiltres(){

    }

    public void afficherMatrice(){

    }

}
