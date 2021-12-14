package com.github.baptistemht.matrix.matrix;

import java.util.Random;

public class Position {

    private final int x;
    private final int y;
    
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position(){
        this(new Random().nextInt(10), new Random().nextInt(10));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        return this.x == ((Position) obj).getX() && this.y == ((Position) obj).getY();
    }

    public double distance(Position pos){
        return Math.sqrt((pos.getX()-this.getX())^2 + (pos.getY()-this.getY())^2);
    }

}
