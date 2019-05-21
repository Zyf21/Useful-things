import java.util.Arrays;

public class puz {
    public static void main(String[] args)  {

        printPascalDreieck2(50);

    }


    public static void printPascalDreieck2(int n) {

        int zeile = n;

        int[][] arr = new int[zeile][];
        arr[0] = new int[1];
        arr[1] = new int[2];
        arr[1][0] = arr[1][1] = 1;
        System.out.print(arr[0][0] = 1);
        System.out.print("\n");
        System.out.print(arr[1][0] + "." + arr[1][1] + "\n");
        for (int i = 2; i < zeile; i++) {
            arr[i] = new int[i + 1];
            System.out.printf((arr[i][0] = 1) + ".");
            for (int j = 1; j < i; j++) {
                System.out
                        .print((arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j])
                                + ".");
            }
            System.out.println(arr[i][i] = 1);
        }
    }
}