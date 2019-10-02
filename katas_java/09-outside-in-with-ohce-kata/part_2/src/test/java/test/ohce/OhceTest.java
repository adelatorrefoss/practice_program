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
        Ohce ohce = new Ohce(clock, console);

        ohce.run("Pedro");

        verify(console).write("¡Buenos días Pedro!");
    }

    @Test
    public void reverse_message() {
        Clock clock = mock(Clock.class);
        Console console = mock(Console.class);
        when(console.nextInput()).thenReturn("hola");
        Ohce ohce = new Ohce(clock, console);

        ohce.run("Manolo");

        verify(console).write("¡Buenos días Manolo!");
        verify(console).write("aloh");
    }

    @Test
    public void beautiful_word_message() {
        Clock clock = mock(Clock.class);
        Console console = mock(Console.class);
        when(console.nextInput()).thenReturn("somos");
        Ohce ohce = new Ohce(clock, console);

        ohce.run("Pepito");

        verify(console).write("¡Buenos días Pepito!");
        verify(console).write("somos");
        verify(console).write("¡Bonita palabra!");
    }
}
