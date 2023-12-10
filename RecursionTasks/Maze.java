package RecursionTasks;

public class Maze {
    private static final char FREE_CELL = ' ';
    private static final char VISITED_CELL = 'V';
    private static final char WALL = 'X';
    private static final char EXIT = 'E';

    public static void main(String[] args) {
        char[][] maze = {
                {' ', ' ', ' ', 'X', ' ', 'E'},
                {' ', 'X', 'X', 'X', ' ', 'X'},
                {' ', ' ', ' ', 'X', ' ', ' '},
                {' ', ' ', ' ', 'X', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' '},
        };

        solveMaze(maze, 0, 0);
        //System.out.println(hasSolutionMaze(maze, 0, 0));
    }

    private static int counter = 0;

    private static void solveMaze(char[][] maze, int row, int col) {
        if (isOutOfMaze(maze, row, col)) {
            return;
        }

        if (isWall(maze, row, col)) {
            return;
        }

        if (isVisited(maze, row, col)) {
            return;
        }

        if (isExit(maze, row, col)) {
            counter++;
            System.out.printf("%d Path to Exit found! On row: %d and column: %d%n", counter, row, col);
            printMaze(maze);
            return;
        }

        //mark the cell as visited
        maze[row][col] = VISITED_CELL;

        solveMaze(maze, row, col + 1); // right
        solveMaze(maze, row - 1, col); // up
        solveMaze(maze, row + 1, col); // down
        solveMaze(maze, row, col - 1); // left

        //mark the cell as unvisited when returning.
        maze[row][col] = FREE_CELL;
    }

    private static boolean hasSolutionMaze(char[][] maze, int row, int col) {
        if (isOutOfMaze(maze, row, col)) {
            return false;
        }

        if (isWall(maze, row, col)) {
            return false;
        }

        if (isVisited(maze, row, col)) {
            return false;
        }

        if (isExit(maze, row, col)) {
            System.out.printf("Exit found! On row: %d and column: %d", row, col);
            printMaze(maze);
            return true;
        }

        //mark the cell as visited
        maze[row][col] = VISITED_CELL;

        if (hasSolutionMaze(maze, row, col + 1)) {
            return true;
        }
        if (hasSolutionMaze(maze, row - 1, col)) {
            return true;
        }
        if (hasSolutionMaze(maze, row + 1, col)) {
            return true;
        }
        if (hasSolutionMaze(maze, row, col - 1)) {
            return true;
        }

        //mark the cell as unvisited when returning.
        maze[row][col] = FREE_CELL;
        return false;
    }

    private static boolean isOutOfMaze(char[][] maze, int row, int col) {
        return row >= maze.length
                || row < 0
                || col >= maze[0].length
                || col < 0;
    }

    private static boolean isWall(char[][] maze, int row, int col) {

        return maze[row][col] == WALL;
    }

    private static boolean isVisited(char[][] maze, int row, int col) {

        return maze[row][col] == VISITED_CELL;
    }

    private static boolean isExit(char[][] maze, int row, int col) {

        return maze[row][col] == EXIT;
    }

    private static void printMaze(char[][] maze) {
        for (char[] row : maze) {
            for (char cell : row) {
                System.out.print("|" + cell);
            }
            System.out.println("|");
        }
        System.out.println();
    }
}
