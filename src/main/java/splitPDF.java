import com.itextpdf.text.DocumentException;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class splitPDF {
    public static void main(String[] args) throws IOException {

        //Loading an existing PDF document
        File file = new File("pdfbox/box.pdf");
        PDDocument document = PDDocument.load(file);

        //Instantiating Splitter class
        Splitter splitter = new Splitter();

        //splitting the pages of a PDF document
        List<PDDocument> Pages = splitter.split(document);

        //Creating an iterator
        Iterator<PDDocument> iterator = Pages.listIterator();

        //Saving each page as an individual document
        int i = 1;
        while(iterator.hasNext()) {
            PDDocument pd = iterator.next();
            pd.save("pdfbox/"+ i++ +".pdf");
        }
        System.out.println("Multiple PDF’s created");
        document.close();
    }
}
