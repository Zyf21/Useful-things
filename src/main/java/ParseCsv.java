import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ParseCsv {

    public static void main(String[] args) throws IOException, CsvException {
        File folder = new File("csvpak");
        File[] files = folder.listFiles();
        Map<String,String[]> map = new TreeMap<>();
        String STRING_ARRAY_SAMPLE = "csvpak/888.csv";
        Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));
        CSVWriter csvWriter = new CSVWriter(writer);

        for (File file : files) {
            if (file.isFile() && file.exists() && file.getName().contains(".csv")){
                Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
                CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
                CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();
                List<String[]> records = csvReader.readAll();
                for (String[] record : records) {
                    System.out.println(record.length);
                    System.out.println(record[6]);
                    map.put(record[6], record);
                }
            }
        }
        for(Map.Entry<String,String[]> s : map.entrySet()){
            csvWriter.writeNext(s.getValue());

        }
        writer.close();
}
}
