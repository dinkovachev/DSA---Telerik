import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorsOffice {
    private static final List<String> patients = new ArrayList<>();
    private static final Map<String, Integer> patientsHash = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] command = reader.readLine().split(" ");
        while (!command[0].equalsIgnoreCase("end")) {
            switch (command[0].toLowerCase()) {
                case "append":
                    append(command[1]);
                    break;
                case "insert":
                    insert(command);
                    break;
                case "find":
                    find(command[1]);
                    break;
                case "examine":
                    examine(Integer.parseInt(command[1]));
                    break;
                default:
                    System.out.println("Error");
                    break;

            }
            command = reader.readLine().split(" ");
        }
    }

    private static void append(String name) {
        patients.add(name);
        patientsHash.merge(name, 1,Integer::sum);
        System.out.println("OK");
    }

    private static void insert(String[] command) {
        int position = Integer.parseInt(command[1]);
        if (patients.size() < position) {
            System.out.println("Error");
            return;
        }
        String name = command[2];
        if (position == 0) {
            patients.add(0, name);
        } else if (patients.size() == 0) {
            patients.add(name);
        } else if (position > patients.size()) {
            patients.add(name);
        } else {
            patients.add(position, name);
        }
        patientsHash.merge(name, 1,Integer::sum);
        System.out.println("OK");
    }

    private static void find(String name) {
        if (patientsHash.containsKey(name)) {
            System.out.println(patientsHash.get(name));
        } else {
            System.out.println("0");
        }
    }

    private static void examine(int numberOfExams) {
        StringBuilder result = new StringBuilder();
        if (patients.size() < numberOfExams) {
            System.out.println("Error");
            return;
        }
        for (int i = 0; i < numberOfExams; i++) {
            result.append(patients.get(0)).append(" ");
            patientsHash.replace(patients.get(0), patientsHash.get(patients.get(0)) - 1);
            if (patientsHash.get(patients.get(0)) == 0){
                patientsHash.remove(patients.get(0));
            }
            patients.remove(0);
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result);
    }
}
