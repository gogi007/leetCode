package duplicatecharacters;

import java.util.Scanner;

public class DuplicateCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Kérem add meg az ellenőrizendő szöveget");
        String unChString = in.nextLine();
        char[] chars = unChString.replace(" ", "").toCharArray();
        System.out.println("Duplikált karaktarek");
        //System.out.println(chars);
        for (int i = 0; i < chars.length; i++) {
            //System.out.println(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                //System.out.println(chars[j]);
                if (chars[i] == chars[j]) {
                    System.out.println(chars[i]);
                    break;
                }

            }

        }

    }
}
