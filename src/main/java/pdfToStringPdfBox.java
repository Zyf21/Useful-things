import java.io.File;
import java.io.IOException;

import io.github.jonathanlink.PDFLayoutTextStripper;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
public class pdfToStringPdfBox {

    public static void main(String args[]) throws IOException {

        //Loading an existing document
//        File file = new File("pdfFiles/test2.pdf");
//        PDDocument document = PDDocument.load(file);
//
//        //Instantiate PDFTextStripper class
//        PDFTextStripper pdfStripper = new PDFTextStripper();
//
//        //Retrieving text from PDF document
//        String text = pdfStripper.getText(document);
//        System.out.println(text);
//
//        //Closing the document
//        document.close();


//
//        PDDocument doc = PDDocument.load(new File("pdfFiles/test1.pdf"));
//        PDFTextStripper pdfStripper = new PDFTextStripper();
//       // pdfStripper.setSortByPosition(true);
//        String text = pdfStripper.getText(doc);
//        System.out.println(text);
//        doc.close();


             String string = null;

            PDFParser pdfParser = new PDFParser(new RandomAccessFile(new File("pdfFiles/12.pdf"), "r"));
            pdfParser.parse();
            PDDocument pdDocument = new PDDocument(pdfParser.getDocument());
            PDFTextStripper pdfTextStripper = new PDFLayoutTextStripper();
            string = pdfTextStripper.getText(pdDocument);

            System.out.println(pdfTextStripper.getText(pdDocument));








    }
}