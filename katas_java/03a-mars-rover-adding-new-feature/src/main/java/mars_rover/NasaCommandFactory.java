package mars_rover;

public class NasaCommandFactory implements CommandFactory {
    @Override
    public RoverCommand getRoverCommand(String command, int movementDelta) {
        RoverCommand roverCommand;
        if (command.equals("r")) {
            roverCommand = new TurnRight();
        } else if (command.equals("l")) {
            roverCommand = new TurnLeft();
        } else if (command.equals("f")) {
            roverCommand = new MoveForward(movementDelta);
        } else if (command.equals("b")) {
            roverCommand = new MoveBackward(movementDelta);
        } else {
            roverCommand = new NullCommand();
        }
        return roverCommand;
    }
}
