package parser;
import org.marsrover.PlateauSize;


public class PlateauParser {

    public PlateauSize plateauParse(String input){
        String[] plateau = input.trim().split("\\s+");
//        if (plateau.length != 2){
//            throw new IllegalArgumentException("Invalid input format");
//        }
        int width = Integer.parseInt(plateau[0]);
        int height = Integer.parseInt(plateau[1]);
        return new PlateauSize(width, height);
    }
}
//Take String as input return PlateauSize
//Input string into an array, trim to remove whitespace from input(beginning or end), \\s+ to match sequence of whitespace
//Convert string to int, first and second
//Create new object with the width and height