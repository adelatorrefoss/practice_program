package mars_rover;

import org.junit.Test;

import static mars_rover.MarsRoverBuilder.aMarsRoverAnyWhere;
import static mars_rover.MarsRoverBuilder.anyMarsRover;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MarsRoverTest {

    @Test
    public void does_nothing_when_receiving_empty_commands_sequence() {
        MarsRover marsRover = anyMarsRover().build();

        marsRover.receive("");

        assertThat(marsRover, is(anyMarsRover().build()));
    }

    @Test
    public void turns_right_when_pointing_north() {
        MarsRover marsRover = aMarsRoverAnyWhere().facing("N").build();

        marsRover.receive("r");

        assertThat(marsRover, is(aMarsRoverAnyWhere().facing("E").build()));
    }

    @Test
    public void turns_right_when_pointing_east() {
        MarsRover marsRover = aMarsRoverAnyWhere().facing("E").build();

        marsRover.receive("r");

        assertThat(marsRover, is(aMarsRoverAnyWhere().facing("S").build()));
    }

    @Test
    public void turns_right_when_pointing_south() {
        MarsRover marsRover = aMarsRoverAnyWhere().facing("S").build();

        marsRover.receive("r");

        assertThat(marsRover, is(aMarsRoverAnyWhere().facing("W").build()));
    }

    @Test
    public void turns_right_when_pointing_west() {
        MarsRover marsRover = aMarsRoverAnyWhere().facing("W").build();

        marsRover.receive("r");

        String direction = "N";
        assertThat(marsRover, is(aMarsRoverAnyWhere().facing(direction).build()));
    }

    @Test
    public void turns_left_when_pointing_north() {
        String direction = "N";
        MarsRover marsRover = aMarsRoverAnyWhere().facing(direction).build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverAnyWhere().facing("W").build()));
    }

    @Test
    public void turns_left_when_pointing_west() {
        MarsRover marsRover = aMarsRoverAnyWhere().facing("W").build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverAnyWhere().facing("S").build()));
    }

    @Test
    public void turns_left_when_pointing_south() {
        MarsRover marsRover = aMarsRoverAnyWhere().facing("S").build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverAnyWhere().facing("E").build()));
    }

    @Test
    public void turns_left_when_pointing_east() {
        MarsRover marsRover = aMarsRoverAnyWhere().facing("E").build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverAnyWhere().facing("N").build()));
    }

    @Test
    public void moves_forward_when_pointing_north() {
        MarsRover marsRover = aMarsRoverAnyWhere().startingAt(5, 4).facing("N").build();

        marsRover.receive("f");

        assertThat(marsRover, is(aMarsRoverAnyWhere().startingAt(5, 5).facing("N").build()));
    }

    @Test
    public void moves_forward_when_pointing_east() {
        MarsRover marsRover = aMarsRoverAnyWhere().startingAt(5, 4).facing("E").build();

        marsRover.receive("f");

        assertThat(marsRover, is(aMarsRoverAnyWhere().startingAt(6, 4).facing("E").build()));
    }

    @Test
    public void moves_forward_when_pointing_south() {
        MarsRover marsRover = aMarsRoverAnyWhere().startingAt(5, 4).facing("S").build();

        marsRover.receive("f");

        assertThat(marsRover, is(aMarsRoverAnyWhere().startingAt(5, 3).facing("S").build()));
    }

    @Test
    public void moves_forward_when_pointing_west() {
        MarsRover marsRover = aMarsRoverAnyWhere().startingAt(5, 4).facing("W").build();

        marsRover.receive("f");

        assertThat(marsRover, is(aMarsRoverAnyWhere().startingAt(4, 4).facing("W").build()));
    }

    @Test
    public void moves_backward_when_pointing_north() {
        MarsRover marsRover = aMarsRoverAnyWhere().startingAt(5, 4).facing("N").build();

        marsRover.receive("b");

        assertThat(marsRover, is(aMarsRoverAnyWhere().startingAt(5, 3).facing("N").build()));
    }

    @Test
    public void moves_backward_when_pointing_east() {
        MarsRover marsRover = aMarsRoverAnyWhere().startingAt(5, 4).facing("E").build();

        marsRover.receive("b");

        assertThat(marsRover, is(aMarsRoverAnyWhere().startingAt(4, 4).facing("E").build()));
    }

    @Test
    public void moves_backward_when_pointing_south() {
        MarsRover marsRover = aMarsRoverAnyWhere().startingAt(5, 4).facing("S").build();

        marsRover.receive("b");

        assertThat(marsRover, is(aMarsRoverAnyWhere().startingAt(5, 5).facing("S").build()));
    }

    @Test
    public void moves_backward_when_pointing_west() {
        MarsRover marsRover = aMarsRoverAnyWhere().startingAt(5, 4).facing("W").build();

        marsRover.receive("b");

        assertThat(marsRover, is(aMarsRoverAnyWhere().startingAt(6, 4).facing("W").build()));
    }

    @Test
    public void receives_multiple_commands() {
        MarsRover marsRover = aMarsRoverAnyWhere().startingAt(7, 4).facing("E").build();

        marsRover.receive("fr");

        assertThat(marsRover, is(aMarsRoverAnyWhere().startingAt(8, 4).facing("S").build()));
    }

    @Test
    public void ignores_unknown_commands() {
        MarsRover marsRover = aMarsRoverAnyWhere().startingAt(7, 4).facing("E").build();

        marsRover.receive("*");

        assertThat(marsRover, is(aMarsRoverAnyWhere().startingAt(7, 4).facing("E").build()));
    }
}
