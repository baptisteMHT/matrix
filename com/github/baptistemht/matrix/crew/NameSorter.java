package com.github.baptistemht.matrix.crew;

import java.util.Comparator;

public class NameSorter implements Comparator<Personne>{

    @Override
    public int compare(Personne o1, Personne o2) {
        return o1.getNom().compareToIgnoreCase(o2.getNom());
    }
    
}
