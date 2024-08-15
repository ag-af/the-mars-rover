import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.marsrover.Instruction;
import org.parser.InstructionParser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class InstructionParserTest {
    private final InstructionParser parser = new InstructionParser();

    @Test
    @DisplayName("Testing valid instructions")
    public void testValidInstructions() {
        List<Instruction> result1 = parser.instructionParse("LMLMLMLMM");
        assertEquals(List.of(
                Instruction.L, Instruction.M, Instruction.L, Instruction.M,
                Instruction.L, Instruction.M, Instruction.L, Instruction.M,
                Instruction.M), result1);

        List<Instruction> result2 = parser.instructionParse("LMRL");
        assertEquals(List.of(
                Instruction.L, Instruction.M, Instruction.R, Instruction.L), result2);

    }

    @Test
    @DisplayName("Testing invalid instructions")
    public void testInvalidInstructions() {
    Exception exception = assertThrows(IllegalArgumentException.class,
            () -> { parser.instructionParse("LAMLA");
    });
    assertTrue(exception.getMessage().contains("Error: invalid instructions"));
    }

    @Test
    @DisplayName("Testing empty instructions")
    public void testEmptyInstructions() {
        List<Instruction> result = parser.instructionParse("");
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Testing instructions with space")
    public void testInstructionsWithSpace() {
        List<Instruction> result = parser.instructionParse("L M L M");
        assertEquals(List.of(Instruction.L, Instruction.M, Instruction.L, Instruction.M), result);
    }
}