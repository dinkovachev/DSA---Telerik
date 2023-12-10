package RecursionTasks;

import java.util.Scanner;

public class LargestSurface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sizeInput = scanner.nextLine().split(" ");
        int[] sizeInt = new int[sizeInput.length];
        for (int i = 0; i < sizeInput.length; i++) {
            sizeInt[i] = Integer.parseInt(sizeInput[i]);
        }
        int row = sizeInt[0];
        int col = sizeInt[1];
        String[] input;
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            input = scanner.nextLine().split(" ");
            for (int j = i; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    matrix[j][k] = Integer.parseInt(input[k]);
                }
            }
        }
        int biggestCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int currentCount = dfs(matrix, i, j, matrix[i][j]);
                if (currentCount > biggestCount) {
                    biggestCount = currentCount;
                }
            }
        }
        System.out.println(biggestCount);
    }

    public static int dfs(int[][] matrix, int row, int col, int currentElement) {
        int path = 1;
        if (isOutOfMatrix(matrix, row, col)) {
            return 0;
        }
        if (isVisited(matrix, row, col)) {
            return 0;
        }
        if (isDifferent(matrix, row, col, currentElement)) {
            return 0;
        }
        matrix[row][col] = -1;

        return calculatePath(matrix, row, col, currentElement, path);

    }

    private static int calculatePath(int[][] matrix, int row, int col, int currentElement, int path) {
        path += dfs(matrix, row, col + 1, currentElement); // right
        path += dfs(matrix, row, col - 1, currentElement); // left
        path += dfs(matrix, row - 1, col, currentElement); // up
        path += dfs(matrix, row + 1, col, currentElement); // down
        return path;
    }

    public static boolean isOutOfMatrix(int[][] matrix, int row, int col) {
        return row >= matrix.length
                || row < 0
                || col >= matrix[0].length
                || col < 0;
    }

    public static boolean isDifferent(int[][] matrix, int row, int col, int currentElement) {
        return matrix[row][col] != currentElement;
    }

    public static boolean isVisited(int[][] matrix, int row, int col) {
        return matrix[row][col] == -1;
    }
}
