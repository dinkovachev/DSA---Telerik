package RecursionTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayWith6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(",");
        int[] integers = new int[input.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = Integer.parseInt(input[i]);
        }
        int index = Integer.parseInt(bufferedReader.readLine());
        System.out.println(containsSix(integers, index));
    }

    public static boolean containsSix(int[] integers, int index){
        if (index == integers.length){
            return false;
        }
        if (integers[index] == 6){
            return true;
        }

        return containsSix(integers, index + 1);
    }
}