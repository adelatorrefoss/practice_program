package mars_rover;

public class TurnLeft implements RoverCommand {
    @Override
    public RoverVector execute(RoverVector vector) {
        return vector.turnLeft();
    }
}
