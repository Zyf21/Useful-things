import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

import java.io.IOException;

public class itextConvertFromPdf {

    public static final String SRC = "pdfFiles/test2.pdf";

    class FontRenderFilter extends RenderFilter {
        public boolean allowText(TextRenderInfo renderInfo) {
            String font = renderInfo.getFont().getPostscriptFontName();
            return font.endsWith("Bold") || font.endsWith("Oblique");
        }
    }

    public static void main(String[] args) throws IOException, DocumentException {
        new itextConvertFromPdf().parse(SRC);
    }

    public void parse(String filename) throws IOException {
        PdfReader reader = new PdfReader(filename);
        Rectangle rect = new Rectangle(0, 0, 50, 260);
        RenderFilter regionFilter = new RegionTextRenderFilter(rect);
        FontRenderFilter fontFilter = new FontRenderFilter();
        TextExtractionStrategy strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), regionFilter);
      System.out.println(PdfTextExtractor.getTextFromPage(reader, 1, strategy));
    //    System.out.println(PdfTextExtractor.getTextFromPage(reader, 1));
        reader.close();
    }
}
