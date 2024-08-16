package org.marsrover;

import java.util.Objects;

public class Position {
    private int x;
    private int y;
    private CompassDirection direction;// this can be whatever your direction enum is called

    public Position(int x, int y, CompassDirection direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CompassDirection getDirection() {
        return direction;
    }

    public void setDirection(CompassDirection direction) {
        this.direction = direction;
    }

}
