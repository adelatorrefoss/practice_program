package mars_rover;

public class MarsRoverBuilder {

    private int xCoordinate;
    private int yCoordinate;
    private String direction;

    private static MarsRoverBuilder aMarsRover() {
        return new MarsRoverBuilder();
    }

    public static MarsRoverBuilder anyMarsRover() {
        return aMarsRover().startingAt(33,45).facing("E");
    }

    public static MarsRoverBuilder aMarsRoverAnyWhere() {
        return aMarsRover().startingAt(0, 0).facing("W");
    }

    public MarsRoverBuilder startingAt(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        return this;
    }

    public MarsRoverBuilder facing(String direction) {
        this.direction = direction;
        return this;
    }

    public MarsRover build() {
        return new MarsRover(xCoordinate, yCoordinate, direction);
    }
}
