import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import io.github.jonathanlink.PDFLayoutTextStripper;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

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

        try (PDDocument document = PDDocument.load(new File("pdfFiles/12.pdf"))) {

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                Rectangle rect = new Rectangle(10, 60, 900, 840);
                stripper.addRegion("class1", rect);
                PDPage firstPage = document.getPage(0);
                stripper.extractRegions( firstPage );
              //  System.out.println("Text in the area:" + rect);
              //  System.out.println(stripper.getTextForRegion( "class1"));

            }
        } catch (IOException e){
            System.err.println("Exception while trying to read pdf document - " + e);
        }





             String string = null;

            PDFParser pdfParser = new PDFParser(new RandomAccessFile(new File("pdfFiles/test5.pdf"), "r"));
            pdfParser.parse();
            PDDocument pdDocument = new PDDocument(pdfParser.getDocument());
            PDFTextStripper pdfTextStripper = new PDFLayoutTextStripper();

            string = pdfTextStripper.getText(pdDocument);
            //  System.out.println(string);

            System.out.println(parsePDF("pdfFiles/test111.pdf",6,7));

    }

            public  static String parsePDF (String filePath, int startPage, int endPage) throws IOException {

                String pdfText = null;
                PDFParser pdfParser = new PDFParser(new RandomAccessFile(new File(filePath), "r"));
                pdfParser.parse();
                PDDocument pdDocument = new PDDocument(pdfParser.getDocument());
                PDFTextStripper pdfTextStripper = new PDFLayoutTextStripper();
                pdfTextStripper.setStartPage(startPage);
                pdfTextStripper.setEndPage(endPage);
                pdfText = pdfTextStripper.getText(pdDocument);
                pdDocument.close();

                Path tempDir = Files.createTempDirectory(Paths.get("tempPDF/"), "pdf");
                PrintWriter out = new PrintWriter(tempDir + "/test.txt");
                out.write(pdfText);
                out.close();
              //  System.out.println(string);
                return tempDir + "/test.txt";

            }








}