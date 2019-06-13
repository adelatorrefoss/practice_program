package mars_rover;

public class NullCommand implements RoverCommand {
    @Override
    public RoverVector execute(RoverVector vector) {
        return vector;
    }
}
