package RecursionTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BunnyEars2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        System.out.println(bunniesEars(n));
    }

    public static long bunniesEars(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 2 == 0) {
            return 3 + bunniesEars(n - 1);
        }

        return 2 + bunniesEars(n - 1);
    }
}

