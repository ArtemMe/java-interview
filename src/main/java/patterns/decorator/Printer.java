package patterns.decorator;

public class Printer implements IPrinter {
    @Override
    public void print(String line) {
        System.out.print(line);
    }
}
