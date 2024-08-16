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
        Rover rover = new Rover(0,0, CompassDirection.N);
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
        Rover rover = new Rover(0,0,CompassDirection.N);
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
        Rover rover = new Rover(0,0, CompassDirection.N);
       Exception exception = assertThrows(IllegalArgumentException.class,
               () -> { rover.rotate(null);
       });
       assertTrue(exception.getMessage().contains("Error: instructions cannot be empty"));
    }


//    Fix this!
//    @Test
//    @DisplayName("Testing invalid instruction")
//    public void testInvalidInstruction() {
//        Rover rover = new Rover(0,0, CompassDirection.N);
//        Exception exception = assertThrows(IllegalArgumentException.class,
//                () -> { rover.rotate(Instruction.valueOf("A"));
//                });
//        assertTrue(exception.getMessage().contains("Error: invalid instruction"));
//    }


    @Test
    @DisplayName("Testing initial position")
    public void testInitialPosition() {
        rover = new Rover(0, 0, CompassDirection.N);
        Position pos1 = rover.getPosition();
        assertEquals(0, pos1.getX());
        assertEquals(0, pos1.getY());
        assertEquals(CompassDirection.N, pos1.getDirection());
    }

    @Test
    @DisplayName("Testing rotate left from North")
    public void testRotateLeftFromNorth() {
        rover = new Rover(0, 0, CompassDirection.N);
        rover.rotate(Instruction.L);
        assertEquals(CompassDirection.W, rover.getFacingDirection());
    }

    @Test
    @DisplayName("Testing rotate right from North")
    public void testRotateRightFromNorth() {
        rover = new Rover(0, 0, CompassDirection.N);
        rover.rotate(Instruction.R);
        assertEquals(CompassDirection.E, rover.getFacingDirection());
    }

    @Test
    @DisplayName("Testing move forward from North")
    public void testMoveForwardFromNoth() {
        rover = new Rover(0, 0, CompassDirection.N);
        rover.rotate(Instruction.M);
        Position pos1 = rover.getPosition();
        assertEquals(0, pos1.getX(), pos1.getY());
    }

    @Test
    @DisplayName("Testing move forward from East")
    public void testMoveForwardFromEast() {
        rover = new Rover(0, 0, CompassDirection.E);
        rover.rotate(Instruction.M);
        Position pos1 = rover.getPosition();
        assertEquals(0, pos1.getX(), pos1.getY());
    }

    @Test
    @DisplayName("Testing null direction")
    public void testNullDirection() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> { new Rover(0,0, null);
        });
        assertTrue(exception.getMessage().contains("Error: invalid initial direction"));
    }

}