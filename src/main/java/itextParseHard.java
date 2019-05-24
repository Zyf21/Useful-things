import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.*;
import ucar.ma2.Array;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


public class itextParseHard {



    public static void main(String[] args) throws IOException, DocumentException {

       // new itextParseHard().extractText("pdfFiles/test3.pdf","pdfFiles/test33.txt");

        new itextParseHard().parsePdf("pdfFiles/test3.pdf","pdfFiles/test33.txt");



    }

    public void extractText(String src, String dest) throws IOException {
        PrintWriter out = new PrintWriter(new FileOutputStream(dest));
        PdfReader reader = new PdfReader(src);
        RenderListener listener = new MyTextRenderListener(out);

        PdfContentStreamProcessor processor = new PdfContentStreamProcessor(listener);
        PdfDictionary pageDic = reader.getPageN(1);
        PdfDictionary resourcesDic = pageDic.getAsDict(PdfName.RESOURCES);
        processor.processContent(ContentByteUtils.getContentBytesForPage(reader, 1), resourcesDic);

        out.flush();
        out.close();}


    public class MyTextRenderListener implements RenderListener {
        protected PrintWriter out;

        public MyTextRenderListener(PrintWriter out) {
            this.out = out;
        }

        public void beginTextBlock() {

            out.print("1");
        }
            public void endTextBlock() {
                out.println(">");
            }
            public void renderImage(ImageRenderInfo renderInfo) {
            }
            public void renderText(TextRenderInfo renderInfo) {
                out.print("2");
                out.print(renderInfo.getText());
                out.print(">");
            }

        }


    public void parsePdf(String src, String dest) throws IOException {
        PdfReader reader = new PdfReader(src);
        PrintWriter out = new PrintWriter(new FileOutputStream(dest));
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            out.println(PdfTextExtractor.getTextFromPage(reader, i));
        }
        out.flush();
        out.close();
    }


}