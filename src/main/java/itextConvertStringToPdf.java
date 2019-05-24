import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class itextConvertStringToPdf {
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    public static void  main(String[] args) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdfFilesString/pdfFile22.pdf"));
        document.open();
        String para1 = "кавепнргрнпе Point originated from the idea that there exists a class of readers who respond better to online content and prefer to learn new skills at their own pace from the comforts of their drawing rooms.";

       // String para2 = "The journey commenced with a single tutorial on HTML in 2006 and elated by the response it generated, we worked our way to adding fresh tutorials to our repository which now proudly flaunts a wealth of tutorials and allied articles on topics ranging from programming languages to web designing to academics and much more.";
        String para2 = "выавыавыаыва DFSSDFSDFSDFSD";

        Paragraph preface = new Paragraph();
        preface.setAlignment(Element.ALIGN_CENTER);
        preface.add(new Paragraph("Title of the document", catFont));
        document.add(preface);

        Paragraph paragraph1 = new Paragraph(para1);
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        Paragraph paragraph2 = new Paragraph(para2);
        document.add(paragraph1);
        document.add(paragraph2);
        document.close();
        System.out.println( "файл Создан" );


        Document document2 = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("sample1.pdf"));
        document2.open();
        Image img = Image.getInstance("lis.png");
        img.scaleAbsolute(300f, 400f);
        document2.add(new Paragraph("Sample 1: This is simple image demo."));
        document2.add(img);
        document2.close();
        System.out.println("Done");



    }
}
