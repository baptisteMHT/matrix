package com.github.baptistemht.matrix.crew;

public enum Poste {
    PILOTE,ENTRETIEN,MAINTENANCE,COMMUNICATION;

    public static Poste fromString(String s){
        for(int i = 0; i<Poste.values().length; i++){
            if(Poste.values()[i].toString().equalsIgnoreCase(s)) return Poste.values()[i];
        }
        return null;
    }

    public static String listePostes(){
        String s = "";
        for(int i = 0; i<Poste.values().length; i++){
            s+=Poste.values()[i].toString() + " ";
        }
        return s;
    }
}
