import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class yandexTest {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        int count = 0;


        try {
            StringBuilder sb = new StringBuilder();
            count = Integer.parseInt(br.readLine());
            String line2 = br.readLine();
            String line3 = br.readLine();
            int[] numArr1 = Arrays.stream(line2.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] numArr2 = Arrays.stream(line3.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] outputArr = new int[count*2];
            System.out.println(count);
            System.out.println(line2);
            System.out.println(line3);

            int p = 0;
            for (int i = 0 ; i < numArr1.length || i < numArr2.length ; i++) {
                if (i < numArr1.length) {
                    outputArr[p++] = numArr1[i];
                }
                if (i < numArr2.length) {
                    outputArr[p++] = numArr2[i];
                }
            }
            for (int i = 0; i < outputArr.length; i++) {
                System.out.println(outputArr[i]);
            }

        } finally {
            br.close();
        }


    }


}
