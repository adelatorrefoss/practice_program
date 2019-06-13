package mars_rover;

import java.util.Objects;

public class MarsRover {

    private static final int MOVEMENT_DELTA = 1;
    private RoverVector vector;
    private CommandFactory commandFactory;

    public MarsRover(int x, int y, String direction, CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
        this.vector = new RoverVector(new Coordinates(x, y), Direction.parse(direction));
    }

    public void receive(String commandsSequence) {
        for (String command : commandsSequence.split("")) {
            RoverCommand roverCommand;
            roverCommand = commandFactory.getRoverCommand(command, MOVEMENT_DELTA);

            vector = roverCommand.execute(vector);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return vector.equals(marsRover.vector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vector);
    }

    @Override
    public String toString() {
        return "MarsRover{" +
                "vector=" + vector +
                '}';
    }
}
