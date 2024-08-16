import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.marsrover.*;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {
    private Plateau plateau;
    private Rover rover;

    @Test
    @DisplayName("Testing add rover successfully")
    public void testAddRover() {
        PlateauSize size = new PlateauSize(5, 5);
        plateau = new Plateau(size);
        Rover rover = new Rover(1, 1, CompassDirection.N);
        plateau.addRover(rover);
        assertTrue(plateau.getRovers().contains(rover));
    }

    @Test
    @DisplayName("Testing add rover to occupied position")
    public void testAddRoverOccupiedPosition() {
        PlateauSize size = new PlateauSize(5, 5);
        plateau = new Plateau(size);
        Rover rover1 = new Rover(1, 1, CompassDirection.N);
        Rover rover2 = new Rover(1,1,CompassDirection.E);
        plateau.addRover(rover1);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> { plateau.addRover(rover2);
        });
        assertTrue(exception.getMessage().contains("Position is occupied"));
    }

    @Test
    @DisplayName("Testing add rover to out of bounds position")
    public void testAddRoverOutOfBoundsPosition() {
        PlateauSize size = new PlateauSize(5, 5);
        plateau = new Plateau(size);
        Rover rover = new Rover(6, 6, CompassDirection.S);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> { plateau.addRover(rover);
                });
        assertTrue(exception.getMessage().contains("Position is out of bounds"));
    }

    @Test
    @DisplayName("Testing if a position is occupied")
    public void testIsPositionOccupied() {
        PlateauSize size = new PlateauSize(5, 5);
        plateau = new Plateau(size);
        Rover rover = new Rover(2, 2, CompassDirection.S);
        plateau.addRover(rover);
        assertTrue(plateau.isPositionOccupied(2,2));
        assertFalse(plateau.isPositionOccupied(1,1));
    }

    @Test
    @DisplayName("Testing if a position is occupied")
    public void testGetPlateauSize() {
        PlateauSize size = new PlateauSize(5, 5);
        plateau = new Plateau(size);
        PlateauSize getSize = plateau.getSize();

        assertEquals(5, size.getHeight());
        assertEquals(5, size.getWidth());
    }

}