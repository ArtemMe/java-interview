package patterns.adapter;

public class AdapterToJson implements JsonReader {
    private XmlReader xmlReader = new XmlReader();

    @Override
    public String readJson() {
       return parseXMLtoJSON(xmlReader.readXML());
    }

    private String parseXMLtoJSON(XmlReader.XML xml){
        System.out.println("parse xml.....");
        return "data";
    }
}
