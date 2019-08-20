import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class createHtml {
    public static void main(String[] args) throws IOException {

        File htmlTemplateFile = new File("template.html");
        String htmlString = "sdfsdfsdf";
        FileUtils.writeStringToFile(htmlTemplateFile, htmlString);

        Path file = Paths.get("pdfBox/fff.html");
        try (PrintWriter out = new PrintWriter(String.valueOf(file))) {
            out.println(htmlString);
        }
        int t =2;
    }

}
