package patterns.decorator;

public class SmileDecorator implements IPrinter {

    IPrinter printer;

    public SmileDecorator(IPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void print(String line) {
        printer.print(line);
        System.out.print(" :)");
    }
}
