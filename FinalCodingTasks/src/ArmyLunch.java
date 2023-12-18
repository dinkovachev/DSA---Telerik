import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ArmyLunch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");
        // s -> c -> p
        List<String> sergeants = new ArrayList<>();
        List<String> corporals = new ArrayList<>();
        List<String> privates = new ArrayList<>();

        for (String s : input) {
            if (s.charAt(0) == 'S') {
                sergeants.add(s);
            } else if (s.charAt(0) == 'C') {
                corporals.add(s);
            } else {
                privates.add(s);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String sergeant : sergeants) {
            result.append(String.format("%s ",sergeant));
        }
        for (String corporal : corporals) {
            result.append(String.format("%s ", corporal));
        }
        for (String aPrivate : privates) {
            result.append(String.format("%s ", aPrivate));
        }

        System.out.println(result);
    }
}
