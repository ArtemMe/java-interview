package patterns.proxy;

/**
 * Проблема в том что в классе PngImage есть "тяжелыйы" конструктор,
 * который загружает картинку сразу после создани объекта. Если нам этого не надо можно создать объект прокси
 * и реализовать создание объекта тогда когда нам нужно
 *
 * */

public class Client {
    public static void main(String[] args) {
        //Без прокси
        Image pngImage = new PngImage("file1");
        //pngImage.display();

        //Прокси
        Image proxyPngImage = new ProxyPngImage("file2");
        proxyPngImage.display();
    }
}
