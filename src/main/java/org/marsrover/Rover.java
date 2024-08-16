package org.marsrover;
import org.marsrover.Instruction;

public class Rover{
    public CompassDirection facingDirection;

    public Rover(CompassDirection initialDirection) {
        this.facingDirection = initialDirection;
    }

    public CompassDirection getFacingDirection() {
        return facingDirection;
    }

    public void rotate(Instruction instruction) {
        if (instruction == null) {
            throw new IllegalArgumentException("Error: instructions cannot be empty");
        }
        switch (instruction) {
            case L:
                rotateLeft();
                break;
            case R:
                rotateRight();
                break;
            case M:
                break;
            default: throw new IllegalArgumentException("Error: invalid instructions");
        }
    }


    private void rotateLeft() {
        switch (facingDirection) {
            case N -> {
                facingDirection = CompassDirection.W;
                break;
            }
            case W -> {
                facingDirection = CompassDirection.S;
                break;
            }
            case S -> {
                facingDirection = CompassDirection.E;
                break;
            }
            case E -> {
                facingDirection = CompassDirection.N;
                break;
            }
        }
    }

    private void rotateRight() {
        switch (facingDirection) {
            case N -> {
                facingDirection = CompassDirection.E;
                break;
            }
            case E -> {
                facingDirection = CompassDirection.S;
                break;
            }
            case S -> {
                facingDirection = CompassDirection.W;
                break;
            }
            case W -> {
                facingDirection = CompassDirection.N;
                break;
            }
        }
    }
}
