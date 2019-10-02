package test.ohce;

import ohce.Clock;
import ohce.Console;
import ohce.Ohce;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OhceTest {

    @Test
    public void greeting_in_the_morning() {
        Clock clock = mock(Clock.class);
        when(clock.getCurrentHour()).thenReturn(7);
        Console console = mock(Console.class);
        when(console.nextInput()).thenReturn("Stop!");
        Ohce ohce = new Ohce(clock, console);

        ohce.run("Pedro");

        verify(console).write("¡Buenas días Pedro!");
        verify(console).write("Adios Pedro");
    }

    @Test
    public void reverse_message() {
        Clock clock = mock(Clock.class);
        Console console = mock(Console.class);
        when(console.nextInput()).thenReturn("hola", "Stop!");
        Ohce ohce = new Ohce(clock, console);

        ohce.run("Pedro");

        verify(console).write("aloh");
    }
}
