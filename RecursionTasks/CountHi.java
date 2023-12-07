package RecursionTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountHi {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        System.out.println(lowerCases(input));
    }

    public static int lowerCases(String input) {
        if (input.length() == 0) {
            return 0;
        }
        if (input.length() >= 2 && input.charAt(0) == 'h' && input.charAt(1) == 'i') {
            return 1 + lowerCases(input.substring(2));
        }

        return lowerCases(input.substring(1));
    }
}

