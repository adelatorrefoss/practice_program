package mars_rover;

import java.util.Objects;

public class RoverVector {
    private Coordinates coordinates;
    private Direction direction;

    public RoverVector(Coordinates coordinates, Direction direction) {

        this.coordinates = coordinates;
        this.direction = direction;
    }

    public RoverVector turnRight() {
        return new RoverVector(coordinates, direction.turnRight());
    }

    public RoverVector turnLeft() {
        return new RoverVector(coordinates, direction.turnLeft());
    }


    public RoverVector moveForward(int movement) {
        return new RoverVector(direction.moveForward(coordinates, movement), direction);
    }

    public RoverVector moveBackwards(int movement) {
        return new RoverVector(direction.moveBackwards(coordinates, movement), direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoverVector that = (RoverVector) o;
        return coordinates.equals(that.coordinates) &&
                direction == that.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, direction);
    }


    @Override
    public String toString() {
        return "RoverVector{" +
                "coordinates=" + coordinates +
                ", direction=" + direction +
                '}';
    }
}
