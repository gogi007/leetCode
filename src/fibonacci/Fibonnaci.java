package fibonacci;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonnaci {
    public static void main(String[] args) {
        int times;
        int[] szamok;
        Scanner in = new Scanner(System.in);
        System.out.println("Kérem adja meg hányszor fusson");
        times = in.nextInt();
        szamok = new int[times];
        szamok[0] = 0;
        szamok[1] = 1;
        System.out.println("Fibonnaci sorozat számai: ");
        for (int i = 2; i < times; i++) {
            szamok[i] = szamok[i - 1] + szamok[i - 2];
        }
        System.out.println(Arrays.toString(szamok));
    }
}
