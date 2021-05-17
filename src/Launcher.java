import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Launcher {

    public static void main(String[] args) {
        System.out.println("Welcome");
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                switch (scanner.nextLine()) {
                    case "fibo" -> {
                        System.out.println(fibo(scanner.nextInt()));
                        scanner.nextLine();
                    }
                    case "quit" -> {
                        return;
                    }
                    default -> System.err.println("Unknown command");
                }
            }
        } catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
        }
    }

    public static int fibo(int value) {
        return (value == 0 || value == 1 )? value : (fibo(value - 1) + fibo(value - 2));
    }
}
