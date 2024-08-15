package org.parser;
import org.marsrover.PlateauSize;


public class PlateauParser {

    public PlateauSize plateauParse(String input) {
        String[] plateau = input.trim().split("\\s+");
        if (plateau.length != 2) {
            throw new NumberFormatException("Error: input must contain two values");
        }
        if (input.isEmpty()) {
            throw new NumberFormatException("Error: input cannot be empty");
        }
        int width;
        int height;

        try {
            width = Integer.parseInt(plateau[0]);
            height = Integer.parseInt(plateau[1]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error: width and height must be valid");
        }
        if (width < 0 || height < 0) {
            throw new NumberFormatException("Error: wrong input format.");
        }
        return new PlateauSize(width, height);
    }
}

//Take String as input return PlateauSize
//Input string into an array, trim to remove whitespace from input(beginning or end), \\s+ to match sequence of whitespace
//Convert string to int, first and second
//Create new object with the width and height
//had to add exception to pass test

/*
 if (plateau.length != 2 || input.isEmpty() || input.length() > 2){
            throw new NumberFormatException("Error: wrong input format.");
        }
           int width = Integer.parseInt(plateau[0]);
        int height = Integer.parseInt(plateau[1]);
             return new PlateauSize(width, height);
        }
 */