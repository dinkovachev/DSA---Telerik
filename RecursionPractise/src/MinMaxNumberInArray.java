import java.util.Scanner;

public class MinMaxNumberInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        int n = numbers.length;
        System.out.println(findMinNumber(numbers, n));
    }

    public static int findMinNumber(int[] numbers, int n) {
        if (n == 1) {
            return numbers[0];
        }
        return Math.max(numbers[n - 1], findMinNumber(numbers, n - 1));
    }
}
