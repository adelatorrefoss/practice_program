package test.ohce;

import ohce.Clock;
import ohce.Console;
import ohce.Ohce;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OhceTest {

    @Test
    public void greetingInTheMorning() {

        Clock clock = mock(Clock.class);
        when(clock.getCurrentHour()).thenReturn(7);
        Console console = mock(Console.class);
        Ohce ohce = new Ohce(clock, console);

        ohce.run("Pedro");

        verify(console).write("¡Buenas días Pedro!");

        //TODO: Stop!
    }

    @Test
    public void reverseMessage() {

        Clock clock = mock(Clock.class);
        Console console = mock(Console.class);
        when(console.nextInput()).thenReturn("hola");
        Ohce ohce = new Ohce(clock, console);

        ohce.run("Pedro");

        verify(console).write("olah");
    }
}
