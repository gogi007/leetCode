package test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {

    public static int sum(int[] arr) {
        return Arrays.stream(arr).filter(y -> y > 0).sum();
    }

    public static double find_average(int[] array) {
        return array.length == 0 ? 0 : Arrays.stream(array).sum() / array.length;
    }

    public static boolean feast(String beast, String dish) {
        return beast.charAt(0) == dish.charAt(0) && beast.charAt(beast.length() - 1) == dish.charAt(dish.length() - 1) ? true : false;

    }

    public static int sum2(int[] numbers) {
        int min = Arrays.stream(numbers)
                .min()
                .getAsInt();
        int max = Arrays.stream(numbers)
                .max()
                .getAsInt();
        return Arrays.stream(numbers)
                .filter(y -> y != min && y != max)
                .sum();
    }

    public static String smash(String... words) {
        return Arrays.asList(words)
                .stream()
                .collect(Collectors.joining(" "));
        //milyen egyszerű lett volna:
        //return String.join(" ", words);
    }

    public static int points(String[] games) {
        int overall = 0;
        for (String oneMatch : games) {
            int[] arrPoints = Arrays.stream(oneMatch.split(":", 2))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            overall += arrPoints[0] > arrPoints[1] ? 3 : arrPoints[0] == arrPoints[1] ? 1 : 0;

            /* ez így szebb is lehetett volna
                   return Arrays.stream(games)
                     .mapToInt(score -> score.charAt(0) - score.charAt(2))
                     .map(match -> match > 0 ? 3 : match == 0 ? 1 : 0)
                     .sum();*/
        }
        return overall;
    }

    public static String seriesSum(int n) {
        int[] series = new int[n];
        series[0] = 1;
        double sum = 1.0;
        for (int i = 1; i < n; i++) {
            series[i] = series[i - 1] + 3;
            sum += 1.0 / (double) series[i];
        }
        return String.format("%.2f", sum);
    }

    public static String highAndLow(String numbers) {
        int[] numSer = Arrays.stream(numbers.split(" ", 0))
                .mapToInt(Integer::parseInt)
                .toArray();
        return Arrays.stream(numSer)
                .max()
                .getAsInt()
                +" "+
                Arrays.stream(numSer)
                .min()
                .getAsInt();
    }
    /*Na ezt így is lehetet volna:  static String highAndLow(String numbers) {
    var stats = stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
    return stats.getMax() + " " + stats.getMin();
    }*/

    public static String accum(String s) {
        char[] charArr = s.toUpperCase().toCharArray();
        String newString = "";
        for(int i=0; i < charArr.length;i++){
            newString=newString+charArr[i]+Character.toString(charArr[i]).repeat(i).toLowerCase()+'-';
        }
        return (newString+"--").replace("---","");
    }
    /*alternativ:      return IntStream.range(0,s.length())
               .mapToObj(i->Stream.generate(()->s.charAt(i)).limit(i+1).collect(StringBuilder::new,StringBuilder::append,StringBuilder::append).toString())
               .map(a->a.substring(0,1).toUpperCase()+a.substring(1).toLowerCase())
               .collect(Collectors.joining("-"));*/

    public static String getMiddle(String word) {
        int evenSecNumb = (int) word.length() % 2 > 0 ? (int) Math.ceil(word.length() / 2) : -1;
        StringBuilder revStr = new StringBuilder(word.charAt((int) Math.floor(word.length() / 2)-1));
        if (evenSecNumb > 0)
            revStr.append(word.charAt(evenSecNumb-1));
        return   revStr.toString() ;
    }

    public static String reverseWords(final String original)
    {
        String[] reverseArray = original.split(" ",0);
        String returnString = original;
        for (String word : reverseArray){
            returnString = returnString.replaceAll("\\b"+word.replace(".","\\."),new StringBuilder(word).reverse().toString());
        }
        return returnString;
    }
    /* ez is szimpatikus:   return Arrays.stream(original.split("(?<=\\s)|(?=\\s+)"))
                .map(str -> new StringBuilder(str).reverse().toString())
                .collect(Collectors.joining());
    }*/

    public static String rps(String p1, String p2) {
        return p1.equals(p2) ? "Draw!" : "Player " + ("scissorspaper paperrock rockscissors".contains(p1+p2)?1:2) + " won!";
    }

    public static String getMiddles(String word) {
        int evenSecNumbUp = (int) Math.ceil((word.length() / 2) );
        int evenSecNumbDown = (int) Math.floor((word.length() / 2));
        StringBuilder revStr = new StringBuilder();
        System.out.println(evenSecNumbUp);
            System.out.println(evenSecNumbDown);
        if (evenSecNumbUp == evenSecNumbDown) {
            revStr.append(word.charAt(evenSecNumbDown+1));
        }
        revStr.append(word.charAt(evenSecNumbUp));
        return   revStr.toString() ;
    }

    public static boolean betterThanAverage(int[] classPoints, int yourPoints) {
        return Arrays.stream(classPoints).average().orElse(Double.NaN) < yourPoints ? true : false;
    }

    public static String solution(String str) {
        StringBuilder revBuild = new StringBuilder(str);
        return revBuild.reverse().toString();
    }

    public static int[] map(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]*= 2;
        }
        return arr;
        //helyette ez is jó lett volna
        //return Arrays.stream(arr).map(x -> x*2).toArray();
    }

    public static void main(String[] args) {
        //System.out.println(sum(new int[]{1,2,3,4,5}));
        //System.out.println(sum(new int[]{}));

        /*System.out.println(find_average(new int[]{1, 1, 1}));
        System.out.println(find_average(new int[]{1, 2, 3, 3}));
        System.out.println(feast("coca", "cakec"));
        System.out.println(getMiddles("tesztseg"));
        System.out.println(smash(new String[] {"teszt", "meg ezt"}));
        System.out.println(accum("teszt"));*/
        //System.out.println(reverseWords("teszteljünk ki mindent"));
        System.out.println(reverseWords("The quick brown fox jumps over the lazy dog."));
        /*public static String findNeedle(Object[] haystack) {
            return String.format("found the needle at position %d", java.util.Arrays.asList(haystack).indexOf("needle"));
        }*/

    }
}

