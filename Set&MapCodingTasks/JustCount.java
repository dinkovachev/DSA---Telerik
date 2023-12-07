import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JustCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new TreeMap<>();
        char[] input = reader.readLine().toCharArray();

        //StringBuilder result = new StringBuilder();

        for (char character : input) {
            if (!map.containsKey(character)) {
                map.put(character, 1);
            } else {
                map.put(character, map.get(character) + 1);
            }
        }
        Character specialCase = '-';
        int countSpecialCase = 0;
        Character lowerCase = '-';
        int countLowerCase = 0;
        Character upperCase = '-';
        int countUpperCase = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (Character.isLowerCase(entry.getKey())) {
                if (entry.getValue() > countLowerCase) {
                    lowerCase = entry.getKey();
                    countLowerCase = entry.getValue();
                }
            } else if (Character.isUpperCase(entry.getKey())) {
                if (entry.getValue() > countUpperCase) {
                    upperCase = entry.getKey();
                    countUpperCase = entry.getValue();
                }
            } else {
                if (entry.getValue() > countSpecialCase) {
                    specialCase = entry.getKey();
                    countSpecialCase = entry.getValue();
                }
            }
        }
        if (countSpecialCase == 0) {
            System.out.printf("%s\n", specialCase);
        } else {
            System.out.printf("%s %s\n", specialCase, countSpecialCase);
        }
        if (countLowerCase == 0) {
            System.out.printf("%s\n", lowerCase);
        } else {
            System.out.printf("%s %s\n", lowerCase, countLowerCase);
        }
        if (countUpperCase == 0) {
            System.out.printf("%s\n", upperCase);
        } else {
            System.out.printf("%s %s\n", upperCase, countUpperCase);
        }
    }
}
