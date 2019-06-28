import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class apachExcelWrite {

    public static void main(String[] args) throws IOException {

        File file = new File("test.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheetForm = workbook.getSheetAt(0);
        DataFormatter df = new DataFormatter();
     //   Row row= sheetForm.getRow(0);
     //   Cell cell = row.getCell(5);
      //  cell.getStringCellValue();
      //  System.out.println(cell);
      //  cell.setCellValue("asdas");

        //Create row object
        XSSFRow row;

        List<String> roles = new ArrayList();


        Map.Entry<String, List<String>> splitLine = new AbstractMap.SimpleEntry<String, List<String>>("1",roles);
        //This data needs to be written (Object[])


        //generateSpecifacation();

       // generateMaterialList();

        generateObjectList();

    }

    public static void generateSpecifacation() throws IOException {

        File file = new File("specification.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheetForm = workbook.getSheetAt(0);
        XSSFRow row;

        //set customer name
        Row rowCustomer= sheetForm.getRow(0);
        Cell cellCustomer =rowCustomer.getCell(1);
        cellCustomer.setCellValue("Национальный аэропорт Минск");

        //set object name
        Row rowObjekt= sheetForm.getRow(6);
        Cell cellObjekt =rowObjekt.getCell(6);
        cellObjekt.setCellValue("Многонациональный комплекс бизнес-авиации");

        Map< String, Object[] > material = new TreeMap< String, Object[] >();
        material.put( "1", new Object[] { "", "Кабель", "ТМГ","096","МАЗ","378","шт","843","4623,34","367,45","3478,345","9078,45","564","Астор","Коментарий" });
        material.put( "2", new Object[] { "", "Муфта", "ТМГ","2346","МАЗ","378","шт","843","4623,34","367,45","3478,345","9078,45","564","Астор","Коментарий" });
        material.put( "3", new Object[] { "", "Курпич", "ТМГ","387","Электросила","378","шт","843","4623,34","367,45","3478,345","9078,45","564","Астор","Коментарий" });
        material.put( "4", new Object[] { "", "Труба", "ТМГ","476","МАЗ","378","шт","843","56,34","367,45","3478,345","9078,45","564","Астор","Коментарий" });
        material.put( "5", new Object[] { "", "Кабель", "ТМГ","3456","Электросила","378","шт","843","4623,34","367,45","3478,345","9078,45","564","Астор","Коментарий" });
        material.put( "6", new Object[] { "", "Корпус", "ТМГ","78","МАЗ","378","шт","843","462783,34","367,45","3478,345","9078,45","564","Астор","Коментарий" });
        material.put( "7", new Object[] { "", "Щит", "ТМГ","088","МАЗ","378","шт","843","4456623,34","367,45","34788,345","9078,45","564","Астор","Коментарий" });
        material.put( "8", new Object[] { "", "Кабель", "ТМГ","234","Электросила","378","шт","843","976,34","367,45","3475678,345","9078,45","564","Астор","Коментарий" });

        XSSFCellStyle cellStyleMaterial = workbook.createCellStyle();
        cellStyleMaterial.setBorderRight(BorderStyle.THIN);
        cellStyleMaterial.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyleMaterial.setBorderBottom(BorderStyle.THIN);
        cellStyleMaterial.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        Set< String > keyid = material.keySet();
        int rowid = 9;

        for (String key : keyid) {
            row = sheetForm.createRow(rowid++);
            Object [] objectArr = material.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);

                cell.setCellValue((String)obj);
                cell.setCellStyle(cellStyleMaterial);
            }
        }
       // sheetForm.autoSizeColumn(1);

        FileOutputStream out = new FileOutputStream(new File("specification.xlsx"));
        workbook.write(out);
        out.close();

    }

    public static void generateMaterialList() throws IOException {

        File file = new File("materialList.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheetForm = workbook.getSheetAt(0);
        XSSFRow row;

        Map< String, Object[] > material = new TreeMap< String, Object[] >();
        material.put( "1", new Object[] { "", "Кабель", "ТМГ","096","МАЗ","378","шт","843","4623,34","367,45","3478,345","9078,45","564","Астор","Коментарий" });
        material.put( "2", new Object[] { "", "Муфта", "ТМГ","2346","МАЗ","378","шт","843","4623,34","367,45","3478,345","9078,45","564","Астор","Коментарий" });
        material.put( "3", new Object[] { "", "Курпич", "ТМГ","387","Электросила","378","шт","843","4623,34","367,45","3478,345","9078,45","564","Астор","Коментарий" });
        material.put( "4", new Object[] { "", "Труба", "ТМГ","476","МАЗ","378","шт","843","56,34","367,45","3478,345","9078,45","564","Астор","Коментарий" });
        material.put( "5", new Object[] { "", "Кабель", "ТМГ","3456","Электросила","378","шт","843","4623,34","367,45","3478,345","9078,45","564","Астор","Коментарий" });
        material.put( "6", new Object[] { "", "Корпус", "ТМГ","78","МАЗ","378","шт","843","462783,34","367,45","3478,345","9078,45","564","Астор","Коментарий" });
        material.put( "7", new Object[] { "", "Щит", "ТМГ","088","МАЗ","378","шт","843","4456623,34","367,45","34788,345","9078,45","564","Астор","Коментарий" });
        material.put( "8", new Object[] { "", "Кабель", "ТМГ","234","Электросила","378","шт","843","976,34","367,45","3475678,345","9078,45","564","Астор","Коментарий" });

        XSSFCellStyle cellStyleMaterial = workbook.createCellStyle();
        cellStyleMaterial.setBorderRight(BorderStyle.THIN);
        cellStyleMaterial.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyleMaterial.setBorderBottom(BorderStyle.THIN);
        cellStyleMaterial.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        Set< String > keyid = material.keySet();
        int rowid = 4;

        for (String key : keyid) {
            row = sheetForm.createRow(rowid++);
            Object [] objectArr = material.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);

                cell.setCellValue((String)obj);
                cell.setCellStyle(cellStyleMaterial);
            }
        }
        // sheetForm.autoSizeColumn(1);

        FileOutputStream out = new FileOutputStream(new File("materialList.xlsx"));
        workbook.write(out);
        out.close();
        workbook.close();

    }

    public static void generateObjectList() throws IOException {

        File file = new File("object.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheetForm = workbook.getSheetAt(0);
        XSSFRow row;

        Map< String, Object[] > material = new TreeMap< String, Object[] >();
        material.put( "1", new Object[] { "Многонациональный комплекс бизнес-авиации", "Аэропорт", "Национальный аэропорт минск","Производственное","Наружные/Внутренние","Иванов И.И.","200000","34","45674","34","67456","80","564","Коментарий" });
        material.put( "2", new Object[] { "Стройка2", "Аэропорт", "Национальный аэропорт минск","Производственное","Наружные/Внутренние","Иванов И.И.","200000","34","45674","34","67456","80","564","Коментарий" });
        material.put( "3", new Object[] { "Стройка3", "Аэропорт", "Национальный аэропорт минск","Производственное","Наружные/Внутренние","Иванов И.И.","200000","34","45674","34","67456","80","564","Коментарий" });
        material.put( "4", new Object[] { "Стройка4", "Аэропорт", "Национальный аэропорт минск","Производственное","Наружные/Внутренние","Иванов И.И.","200000","34","45674","34","67456","80","564","Коментарий" });
        material.put( "5", new Object[] { "Стройка5", "Аэропорт", "Национальный аэропорт минск","Производственное","Наружные/Внутренние","Иванов И.И.","200000","34","45674","34","67456","80","564","Коментарий" });
        material.put( "6", new Object[] { "Стройка6", "Аэропорт", "Национальный аэропорт минск","Производственное","Наружные/Внутренние","Иванов И.И.","200000","34","45674","34","67456","80","564","Коментарий" });
        material.put( "7", new Object[] { "Стройка7", "Аэропорт", "Национальный аэропорт минск","Производственное","Наружные/Внутренние","Иванов И.И.","200000","34","45674","34","67456","80","564","Коментарий" });


        XSSFCellStyle cellStyleMaterial = workbook.createCellStyle();
        cellStyleMaterial.setBorderRight(BorderStyle.THIN);
        cellStyleMaterial.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyleMaterial.setBorderBottom(BorderStyle.THIN);
        cellStyleMaterial.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        Set< String > keyid = material.keySet();
        int rowid = 4;

        for (String key : keyid) {
            row = sheetForm.createRow(rowid++);
            Object [] objectArr = material.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);

                cell.setCellValue((String)obj);
                cell.setCellStyle(cellStyleMaterial);
            }
        }
        // sheetForm.autoSizeColumn(1);

        FileOutputStream out = new FileOutputStream(new File("object.xlsx"));
        workbook.write(out);
        out.close();
        workbook.close();

    }


}
