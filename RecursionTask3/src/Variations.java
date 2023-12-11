import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Variations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int z = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");


        Set<String> combinations = new TreeSet<>(Arrays.asList(input));
        StringBuilder result = new StringBuilder();


        makeTheCombinations(combinations, z, result);
    }

    public static String makeTheCombinations(Set<String> combinations, int z, StringBuilder result) {
        if (z == 0) {
            System.out.println(result);
            return "";
        }
        for (String combination : combinations) {
            result.append(combination);
            makeTheCombinations(combinations, z - 1, result);
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }
}
