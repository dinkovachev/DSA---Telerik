package RecursionTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountX {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        System.out.println(lowerCases(input));
    }

    public static int lowerCases(String input) {
        if (input.length() == 0) {
            return 0;
        }
        if (input.charAt(0) == 'x'){
            return 1 + lowerCases(input.substring(1));
        }
        return lowerCases(input.substring(1));
    }
}
