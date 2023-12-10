package RecursionTasks;

import java.util.Scanner;

public class ScroogeMcDuck {
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
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0 && !hasExited) {
                    solveTask(matrix, i, j);
                    break;
                }
            }
        }
        System.out.println(coinsCollected);
    }

    private static int coinsCollected = 0;
    private static boolean hasExited = false;

    private static void solveTask(int[][] matrix, int row, int col) {
        if (isOutOfMaze(matrix, row, col) || hasExited) {
            return;
        }
        matrix[row][col] -= 1;
        if (isExit(matrix, row, col)) {
            hasExited = true;
            return;
        }
        biggestValueInCells(matrix, row, col);
        coinsCollected++;
    }

    private static void biggestValueInCells(int[][] matrix, int row, int col) {
        int valueCellToTheLeft = 0;
        int valueCellToTheRight = 0;
        int valueCellToTheUp = 0;
        int valueCellToTheDown = 0;

        if (!isOutOfMaze(matrix, row, col - 1)) {
            valueCellToTheLeft = matrix[row][col - 1];
        }
        if (!isOutOfMaze(matrix, row, col + 1)) {
            valueCellToTheRight = matrix[row][col + 1];
        }
        if (!isOutOfMaze(matrix, row - 1, col)) {
            valueCellToTheUp = matrix[row - 1][col];
        }
        if (!isOutOfMaze(matrix, row + 1, col)) {
            valueCellToTheDown = matrix[row + 1][col];
        }
        int maxValue = getMaxValue(valueCellToTheLeft, valueCellToTheRight, valueCellToTheUp, valueCellToTheDown);

        cellsMovement(matrix, row, col, valueCellToTheLeft, valueCellToTheRight, valueCellToTheUp, valueCellToTheDown, maxValue);
    }

    private static void cellsMovement(int[][] matrix, int row, int col, int valueCellToTheLeft, int valueCellToTheRight, int valueCellToTheUp, int valueCellToTheDown, int maxValue) {
        if (valueCellToTheLeft > valueCellToTheRight
                && valueCellToTheLeft > valueCellToTheUp
                && valueCellToTheLeft > valueCellToTheDown) {

            solveTask(matrix, row, col - 1); // left
        } else if (valueCellToTheRight > valueCellToTheLeft
                && valueCellToTheRight > valueCellToTheUp
                && valueCellToTheRight > valueCellToTheDown) {

            solveTask(matrix, row, col + 1); // right
        } else if (valueCellToTheUp > valueCellToTheLeft
                && valueCellToTheUp > valueCellToTheRight
                && valueCellToTheUp > valueCellToTheDown) {

            solveTask(matrix, row - 1, col); // up
        } else if (valueCellToTheDown > valueCellToTheLeft
                && valueCellToTheDown > valueCellToTheRight
                && valueCellToTheDown > valueCellToTheUp) {

            solveTask(matrix, row + 1, col); // down        }
        } else if (valueCellToTheLeft != 0 && valueCellToTheLeft != -1
                && maxValue == valueCellToTheLeft) {
            solveTask(matrix, row, col - 1); // left
        } else if (valueCellToTheRight != 0 && valueCellToTheRight != -1
                && maxValue == valueCellToTheRight) {
            solveTask(matrix, row, col + 1); // right
        } else if (valueCellToTheUp != 0 && valueCellToTheUp != -1
                && maxValue == valueCellToTheUp) {
            solveTask(matrix, row - 1, col); // up
        } else if (valueCellToTheDown != 0 && valueCellToTheDown != -1
                && maxValue == valueCellToTheDown) {
            solveTask(matrix, row + 1, col); // down
        }
    }

    private static boolean isExit(int[][] matrix, int row, int col) {
        // upperLeft corner
        if (isOutOfMaze(matrix, row - 1, col) &&
                isOutOfMaze(matrix, row, col - 1)) {
            return (matrix[row][col + 1] == 0 || matrix[row][col + 1] == -1) &&
                    (matrix[row + 1][col] == 0 || matrix[row + 1][col] == -1);
        }
        // upperRight corner
        else if (isOutOfMaze(matrix, row - 1, col) &&
                isOutOfMaze(matrix, row, col + 1)) {
            return (matrix[row][col - 1] == 0 || matrix[row][col - 1] == -1) &&
                    (matrix[row + 1][col] == 0 || matrix[row + 1][col] == -1);
        }
        // LowerRight corner
        else if (isOutOfMaze(matrix, row + 1, col) &&
                isOutOfMaze(matrix, row, col + 1)) {
            return (matrix[row][col - 1] == 0 || matrix[row][col - 1] == -1) &&
                    (matrix[row - 1][col] == 0 || matrix[row - 1][col] == -1);
        }
        //LowerLeft corner
        else if (isOutOfMaze(matrix, row + 1, col) &&
                isOutOfMaze(matrix, row, col - 1)) {
            return (matrix[row][col + 1] == 0 || matrix[row][col + 1] == -1) &&
                    (matrix[row - 1][col] == 0 || matrix[row - 1][col] == -1);
        }
        //Upper
        else if (isOutOfMaze(matrix, row - 1, col)) {
            return (matrix[row][col + 1] == 0 || matrix[row][col + 1] == -1) &&
                    (matrix[row + 1][col] == 0 || matrix[row + 1][col] == -1) &&
                    (matrix[row][col - 1] == 0 || matrix[row][col - 1] == -1);
        }
        // Right
        else if (isOutOfMaze(matrix, row, col + 1)) {
            return (matrix[row - 1][col] == 0 || matrix[row - 1][col] == -1) &&
                    (matrix[row + 1][col] == 0 || matrix[row + 1][col] == -1) &&
                    (matrix[row][col - 1] == 0 || matrix[row][col - 1] == -1);
        }
        // Lower
        else if (isOutOfMaze(matrix, row + 1, col)) {
            return (matrix[row][col - 1] == 0 || matrix[row][col - 1] == -1) &&
                    (matrix[row - 1][col] == 0 || matrix[row - 1][col] == -1) &&
                    (matrix[row][col + 1] == 0 || matrix[row][col + 1] == -1);
        }
        // Left
        else if (isOutOfMaze(matrix, row, col - 1)) {
            return (matrix[row - 1][col] == 0 || matrix[row - 1][col] == -1) &&
                    (matrix[row + 1][col] == 0 || matrix[row + 1][col] == -1) &&
                    (matrix[row][col + 1] == 0 || matrix[row][col + 1] == -1);
        }
        // Inside(middle)
        else {
            return (matrix[row][col - 1] == 0 || matrix[row][col - 1] == -1) &&
                    (matrix[row][col + 1] == 0 || matrix[row][col + 1] == -1) &&
                    (matrix[row - 1][col] == 0 || matrix[row - 1][col] == -1) &&
                    (matrix[row + 1][col] == 0 || matrix[row + 1][col] == -1);
        }
    }

    private static int getMaxValue(int... coins) {
        int maxCoins = 0;
        for (int coin : coins) {
            if (coin > maxCoins) {
                maxCoins = coin;
            }
        }
        return maxCoins;
    }

    private static boolean isOutOfMaze(int[][] matrix, int row, int col) {
        return row >= matrix.length
                || row < 0
                || col >= matrix[0].length
                || col < 0;
    }
}

