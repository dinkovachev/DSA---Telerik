import java.util.Scanner;

public class MinMaxCharacterInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        char smallestCharacter = minCharacter(input);
        char largestCharacter = maxCharacter(input);

        int index;
        System.out.println(smallestCharacter);
        System.out.println(largestCharacter);
    }

    public static char minCharacter(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return minCharacter(input, 0);
    }

    public static char minCharacter(String input, int index) {
        if (index == input.length() - 1) {
            return input.charAt(index);
        }

        char smallestCharacter = minCharacter(input, index + 1);
        return (input.charAt(index) < smallestCharacter) ? input.charAt(index) : smallestCharacter;
    }

        public static char maxCharacter (String input){
            if (input.isEmpty()) {
                throw new IllegalArgumentException();
            }
            return maxCharacter(input,0);
        }
        public static char maxCharacter(String input, int index) {
        if (index == input.length() - 1) {
            return input.charAt(index);
        }

        char smallestCharacter = maxCharacter(input, index + 1);
        return (input.charAt(index) > smallestCharacter) ? input.charAt(index) : smallestCharacter;
    }
}


