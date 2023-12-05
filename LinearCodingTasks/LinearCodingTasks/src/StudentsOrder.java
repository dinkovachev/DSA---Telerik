import java.util.*;

public class StudentsOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputNumbers = scanner.nextLine().split(" ");
        int seatChanges = Integer.parseInt(inputNumbers[1]);

        String studentNames = scanner.nextLine();
        List<String> students = new ArrayList<>(Arrays.asList(studentNames.split(" ")));

        String[] changes = new String[seatChanges];

        for (int i = 0; i < seatChanges; i++) {
            changes[i] = scanner.nextLine();
            String[] temp = changes[i].split(" ");
            students.remove(temp[0]);
            students.add(students.indexOf(temp[1]), temp[0]);
        }
        System.out.println(String.join(" ", students));
    }
}


//        Scanner sc = new Scanner(System.in);
//
//        String input = sc.nextLine();
//        String[] inputArr = input.split(" ");
//        int seatChanges = Integer.parseInt(inputArr[1]);
//
//        String names = sc.nextLine();
//        //List<String> students = new LinkedList<>(Arrays.asList(names.split(" ")));
//        List<String> students = new ArrayList<>(Arrays.asList(names.split(" ")));
//
//        String[] changes = new String[seatChanges];
//
//        for (int i = 0; i < seatChanges; i++) {
//            changes[i] = sc.nextLine();
//            String[] temp = changes[i].split(" ");
//            students.remove(temp[0]);
//            students.add(students.indexOf(temp[1]), temp[0]);
//
//        }
//
//        System.out.println(String.join(" ", students));
//    }
//}