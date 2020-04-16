
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class itextParseRus {



    public static void main(String[] args) throws IOException, DocumentException {

        System.out.println(extractPdfText());
    }

    public static String extractPdfText() throws IOException {
        PdfReader pdfReader = new PdfReader("pdfFiles/12.pdf");
        int pages = pdfReader.getNumberOfPages();
        String pdfText = "";
        for (int ctr = 1; ctr < pages + 1; ctr++) {
            pdfText += PdfTextExtractor.getTextFromPage(pdfReader, ctr);
        }
        pdfReader.close();
        return pdfText;
    }
}
