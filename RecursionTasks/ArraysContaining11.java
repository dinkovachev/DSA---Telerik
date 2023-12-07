package RecursionTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArraysContaining11 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(",");
        int[] integers = new int[input.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = Integer.parseInt(input[i]);
        }
        int index = Integer.parseInt(bufferedReader.readLine());
        System.out.println(amountOfEleven(integers, index));
    }

    public static int amountOfEleven(int[] integers, int index) {
        if (index == integers.length) {
            return 0;
        }
        if (integers[index] == 11) {
            return 1 + amountOfEleven(integers, index + 1);
        }
        return amountOfEleven(integers, index + 1);
    }
}

