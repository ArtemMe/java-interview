package patterns.proxy;

public class ProxyPngImage implements Image {
    String fileName;
    PngImage pngImage;

    public ProxyPngImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(pngImage == null)
            pngImage = new PngImage(fileName);
        pngImage.display();
    }
}
