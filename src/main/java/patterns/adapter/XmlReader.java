package patterns.adapter;

public class XmlReader {
    static class XML{
        //какое-то представление xml
    }

    public XML readXML(){
        return new XML();
    }
}
