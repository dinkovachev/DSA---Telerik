import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cipher {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String secretCode = reader.readLine();
        String cipher = reader.readLine();

        List<String> result = new ArrayList<>();
        decodeMessages(secretCode, cipher, "", result);

        if (result.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(result.size());
            result.stream().sorted().forEach(System.out::println);
        }
    }

    private static void decodeMessages(String secretCode, String cipher, String currentMessage, List<String> result) {
        if (secretCode.isEmpty()) {
            result.add(currentMessage);
            return;
        }

        for (int i = 1; i <= secretCode.length(); i++) {
            String codePart = secretCode.substring(0, i);
            String letter = getLetterFromCipher(cipher, codePart);

            if (letter != null) {
                decodeMessages(secretCode.substring(i), cipher, currentMessage + letter, result);
            }
        }
    }

    private static String getLetterFromCipher(String cipher, String codePart) {
        int index = 0;
        while(index < cipher.length()){
            String letter = cipher.substring(index, index + 1);
            index++;
            StringBuilder code = new StringBuilder();
            while (index<cipher.length() && Character.isDigit(cipher.charAt(index))){
                code.append(cipher.charAt(index));
                index++;
            }
            if (code.toString().equals(codePart)){
                return letter;
            }
        }
        return null;

    }
}
