package ohce;

public class Ohce {

    private Clock clock;
    private Console console;

    public Ohce(Clock clock, Console console) {
        this.clock = clock;
        this.console = console;
    }

    public void run(String name) {
        console.write("¡Buenos días " + name + "!");
        String input = console.nextInput();

        while(!input.equals("Stop!")) {
            String reversedInput = new StringBuilder(input).reverse().toString();
            console.write(reversedInput);

            if (input.equals(reversedInput)) {
                console.write("¡Bonita palabra!");
            }
            input = console.nextInput();
        }

        console.write("Adios " + name);
    }
}
