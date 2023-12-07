package RecursionTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountOccurrences2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        System.out.println(occurrences(n));
    }

    public static int occurrences(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 10 == 8) {
            int temp = n / 10;
            if (temp % 10 == 8) {
                return 2 + occurrences(n / 10);
            } else {
                return 1 + occurrences(n / 10);
            }
        }
        return occurrences(n / 10);
    }
}

