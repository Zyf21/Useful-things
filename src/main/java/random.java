import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class random {
    public static void main(String[] args) throws IOException {

        String[] names = { "ADVPARAMEDIC", "PARAMEDIC","EMRGMEDICALTECH" };
        List<String> roles=new ArrayList<String>();
        Random rand =new Random();
        int randomNum = rand.nextInt((2 - 0) + 1) + 0;
        for(int i=0;i<=randomNum;i++){
            roles.add(names[i]);
        }
        for (String st:roles){
            System.out.println(st);
        }
        System.out.println(randomNum);


    }
}
