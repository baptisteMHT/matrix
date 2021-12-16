package com.github.baptistemht.matrix.crew;

public enum Grade {
    AGENT,LIEUTENANT,COMMANDANT,COLONEL,SERGENT,CAPORAL,GENERAL;
    
    public static Grade fromString(String s){
        for(int i = 0; i<Grade.values().length; i++){
            if(Grade.values()[i].toString().equalsIgnoreCase(s)) return Grade.values()[i];
        }
        return null;
    }

    public static String listeGrades(){
        String s = "";
        for(int i = 0; i<Grade.values().length; i++){
            s+=Grade.values()[i].toString() + " ";
        }
        return s;
    }
}
