package mars_rover;

public class MoveForward implements RoverCommand {

    private int movement;

    MoveForward(int movement) {
        this.movement = movement;
    }

    @Override
    public RoverVector execute(RoverVector vector) {
        return vector.moveForward(movement);
    }
}
