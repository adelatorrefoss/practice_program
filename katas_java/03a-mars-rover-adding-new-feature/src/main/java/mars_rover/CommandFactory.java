package mars_rover;

public interface CommandFactory {
    RoverCommand getRoverCommand(String command, int movementDelta);
}
