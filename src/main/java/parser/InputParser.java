package parser;

import org.marsrover.Instruction;
import org.marsrover.PlateauSize;
import org.marsrover.Position;

import java.util.List;

public class InputParser {
    private final PlateauParser plateauParser = new PlateauParser();
    private final PositionParser positionParser = new PositionParser();
    private final InstructionParser instructionParser = new InstructionParser();

    public PlateauSize parsePlateauSize(String input){
        return plateauParser.plateauParse(input);
    }

    public Position parsePosition(String input){
        return positionParser.positionParse(input);
    }

    public List<Instruction> parseInstructions(String input){
        return instructionParser.instructionParse(input);
    }


}

//Instances of the parser classes (private: only accessible within this class, final: immutable)
//Method to take string input and returns the object, call the method of each class to convert and return the object
