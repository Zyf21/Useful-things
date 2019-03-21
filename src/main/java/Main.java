import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        String[] names = { "Terminator", "Slicer","Ninja", "cow", "Robot", "littlegirl" };
        String name = names[(int) (Math.random() * names.length)];
        System.out.println(name);
    }
}
