package mars_rover;

public class TurnRight implements RoverCommand {
    @Override
    public RoverVector execute(RoverVector vector) {
        return vector.turnRight();
    }
}
