//import java.util.*;
//import java.util.stream.Collectors;
//
//public class NoahsArk {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
//        String animalName;
//        int animalCounter;
//        StringBuilder result = new StringBuilder();
//
//        Map<String, Integer> animals = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            animalCounter = 1;
//            animalName = scanner.nextLine();
//            if (animals.containsKey(animalName)) {
//                animalCounter++;
//                animals.put(animalName, animalCounter);
//            } else {
//                animals.put(animalName, animalCounter);
//            }
//
//        }
//
//        for (String name : animals.keySet().stream().sorted().collect(Collectors.toList())) {
//            if (animals.get(name) % 2 == 0) {
//                result.append(name).append(" ").append(animals.get(name).toString()).append(" ").append("Yes").
//                        append(System.lineSeparator());
//            } else {
//                result.append(name).append(" ").append(animals.get(name).toString()).append(" ").append("No").
//                        append(System.lineSeparator());
//            }
//        }
//
//        System.out.println(result);
//
//    }
//}

import java.util.*;
import java.util.stream.Collectors;

public class NoahsArk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String animalName;
        int animalCounter = 1;
        StringBuilder result = new StringBuilder();

        Map<String, Integer> animals = new HashMap<>();

        for (int i = 0; i < n; i++) {
            animalName = scanner.nextLine();
            if (animals.containsKey(animalName)) {
                animals.merge(animalName, animalCounter, Integer::sum);
            } else {
                animals.put(animalName, animalCounter);
            }
        }
        for (String name : animals.keySet().stream().sorted().collect(Collectors.toList())) {
            if (animals.get(name) % 2 == 0) {
                result.append(name).append(" ").append(animals.get(name).toString()).append(" ").append("Yes").
                        append(System.lineSeparator());
            } else {
                result.append(name).append(" ").append(animals.get(name).toString()).append(" ").append("No").
                        append(System.lineSeparator());
            }
        }
        System.out.println(result);

    }
}
