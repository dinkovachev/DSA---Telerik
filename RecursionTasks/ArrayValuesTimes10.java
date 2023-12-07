package RecursionTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayValuesTimes10 {
     public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(",");
        int[] integers = new int[input.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = Integer.parseInt(input[i]);
        }
        int index = Integer.parseInt(bufferedReader.readLine());
        System.out.println(arrayValuesTimes10(integers, index));
    }
    public static boolean arrayValuesTimes10(int[] integers, int index){
         if (index == integers.length || index == integers.length - 1){
             return false;
         }
         if (integers[index + 1] == integers[index] * 10){
             return true;
         }
         return arrayValuesTimes10(integers, index+1);
    }
}
