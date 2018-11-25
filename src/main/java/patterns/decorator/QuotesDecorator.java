package patterns.decorator;

public class QuotesDecorator implements IPrinter {

    IPrinter printer;

    public QuotesDecorator(IPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void print(String line) {
        System.out.print("\"");
        printer.print(line);
        System.out.print("\"");
    }
}
