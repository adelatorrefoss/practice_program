package mars_rover;

public class MoveBackward implements RoverCommand {

    private int movement;

    MoveBackward(int movement) {
        this.movement = movement;
    }

    @Override
    public RoverVector execute(RoverVector vector) {
        return vector.moveBackwards(movement);
    }
}
