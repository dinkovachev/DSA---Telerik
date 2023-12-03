import java.util.*;

public class Jumps {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        Queue<Integer> myQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            myQueue.offer(Integer.parseInt(input[i]));
        }
        int longestJumpsCounter = 0;
        int[] jumpsOfEachNumber = new int[n];
        int i = 0;
        while (myQueue.size() > 1) {
            int jumpCounter = 0;
            int currentElement = myQueue.peek();
            for (int nextElement : myQueue) {
                if (currentElement < nextElement) {
                    jumpCounter++;
                    jumpsOfEachNumber[i]++;
                    currentElement = nextElement;
                    if (jumpCounter > longestJumpsCounter) {
                        longestJumpsCounter = jumpCounter;
                    }
                }
            }
            i++;
            myQueue.remove();
        }
        System.out.println(longestJumpsCounter);
        for (int k : jumpsOfEachNumber) {
            System.out.print(k + " ");
        }
    }
}
