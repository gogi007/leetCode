package swaptwonumbers;

import java.util.Scanner;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int y, x, temo;
        System.out.println("Adj meg két számot");
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();
        System.out.println("Csere előtt" + x + y);
        temo = x;
        x = y;
        y = temo;
        System.out.println("Csere után" + x + y);
    }
}
