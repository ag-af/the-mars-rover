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
    }
}
