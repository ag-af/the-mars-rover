package org.parser;

import org.marsrover.Instruction;

import java.util.ArrayList;
import java.util.List;

public class InstructionParser {
    public List<Instruction> instructionParse(String input){
        List<Instruction> instructions = new ArrayList<>();
        for(char c : input.toCharArray()){
            instructions.add(Instruction.valueOf(String.valueOf(c)));
        }
        return instructions;
    }
}
//Take string and return a list of instruction enums
//Empty list to hold instruction enums
//Iterates over each character array and convert the input to character
//Add instruction enum to instructions list
//Convert the string of each character to enum value
//valueOf to find the enum that matches the string
//Returns the list of enums