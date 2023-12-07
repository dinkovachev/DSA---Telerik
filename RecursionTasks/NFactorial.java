package RecursionTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());


        System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
