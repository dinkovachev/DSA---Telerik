package RecursionTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BunnyEars {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        if (n == 0) {
            System.out.println(0);
        } else {
            System.out.println(bunnyEars(n));

        }
    }
    public static int bunnyEars(int n) {
        if (n == 1) {
            return 2;
        }
        return 2 + bunnyEars(n - 1);
        }
    }

