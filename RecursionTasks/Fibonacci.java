package RecursionTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Fibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bufferedReader.readLine());
        long result = fibonachi(n);

        System.out.println(result);
    }

    public static long fibonachi(long index) {
        return fibonachi(index, 0, 1);
    }

    public static long fibonachi(long n, long a, long b) {
        if (n == 0){
            return 0;
        } else if(n == 1){
            return b;
        }
        return fibonachi(n - 1, b, a + b);
    }
}
