package patterns.decorator;
/**
 *Смысл деоратора в том чтобы дополинить функциональность главного класса (в данном случае Printer)
 * */
public class Client {
    public static void main(String[] args) {
        //вложенные декораторы
        IPrinter printer = new SmileDecorator(new QuotesDecorator(new Printer()));
        printer.print("hello");
    }
}
