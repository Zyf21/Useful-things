import java.io.File;
import net.sourceforge.tess4j.*;

public class tessParse {

    public static void main(String[] args) {
        File imageFile = new File("pdfFiles/17.pdf");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
        instance.setDatapath("/usr/share/tesseract-ocr/4.00/tessdata"); // path to tessdata directory
        instance.setLanguage("rus");

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}