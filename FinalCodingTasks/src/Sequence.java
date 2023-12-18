import java.util.*;

public class Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        // Е1 = К;
        // Е2 = Е1 + 1; -> K + 1
        // Е3 = 2*Е1 + 1; -> 2K + 1
        // Е4 = Е1 + 2; -> K + 2
        // Е5 = Е2 + 1; -> K + 1 + 1
        // Е6 = 2*Е2 + 1; -> 2*(K + 1) + 1
        // Е7 = Е2 + 2; -> K + 1 + 2

        int current = k;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                current = k;
            } else if (i == 2) {
                current = current + 1;
            } else if (i == 3) {
                current = 2 * k + 1;
            } else if (i == 4) {
                current = k + 2;
            } else if (i % 3 == 0) {
                current = current + 1;
            } else {
                current = 2 * (current -1) + 1;
            }
        }
        System.out.println(current);
    }
}
// for (int i = 1; i <= n; i++) {
//            if (i == 1) {
//                current = k;
//            } else if (i == 2) {
//                current = current + 1;
//            } else if (i == 3) {
//                current = 2 * k + 1;
//            } else if (i == 4) {
//                current = k + 2;
//            } else if (i % 3 == 0) {
//                current = current + 1;
//            } else {
//                current = 2 * (current - 1) + 1;
//            }
//        }

//        Queue<Integer> queueInteger = new ArrayDeque<>();
//        queueInteger.add(k);
//
//        int current;
//        for (int i = 0; i < n; i++) {
//            current = queueInteger.poll();
//            queueInteger.offer(current + 1);
//            queueInteger.offer(current * 2 + 1);
//            queueInteger.offer(current + 2);
//        }
//        System.out.println(queueInteger.peek());

//        int[] formulas = new int[7];
//        formulas[0] = numbers[0];
//        formulas[1] = numbers[0] + 1;
//        formulas[2] = 2 * numbers[0] + 1;
//        formulas[3] = numbers[0] + 2;
//        formulas[4] = numbers[0] + 1 + 1;
//        formulas[5] = 2 * (numbers[0] + 1) + 1;
//        formulas[6] = numbers[0] + 1 + 2;
//
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < formulas.length; i++) {
//            if (numbers[1] == i) {
//                result.append(formulas[i]);
//                break;
//            }
//        }
//        System.out.println(result);

