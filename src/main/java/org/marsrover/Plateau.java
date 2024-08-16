package org.marsrover;

import java.util.HashSet;
import java.util.Set;

public class Plateau {
    private final PlateauSize size;
    private final Set<Rover> rovers = new HashSet<>();

    public Plateau(PlateauSize size) {
        this.size = size;
    }

    public PlateauSize getSize(){
        return size;
    }

    public void addRover(Rover rover){
        Position position = rover.getPosition();
        if(isPositionOccupied(position.getX(), position.getY())) {
            throw new IllegalArgumentException("Position is occupied");
        }
        if (position.getX() < 0 || position.getX() >= size.getWidth() ||
        position.getY() <0 || position.getY() >= size.getHeight()) {
            throw new IllegalArgumentException("Position is out of bounds");
        }
        rovers.add(rover);
    }

    public boolean isPositionOccupied(int x, int y){
        return rovers.stream().anyMatch(r -> r.getPosition().getX() == x &&
                r.getPosition().getY() == y);
    }

    public Set<Rover> getRovers(){
        return rovers;
    }
}
