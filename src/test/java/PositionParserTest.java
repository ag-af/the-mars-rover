import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.marsrover.CompassDirection;
import org.marsrover.Position;
import org.parser.PositionParser;

import static org.junit.jupiter.api.Assertions.*;


class PositionParserTest {
    private final PositionParser parser = new PositionParser();

    @Test
    @DisplayName("Testing valid position")
    public void testValidPosition() {
        Position result1 = parser.positionParse("1 2 N");
        assertEquals(1, result1.getX());
        assertEquals(2, result1.getY());
        assertEquals(CompassDirection.N, result1.getFacing());

        Position result2 = parser.positionParse("1 2 E");
        assertEquals(1, result2.getX());
        assertEquals(2, result2.getY());
        assertEquals(CompassDirection.E, result2.getFacing());

        Position result3 = parser.positionParse("1 2 S");
        assertEquals(1, result3.getX());
        assertEquals(2, result3.getY());
        assertEquals(CompassDirection.S, result3.getFacing());

        Position result4 = parser.positionParse("1 2 W");
        assertEquals(1, result4.getX());
        assertEquals(2, result4.getY());
        assertEquals(CompassDirection.W, result4.getFacing());

    }

    @Test
    @DisplayName("Testing invalid position")
    public void testInvalidPosition() {
        //Fix this!
//        Exception exception1 = assertThrows(IllegalArgumentException.class,
//                () -> { parser.positionParse("1 2 A");
//        });
//        assertTrue(exception1.getMessage().contains("Error: direction must be valid"));

        Exception exception2 = assertThrows(IllegalArgumentException.class,
                () -> { parser.positionParse("");
                });
        assertTrue(exception2.getMessage().contains("Error: input cannot be empty"));

        Exception exception3 = assertThrows(IllegalArgumentException.class,
                () -> { parser.positionParse("1 2");
                });
        assertTrue(exception3.getMessage().contains("Error: input must contain three values"));

        Exception exception4 = assertThrows(IllegalArgumentException.class,
                () -> { parser.positionParse("one two N");
                });
        assertTrue(exception4.getMessage().contains("Error: coordinate must be valid"));
    }
}