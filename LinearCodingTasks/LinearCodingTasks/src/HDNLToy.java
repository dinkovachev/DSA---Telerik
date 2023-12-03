import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class HDNLToy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Stack<Character> stackString = new Stack<>();
        Stack<Integer> stackInteger = new Stack<>();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            char letter = input.toLowerCase().charAt(0);
            int number = Character.getNumericValue(input.charAt(1));
            String spaces = String.join("", Collections.nCopies(stackInteger.size(), " "));
            if (stackInteger.isEmpty() || number > stackInteger.peek()) {
                if (Character.isAlphabetic(letter)) {
                    stackString.add(letter);
                }
                if (number >= 1 && number <= 1000) {
                    stackInteger.add(number);
                }
                result.append(spaces).
                        append("<").
                        append(letter).
                        append(number).
                        append(">").
                        append(System.lineSeparator());

            } else {
                while (!stackInteger.isEmpty() && number <= stackInteger.peek()) {
                    spaces = String.join("", Collections.nCopies(stackInteger.size() - 1, " "));
                    result.append(spaces).
                            append("<").
                            append("/").
                            append(stackString.peek()).
                            append(stackInteger.peek()).
                            append(">").
                            append(System.lineSeparator());
                    stackString.pop();
                    stackInteger.pop();
                }
                stackInteger.push(number);
                stackString.push(letter);
                result.append(spaces).
                        append("<").
                        append(letter).
                        append(number).
                        append(">").
                        append(System.lineSeparator());
            }
        }
        while (!stackInteger.isEmpty()){
            String spaces = String.join("",Collections.nCopies(stackInteger.size() - 1, " "));
            result.append(spaces).
                    append("<").
                    append("/").
                    append(stackString.peek()).
                    append(stackInteger.peek()).
                    append(">").
                    append(System.lineSeparator());
            stackString.pop();
            stackInteger.pop();
        }
        System.out.println(result);
    }
}