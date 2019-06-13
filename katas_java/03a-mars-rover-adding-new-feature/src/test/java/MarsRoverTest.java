import mars_rover.NasaCommandFactory;
import mars_rover.MarsRover;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MarsRoverTest {
    private NasaCommandFactory getNasaCommandFactory() {
        return new NasaCommandFactory();
    }

    @Test
    public void does_nothing_when_receiving_empty_commands_sequence() {
        MarsRover marsRover = new MarsRover(0, 0, "N", getNasaCommandFactory());

        marsRover.receive("");

        assertThat(marsRover, is(new MarsRover(0, 0, "N", getNasaCommandFactory())));
    }


    @Test
    public void turns_right_when_pointing_north() {
        MarsRover marsRover = new MarsRover(0, 0, "N", getNasaCommandFactory());

        marsRover.receive("r");

        assertThat(marsRover, is(new MarsRover(0, 0, "E", getNasaCommandFactory())));
    }

    @Test
    public void turns_right_when_pointing_east() {
        MarsRover marsRover = new MarsRover(0, 0, "E", getNasaCommandFactory());

        marsRover.receive("r");

        assertThat(marsRover, is(new MarsRover(0, 0, "S", getNasaCommandFactory())));
    }

    @Test
    public void turns_right_when_pointing_south() {
        MarsRover marsRover = new MarsRover(0, 0, "S", getNasaCommandFactory());

        marsRover.receive("r");

        assertThat(marsRover, is(new MarsRover(0, 0, "W", getNasaCommandFactory())));
    }

    @Test
    public void turns_right_when_pointing_west() {
        MarsRover marsRover = new MarsRover(0, 0, "W", getNasaCommandFactory());

        marsRover.receive("r");

        assertThat(marsRover, is(new MarsRover(0, 0, "N", getNasaCommandFactory())));
    }

    @Test
    public void turns_left_when_pointing_north() {
        MarsRover marsRover = new MarsRover(0, 0, "N", getNasaCommandFactory());

        marsRover.receive("l");

        assertThat(marsRover, is(new MarsRover(0, 0, "W", getNasaCommandFactory())));
    }

    @Test
    public void turns_left_when_pointing_west() {
        MarsRover marsRover = new MarsRover(0, 0, "W", getNasaCommandFactory());

        marsRover.receive("l");

        assertThat(marsRover, is(new MarsRover(0, 0, "S", getNasaCommandFactory())));
    }

    @Test
    public void turns_left_when_pointing_south() {
        MarsRover marsRover = new MarsRover(0, 0, "S", getNasaCommandFactory());

        marsRover.receive("l");

        assertThat(marsRover, is(new MarsRover(0, 0, "E", getNasaCommandFactory())));
    }

    @Test
    public void turns_left_when_pointing_east() {
        MarsRover marsRover = new MarsRover(0, 0, "E", getNasaCommandFactory());

        marsRover.receive("l");

        assertThat(marsRover, is(new MarsRover(0, 0, "N", getNasaCommandFactory())));
    }

    @Test
    public void moves_forward_when_pointing_north() {
        MarsRover marsRover = new MarsRover(5, 4, "N", getNasaCommandFactory());

        marsRover.receive("f");

        assertThat(marsRover, is(new MarsRover(5, 5, "N", getNasaCommandFactory())));
    }

    @Test
    public void moves_forward_when_pointing_east() {
        MarsRover marsRover = new MarsRover(5, 4, "E", getNasaCommandFactory());

        marsRover.receive("f");

        assertThat(marsRover, is(new MarsRover(6, 4, "E", getNasaCommandFactory())));
    }

    @Test
    public void moves_forward_when_pointing_south() {
        MarsRover marsRover = new MarsRover(5, 4, "S", getNasaCommandFactory());

        marsRover.receive("f");

        assertThat(marsRover, is(new MarsRover(5, 3, "S", getNasaCommandFactory())));
    }

    @Test
    public void moves_forward_when_pointing_west() {
        MarsRover marsRover = new MarsRover(5, 4, "W", getNasaCommandFactory());

        marsRover.receive("f");

        assertThat(marsRover, is(new MarsRover(4, 4, "W", getNasaCommandFactory())));
    }

    @Test
    public void moves_backward_when_pointing_north() {
        MarsRover marsRover = new MarsRover(5, 4, "N", getNasaCommandFactory());

        marsRover.receive("b");

        assertThat(marsRover, is(new MarsRover(5, 3, "N", getNasaCommandFactory())));
    }

    @Test
    public void moves_backward_when_pointing_east() {
        MarsRover marsRover = new MarsRover(5, 4, "E", getNasaCommandFactory());

        marsRover.receive("b");

        assertThat(marsRover, is(new MarsRover(4, 4, "E", getNasaCommandFactory())));
    }

    @Test
    public void moves_backward_when_pointing_south() {
        MarsRover marsRover = new MarsRover(5, 4, "S", getNasaCommandFactory());

        marsRover.receive("b");

        assertThat(marsRover, is(new MarsRover(5, 5, "S", getNasaCommandFactory())));
    }

    @Test
    public void moves_backward_when_pointing_west() {
        MarsRover marsRover = new MarsRover(5, 4, "W", getNasaCommandFactory());

        marsRover.receive("b");

        assertThat(marsRover, is(new MarsRover(6, 4, "W", getNasaCommandFactory())));
    }

    @Test
    public void receives_multiple_commands() {
        MarsRover marsRover = new MarsRover(7, 4, "E", getNasaCommandFactory());

        marsRover.receive("fr");

        assertThat(marsRover, is(new MarsRover(8, 4, "S", getNasaCommandFactory())));
    }

    @Test
    public void ignores_unknown_commands() {
        MarsRover marsRover = new MarsRover(7, 4, "E", getNasaCommandFactory());

        marsRover.receive("*");

        assertThat(marsRover, is(new MarsRover(7, 4, "E", getNasaCommandFactory())));
    }
}
