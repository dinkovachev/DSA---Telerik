package RecursionTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangePi {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        System.out.println(changePi(input));
    }

    public static String changePi(String input) {
        if (input.length() == 0) {
            return "";
        }
        if (input.length()>= 2 && input.charAt(0) == 'p' && input.charAt(1) == 'i'){
            return "3.14" + changePi(input.substring(2));
        }
        return input.charAt(0) + changePi(input.substring(1));

    }

}
