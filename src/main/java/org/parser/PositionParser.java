package org.parser;

import org.marsrover.CompassDirection;
import org.marsrover.Position;

import java.util.HashSet;
import java.util.Set;

public class PositionParser {
    public Position positionParse(String input){
        String[] position = input.trim().split(" ");
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Error: input cannot be empty");
        }
        if(position.length != 3){
            throw new IllegalArgumentException("Error: input must contain three values");
        }

        int x;
        int y;
        CompassDirection direction;

        try {
            x = Integer.parseInt(position[0]);
            y = Integer.parseInt(position[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: coordinate must be valid");
        }

        try {
            direction = CompassDirection.valueOf(position[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: direction must be valid");
        }

        return new Position(x, y, direction);
    }
}
//Position 0 = x-coordinate
//Position 1 = y-coordinate
//CompassDirection(direction) convert the 3rd value of position to an instance of the enum
