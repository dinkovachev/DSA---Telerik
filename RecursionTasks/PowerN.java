package RecursionTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerN {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int base = Integer.parseInt(bufferedReader.readLine());
        int power = Integer.parseInt(bufferedReader.readLine());

        System.out.println(powerN(base, power));
    }
    public static int powerN(int base, int power){
        if (power == 1){
            return base;
        }
        return base * powerN(base, power - 1);
    }
}
