import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.marsrover.CompassDirection;
import org.marsrover.Instruction;
import org.marsrover.Position;
import org.marsrover.Rover;


import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    private Rover rover;

    @Test
    @DisplayName("Testing left rotation")
    public void testRotateLeft() {
        Rover rover = new Rover(CompassDirection.N);
        rover.rotate(Instruction.L);
        assertEquals(CompassDirection.W, rover.getFacingDirection());

        rover.rotate(Instruction.L);
        assertEquals(CompassDirection.S, rover.getFacingDirection());

        rover.rotate(Instruction.L);
        assertEquals(CompassDirection.E, rover.getFacingDirection());

        rover.rotate(Instruction.L);
        assertEquals(CompassDirection.N, rover.getFacingDirection());
    }

    @Test
    @DisplayName("Testing right rotation")
    public void testRotateRight() {
        Rover rover = new Rover(CompassDirection.N);
        rover.rotate(Instruction.R);
        assertEquals(CompassDirection.E, rover.getFacingDirection());

        rover.rotate(Instruction.R);
        assertEquals(CompassDirection.S, rover.getFacingDirection());

        rover.rotate(Instruction.R);
        assertEquals(CompassDirection.W, rover.getFacingDirection());

        rover.rotate(Instruction.R);
        assertEquals(CompassDirection.N, rover.getFacingDirection());
    }

    @Test
    @DisplayName("Testing null instruction")
    public void testNullInstruction() {
        Rover rover = new Rover(CompassDirection.N);
       Exception exception = assertThrows(IllegalArgumentException.class,
               () -> { rover.rotate(null);
       });
       assertTrue(exception.getMessage().contains("Error: instructions cannot be empty"));
    }


//    Fix this!
//    @Test
//    @DisplayName("Testing invalid instruction")
//    public void testInvalidInstruction() {
//        Rover rover = new Rover(CompassDirection.N);
//        Exception exception = assertThrows(IllegalArgumentException.class,
//                () -> { rover.rotate(Instruction.valueOf("A"));
//                });
//        assertTrue(exception.getMessage().contains("Error: invalid instruction"));
//    }

//    @Test
//    @DisplayName("Testing null instruction")
//    public void testMoveFowardNorth() {
//        Rover rover = new Rover(new Position(0, 0, CompassDirection.N));
//        rover.move(Instruction.M);
//        Position expectedPosition = new Position(0, 1, CompassDirection.N);
//        assertEquals(expectedPosition, rover.getPosition());
//    }

//    public void setUp() {
//        rover = new Rover(new Position(0,0, CompassDirection.N));
//    }
//    @Test
//    @DisplayName("Testing")
//    public void testRotateLeftFromNorth() {
//        rover.rotate(Instruction.L);
//        Position expectedPosition = new Position(0, 0, CompassDirection.W);
//        assertEquals(expectedPosition, rover.getPosition());
//    }

}