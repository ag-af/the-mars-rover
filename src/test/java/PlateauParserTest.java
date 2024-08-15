import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.marsrover.PlateauSize;
import org.parser.PlateauParser;

import static org.junit.jupiter.api.Assertions.*;


class PlateauParserTest {
    public PlateauParser parser = new PlateauParser();
    @Test
    @DisplayName("Testing valid plateau size")
    public void testValidPlateauSize(){
        PlateauSize test = parser.plateauParse("5 5");

        assertEquals(5,test.getHeight());
        assertEquals(5, test.getWidth());
    }

    @Test
    @DisplayName("Testing plateau size with extra spaces")
    public void testValidPlateauSizeWithExtraSpaces(){
        PlateauSize test = parser.plateauParse("  5  5  ");
        assertEquals(5, test.getWidth());
        assertEquals(5, test.getHeight());
    }

    @Test
    @DisplayName("Testing invalid input for plateau size ")
    public void testInvalidPlateauSize(){
        Exception exception1 = assertThrows(NumberFormatException.class,
                () -> { parser.plateauParse("5");
        });
        assertTrue(exception1.getMessage().contains("Error: input must contain two values"));

        Exception exception2 = assertThrows(NumberFormatException.class,
                () -> { parser.plateauParse("five 5");
        });
        assertTrue(exception2.getMessage().contains("Error: width and height must be valid"));

        Exception exception3 = assertThrows(NumberFormatException.class,
                () -> { parser.plateauParse("five 5 five, five 5 five");
        });
        assertTrue(exception3.getMessage().contains("Error: input must contain two values"));

        Exception exception4 = assertThrows(NumberFormatException.class,
                () -> { parser.plateauParse("");
        });
        assertTrue(exception4.getMessage().contains("Error: input must contain two values"));

        Exception exception5 = assertThrows(NumberFormatException.class, () -> {
            parser.plateauParse("5 5.5");
        });
        assertTrue(exception5.getMessage().contains("Error: width and height must be valid"));

        Exception exception6 = assertThrows(NumberFormatException.class, () ->{
            parser.plateauParse("-5 -5");
        });
        assertTrue(exception6.getMessage().contains("Error: wrong input format."));
    }
}

//assertThrows: to verify that a specific exception is thrown
//NumberFormatException.class: type of exception expected, parsing a string that is non-numeric
//lambda expression for the code to be tested
//assert to verify the exception
//get.Message(): to get message from the caught exception
//.contains: checks if the exception message includes the error message