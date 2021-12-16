package com.github.baptistemht.matrix.crew;

public abstract class Personne {

    public abstract String getNom();

    public abstract int getAge();

    public abstract Grade getGrade();

    public abstract boolean isEstHomme();

    public abstract void setAge(int age);

    public abstract void setGrade(Grade grade);
    
}
