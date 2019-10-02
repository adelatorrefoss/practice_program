package test.ohce;

import ohce.Clock;
import ohce.Console;
import ohce.Ohce;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OhceAcceptanceTest {

    @Test
    public void inTheMorning() {

        Clock clock = mock(Clock.class);
        when(clock.getCurrentHour()).thenReturn(7);

        Console console = mock(Console.class);
        when(console.nextInput()).thenReturn("hola", "oto", "stop", "Stop!");

        Ohce ohce = new Ohce(clock, console);
        ohce.run("Pedro");

        verify(console).write("¡Buenos días Pedro!");
        verify(console).write("aloh");
        verify(console).write("oto");
        verify(console).write("¡Bonita palabra!");
        verify(console).write("pots");
        verify(console).write("Adios Pedro");
    }
}
