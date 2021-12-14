package com.github.baptistemht.matrix.crew;

public class Position {

    private final int x;
    private final int y;
    
    public Position(int x, int y){
        this.x = x;
        this.y = y;
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

}
