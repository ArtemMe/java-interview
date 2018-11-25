package patterns.adapter;
/**
 * Суть в том чтобы адаптировать класс XmlReader к интерфейсу JsonReader.
 * */
public class Client {
    public static void main(String[] args) {
        JsonReader jsonReader = new AdapterToJson();
        String s = jsonReader.readJson();
        System.out.println(s);
    }
}
