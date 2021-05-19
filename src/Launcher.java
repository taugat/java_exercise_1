import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Launcher {

    static Collection<Command> commands = Arrays.asList(new Fibo(), new Freq(), new Quit());

    public static void main(String[] args) {
        System.out.println("Welcome");

        try (Scanner scanner = new Scanner(System.in)) {

            while (scanner.hasNext()) {

                final String commandString = scanner.nextLine();

                try {
                    commands.stream()
                            .filter(command -> command.name().equals(commandString))
                            .findAny()
                            .orElseThrow(() -> new Exception("Unknown command"))
                            .run(scanner);
                }
                catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }

        } catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
        }
    }


}
