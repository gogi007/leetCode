package finalcountwords;

import java.util.HashMap;
import java.util.Locale;

public class FinalCountWords {
    public static void main(String[] args){
        String str = "Nagyon nagyon szót fogok most most megadni";
        String[] split = str.split(" ");
        HashMap<String,Integer> map =new HashMap<String,Integer>();

        for (int i = 0; i < split.length; i++) {
            int count = 0;
            if (map.containsKey((split[i]).toLowerCase())) {
                count = map.get(split[i].toLowerCase());
            }
            map.put(split[i].toLowerCase(),count+1);
        }
        System.out.println(map);
    }
}
