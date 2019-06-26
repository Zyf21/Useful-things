import io.github.jonathanlink.PDFLayoutTextStripper;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PDFParser {

    public static String parsePDF (String filePath, int startPage, int endPage) throws IOException {

        String pdfText = null;
        org.apache.pdfbox.pdfparser.PDFParser pdfParser = new org.apache.pdfbox.pdfparser.PDFParser(new RandomAccessFile(new File(filePath), "r"));
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
        return tempDir + "/test.txt";

    }


}
