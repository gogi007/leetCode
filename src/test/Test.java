package test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static String printerError(String s) {
        return matchesInString(s, "([N-Z]|[n-z])") + "/" + matchesInString(s, "([A-Z]|[a-z])");
    }

    /* alternativ:   public static String printerError(String s) {
        return s.chars().filter(c -> c > 'm').count() + "/" + s.length();
    }*/
    public static int matchesInString(String checkString, String matchString) {
        Matcher matcher
                = Pattern.compile(matchString).matcher(checkString);
        int matchesLength = 0;
        while (matcher.find())
            matchesLength += matcher.group().length();
        return matchesLength;
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
                + " " +
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
        for (int i = 0; i < charArr.length; i++) {
            newString = newString + charArr[i] + Character.toString(charArr[i]).repeat(i).toLowerCase() + '-';
        }
        return (newString + "--").replace("---", "");
    }
    /*alternativ:      return IntStream.range(0,s.length())
               .mapToObj(i->Stream.generate(()->s.charAt(i)).limit(i+1).collect(StringBuilder::new,StringBuilder::append,StringBuilder::append).toString())
               .map(a->a.substring(0,1).toUpperCase()+a.substring(1).toLowerCase())
               .collect(Collectors.joining("-"));*/

    public static String getMiddle(String word) {
        int evenSecNumb = (int) word.length() % 2 > 0 ? (int) Math.ceil(word.length() / 2) : -1;
        StringBuilder revStr = new StringBuilder(word.charAt((int) Math.floor(word.length() / 2) - 1));
        if (evenSecNumb > 0)
            revStr.append(word.charAt(evenSecNumb - 1));
        return revStr.toString();
    }

    public static String reverseWords(final String original) {
        String[] reverseArray = original.split(" ", 0);
        String returnString = original;
        for (String word : reverseArray) {
            returnString = returnString.replaceAll("\\b" + word.replace(".", "\\."),
                    new StringBuilder(word).reverse().toString());
        }
        return returnString;
    }
    /* ez is szimpatikus:   return Arrays.stream(original.split("(?<=\\s)|(?=\\s+)"))
                .map(str -> new StringBuilder(str).reverse().toString())
                .collect(Collectors.joining());
    }*/

    public static boolean isIsogram(String str) {
        char[] charSame = new char[str.length()];
        boolean result = true;
        for (int i = 0; i < str.length(); i++) {
            if (charSame.length > 0) {
                for (char f : charSame) {
                    if (str.toLowerCase().charAt(i) == f) {
                        result = false;
                        break;
                    }
                }
            }
            if (result) {
                charSame[i] = str.toLowerCase().charAt(i);
            } else {
                break;
            }
        }
        return result;
    }
    /*hát ez sokkal egyszerűbb:
        return str.length() == str.toLowerCase().chars().distinct().count();

     még ez is jó
     Set<Character> letters = new HashSet<Character>();

    for (int i = 0; i < str.length(); ++i) {
      if (letters.contains(str.toLowerCase().charAt(i))) {
        return false;
      }

      letters.add(str.charAt(i));
    }

    return true;
  }

     */

    public static int[] digitize(long n) {
        StringBuilder str = new StringBuilder(String.valueOf(n));
        String reversedStr = str.reverse().toString();
        int[] resultArr = new int[reversedStr.length()];
        for (int i = 0; i < reversedStr.length(); i++) {
            System.out.println(reversedStr.charAt(i));
            resultArr[i] = Character.getNumericValue(reversedStr.charAt(i));
        }
        return resultArr;
    }
    /*nagyon elegáns:
             return new StringBuilder().append(n)
                                  .reverse()
                                  .chars()
                                  .map(Character::getNumericValue)
                                  .toArray();
  }*/

    public static int[] countPositivesSumNegatives(int[] input)
    {
        if (input != null){
            int[] sumArr = new int[]{
                    (int) Arrays.stream(input)
                            .filter(i -> i > 0)
                            .count(),
                    (int) Arrays.stream(input)
                            .filter(i -> i < 0)
                            .sum()
            };
            if (sumArr[0] == 0 && sumArr[1] == 0)
                return new int[]{};
            else
                return sumArr;
        }
        else
            return new int[]{};
    }
    /* intStream is jó lehet:
    return input == null || input.length == 0 ?
          new int[0] :
          new int[] { (int)IntStream.of(input).filter(i->i>0).count(), IntStream.of(input).filter(i->i<0).sum() };
      }
    */

    public static String remove(String str) {
        return str.substring(1, str.length() - 1);
    }


    public static String rps(String p1, String p2) {
        return p1.equals(p2) ? "Draw!" : "Player " + ("scissorspaper paperrock rockscissors".contains(p1 + p2) ? 1 : 2) + " won!";
    }

    public static String getMiddles(String word) {
        int evenSecNumbUp = (int) Math.ceil((word.length() / 2));
        int evenSecNumbDown = (int) Math.floor((word.length() / 2));
        StringBuilder revStr = new StringBuilder();
        System.out.println(evenSecNumbUp);
        System.out.println(evenSecNumbDown);
        if (evenSecNumbUp == evenSecNumbDown) {
            revStr.append(word.charAt(evenSecNumbDown + 1));
        }
        revStr.append(word.charAt(evenSecNumbUp));
        return revStr.toString();
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
            arr[i] *= 2;
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
        /*System.out.println(reverseWords("The quick brown fox jumps over the lazy dog."));
        System.out.println(printerError("aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz"));
        System.out.println(remove("Gogolák"));
        System.out.println(Arrays.toString(digitize(35231)));*/
        System.out.println(Arrays.toString(countPositivesSumNegatives(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15})));
        /*public static String findNeedle(Object[] haystack) {
            return String.format("found the needle at position %d", java.util.Arrays.asList(haystack).indexOf("needle"));
        }*/

    }
}

