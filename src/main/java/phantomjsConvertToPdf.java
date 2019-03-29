import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;


public class phantomjsConvertToPdf {
    public static void main(String args[]) throws Exception, DocumentException {

        String SCRIPT = "var page = require('webpage').create();\n" +
                "page.open('@@URL@@', function() {\n" +
                //"page.paperSize = { format: 'A4',  orientation: 'portrait', margin: '0cm' };\n"+
                //"page.paperSize = { width: 360, height: 530};\n"+
                "page.paperSize = { width: 790, height: 1125};\n"+
                //"page.dpi=150;\n"+
                 //"page.viewportSize = { width: 360, height: 530 };\n"+
                //"page.zoomFactor = 4 ;\n"+
               // "page.clipRect = { top: 0, left: 0, width: 1024, height: 768 };\n"+
                "page.render('@@FILE@@');\n" +
                "});\n";

        final String script = SCRIPT.replace("@@URL@@", "test3.html").replace("@@FILE@@", "чистый.pdf");
        System.setProperty("phantomjs.binary.path", "C:\\Users\\DMTech\\Downloads\\tt\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        ((PhantomJSDriver) driver).executePhantomJS(script);

        //take image
//        driver.get("test1.html");
//        driver.manage().window().setPosition(new Point(0,0));
//        driver.manage().window().setSize(new Dimension(1400,2500));
//        ((PhantomJSDriver) driver).executeScript("document.body.style.zoom = '5'");
//        WebElement html = driver.findElement(By.tagName("html"));
//        html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("image/screenshot.png"));
        System.out.println("Нормалек");


    }
}



