import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Freq implements Command{
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Enter a file path");
        freq(scanner.nextLine());
        return false;
    }

    private static void freq(String str) throws InvalidPathException {
        Path path = Paths.get(str);

        try {

            String content = Files.readString(path);

            Arrays.asList(content.split("\n")).forEach(
                    line ->
                            System.out.println(
                                    Arrays.stream(line.split(" ")).collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting())).
                                            entrySet()
                                            .stream()
                                            .sorted((entry1,entry2) -> Long.compare(entry2.getValue(),entry1.getValue()))
                                            .limit(3)
                                            .map(Map.Entry::getKey)
                                            .collect(Collectors.joining())
                            )
            );

        } catch (IOException e) {
            System.err.println("Unreadable file: " + e.getClass() + " " + e.getMessage());
        }
    }
}
