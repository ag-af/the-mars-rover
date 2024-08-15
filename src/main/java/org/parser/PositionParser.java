package org.parser;

import org.marsrover.CompassDirection;
import org.marsrover.Position;

public class PositionParser {
    public Position positionParse(String input){
        String[] position = input.split(" ");
        int x = Integer.parseInt(position[0]);
        int y = Integer.parseInt(position[1]);
        CompassDirection direction = CompassDirection.valueOf(position[2]);
        return new Position(x, y, direction);
    }
}
//Position 0 = x-coordinate
//Position 1 = y-coordinate
//CompassDirection(direction) convert the 3rd value of position to an instance of the enum
