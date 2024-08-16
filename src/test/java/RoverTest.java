import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.marsrover.CompassDirection;
import org.marsrover.Instruction;
import org.marsrover.Rover;


import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    @DisplayName("Testing left rotation from North")
    public void testRotateLeftFromNorth() {
        Rover rover = new Rover(CompassDirection.N);
        rover.rotate(Instruction.L);
        assertEquals(CompassDirection.W, rover.getFacingDirection());

    }

    @Test
    @DisplayName("Testing right rotation from North")
    public void testRotateRightFromNorth() {
        Rover rover = new Rover(CompassDirection.N);
        rover.rotate(Instruction.R);
        assertEquals(CompassDirection.E, rover.getFacingDirection());
    }

    @Test
    @DisplayName("Testing left rotation from East")
    public void testRotateLeftFromEast() {
        Rover rover = new Rover(CompassDirection.E);
        rover.rotate(Instruction.L);
        assertEquals(CompassDirection.N, rover.getFacingDirection());
    }

    @Test
    @DisplayName("Testing right rotation from East")
    public void testRotateRightFromEast() {
        Rover rover = new Rover(CompassDirection.E);
        rover.rotate(Instruction.R);
        assertEquals(CompassDirection.S, rover.getFacingDirection());
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


    //Fix this!
//    @Test
//    @DisplayName("Testing invalid instruction")
//    public void testInvalidInstruction() {
//        Rover rover = new Rover(CompassDirection.N);
//        Exception exception = assertThrows(IllegalArgumentException.class,
//                () -> { rover.rotate(Instruction.valueOf("A"));
//                });
//        assertTrue(exception.getMessage().contains("Error: invalid instruction"));
//    }

}