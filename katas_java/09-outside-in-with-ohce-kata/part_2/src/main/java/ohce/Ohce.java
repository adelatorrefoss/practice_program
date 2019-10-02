package ohce;

public class Ohce {

    private Clock clock;
    private Console console;

    public Ohce(Clock clock, Console console) {
        this.clock = clock;
        this.console = console;
    }

    public void run(String name) {
        console.write("¡Buenas días " + name + "!");
        String input = console.nextInput();
        if (input != null) {
            console.write(new StringBuilder(input).reverse().toString());
        }
    }
}
