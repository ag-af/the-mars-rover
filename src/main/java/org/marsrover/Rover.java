package org.marsrover;

//Class for rover's position and current direction the rover is facing
public class Rover {
    public CompassDirection facingDirection;
    private Position position;

    //Initialise rover with initial direction
    public Rover(int initialX, int initialY, CompassDirection initialDirection) {
        if (initialDirection == null) {
            throw new IllegalArgumentException("Error: invalid initial direction");
        }
        this.facingDirection = initialDirection;
        this.position = new Position(initialX, initialY, initialDirection);
    }


    //Getter to access facing direction
    public CompassDirection getFacingDirection() {
        return facingDirection;
    }

    public Position getPosition() {
        return position;
    }

//    public void setPosition(Position position){
//        this.position = position;
//    }

    //Rotate the rover based on instruction
    public void rotate(Instruction instruction) {
//Check for null
        if (instruction == null) {
            throw new IllegalArgumentException("Error: instructions cannot be empty");
        }


//L calls rotateLeft, R calls rotateRight, default throws exception if instruction is not valid (Moving forward does not change direction)
        switch (instruction) {
            case L:
                rotateLeft();
                break;
            case R:
                rotateRight();
                break;
            case M:
                break;
            default:
                throw new IllegalArgumentException("Error: invalid instructions");
        }
    }


    private void rotateLeft() {
//Change direction based on current facingDirection, e.g if facingDirection is N direction is set to E then exits switch with break
//        CompassDirection newDirection = switch (position.getDirection()) {
        switch (facingDirection) {
            case N:
                facingDirection = CompassDirection.W;
                break;
            case W:
                facingDirection = CompassDirection.S;
                break;
            case S:
                facingDirection = CompassDirection.E;
                break;
            case E:
                facingDirection = CompassDirection.N;
                break;
        }
        position.setDirection(facingDirection);
    }
//        position = new Position(position.getX(), position.getY(), newDirection);
//        }

    private void rotateRight() {
//        CompassDirection newDirection = switch (position.getDirection()) {
        switch (facingDirection) {
            case N:
                facingDirection = CompassDirection.E;
                break;
            case E:
                facingDirection = CompassDirection.S;
                break;
            case S:
                facingDirection = CompassDirection.W;
                break;
            case W:
                facingDirection = CompassDirection.N;
                break;
        }
        position.setDirection(facingDirection);
    }

    public void moveForward() {
        position.moveForward();
    }
}
//        position = new Position(position.getX(), position.getY(), newDirection);
//        }
//    public void move(Instruction instruction){
//        if (instruction == null) {
//            throw new IllegalArgumentException("Error: instruction cannot be empty");
//        }
//        if (instruction == Instruction.M){
//            moveForward();
//        }
//        }
//
//        public void moveForward(){
////        int newX = position.getX();
////        int newY = position.getY();
//        switch (position.getDirection()){
//            case N: position.setY(position.getY() +1);
//            case E: position.setX(position.getX() +1);
//            case S: position.setY(position.getY() -1);
//            case W: position.setX(position.getX() -1);
//        }
//        }
//

