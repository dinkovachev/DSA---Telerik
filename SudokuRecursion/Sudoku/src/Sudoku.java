import java.util.Scanner;

public class Sudoku {
    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[][] sudokuMatrix = new int[9][9];
        for (int i = 0; i < sudokuMatrix.length; i++) {
            String[] inputMatrix = scanner.nextLine().split(" ");
            for (int j = 0; j < sudokuMatrix[0].length; j++) {
                sudokuMatrix[i][j] = Integer.parseInt(inputMatrix[j]);
            }
        }
        for (int[] matrix : sudokuMatrix) {
            for (int j = 0; j < sudokuMatrix[0].length; j++) {
                System.out.print(matrix[j] + " ");
            }
            System.out.println();
        }
        if (solveBoard(sudokuMatrix)) {
            System.out.println("Solved successfully!");
            for (int[] matrix : sudokuMatrix) {
                for (int j = 0; j < sudokuMatrix[0].length; j++) {
                    System.out.print(matrix[j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Can't be solved");
        }
    }

    private static boolean isNumberInRoll(int[][] sudokuMatrix, int number, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (sudokuMatrix[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(int[][] sudokuMatrix, int number, int col) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (sudokuMatrix[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] sudokuMatrix, int number, int row, int col) {
        int localBoxRow = row - row % 3;
        int localBoxCol = col - col % 3;
        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxCol; j < localBoxCol + 3; j++) {
                if (sudokuMatrix[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] sudokuMatrix, int number, int row, int col) {
        return !isNumberInRoll(sudokuMatrix, number, row)
                && !isNumberInColumn(sudokuMatrix, number, col)
                && !isNumberInBox(sudokuMatrix, number, row, col);
    }

    private static boolean solveBoard(int[][] sudokuMatrix) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (sudokuMatrix[row][col] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValidPlacement(sudokuMatrix, numberToTry, row, col)) {
                            sudokuMatrix[row][col] = numberToTry;

                            if (solveBoard(sudokuMatrix)) {
                                return true;
                            } else {
                                sudokuMatrix[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}