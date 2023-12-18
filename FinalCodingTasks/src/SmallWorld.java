import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = reader.readLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        int[][] maze = new int[rows][cols];
        List<Integer> output = createMaze(reader, rows, cols, maze);
        Collections.sort(output);
        for (int i = output.size() - 1; i >= 0; i--) {
            System.out.println(output.get(i));
        }
    }

    private static List<Integer> createMaze(BufferedReader reader, int rows, int cols, int[][] maze) throws IOException {
        for (int i = 0; i < rows; i++) {
            String[] rowsInput = reader.readLine().split("");
            for (int j = 0; j < cols; j++) {
                maze[i][j] = Integer.parseInt(rowsInput[j]);
            }
        }
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        List<Integer> temporarySet = new ArrayList<>();
        for (int rowVisited = 0; rowVisited < rows; rowVisited++) {
            for (int col = 0; col < cols; col++) {
                if (visited[rowVisited][col]) continue;
                count = countRepeat(maze, visited, rowVisited, col);
                if (count != 0) {
                    temporarySet.add(count);
                }
            }
        }
        return temporarySet;
    }

    private static int countRepeat(int[][] maze, boolean[][] visited, int row, int col) {
        if (outOfMaze(maze, row, col)) {
            return 0;
        }
        if (maze[row][col] != 1) {
            return 0;
        }
        if (visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        return 1 + countRepeat(maze, visited, row + 1, col)
                + countRepeat(maze, visited, row, col - 1)
                + countRepeat(maze, visited, row, col + 1)
                + countRepeat(maze, visited, row - 1, col);
    }

    private static boolean outOfMaze(int[][] maze, int row, int col) {
        return row > maze.length - 1 || row < 0 || col > maze[row].length - 1 || col < 0;
    }
}
