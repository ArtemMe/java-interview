package patterns.proxy;

public class PngImage implements Image{

    public PngImage(String fileName) {
        load(fileName);
    }

    public void load(String fileName) {
        System.out.println("loading image"+fileName+" ...");
    }

    @Override
    public void display() {
        System.out.println("Showing image");
    }
}
