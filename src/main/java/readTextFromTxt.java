import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readTextFromTxt {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            System.out.println(everything);
        } finally {
            br.close();
        }


//        String file ="text.txt";
//        DataInputStream reader = new DataInputStream(new FileInputStream(file));
//        String result = reader.readUTF();
//        reader.close();
//        System.out.println(result);

    }
}
