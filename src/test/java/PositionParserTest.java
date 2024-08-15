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
        Position result = parser.positionParse("1 2 N");
        assertEquals(1, result.getX());
        assertEquals(2, result.getY());
        assertEquals(CompassDirection.N, result.getFacing());
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