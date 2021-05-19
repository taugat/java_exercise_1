import java.util.Scanner;

public class Fibo implements Command{
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println(fibo(scanner.nextInt()));
        scanner.nextLine();
        return false;
    }

    public static int fibo(int value) {
        return (value == 0 || value == 1 )? value : (fibo(value - 1) + fibo(value - 2));
    }
}
