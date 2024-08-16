package org.marsrover;

import java.util.HashMap;
import java.util.Map;

public enum Instruction {
    L, R, M;

//    private static final Map<Character, Instruction> charMap = new HashMap<>();
//   static {
//       charMap.put('L', L);
//       charMap.put('R', R);
//       charMap.put('M', M);
    }

//    public static Instruction instructionMap(char c){
//       Instruction instruction = charMap.get(c);
//       if (instruction == null) {
//           throw new IllegalArgumentException("Error: instructions cannot be empty");
//       }
//
//       return instruction;
//    }
//}

//Static map to store character to enum (static: shared with all instances of the enum) (final: cannot be changed)
//Key is a character (L,R,M), value is instruction
//Static block mapping characters to Instruction values
//.put to add to the map with key-value pairs (Key is 'L', value is the enum L)
//static char c: takes char as input and return instruction
//charMap.get(c): look for c in the map, get the corresponding enum
//if character is not found(null) throws exception
//if valid return instruction