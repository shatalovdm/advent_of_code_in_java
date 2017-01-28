import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Day 8: Two-Factor Authentication.
 *
 * http://adventofcode.com/2016/day/8
 */
public class Authentication {
    private static final int ROWS = 6;
    private static final int COLUMNS = 50;
    private boolean[][] screen;
    
    Authentication() {
        screen = new boolean[ROWS][COLUMNS];
    }
    // Display the current screen
    public int displayScreen() {
        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (screen[i][j]) {
                    System.out.print("# ");
                    count++;
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        return count;
    }
    // rect axb turns on all of the pixels in a rectangle at the top-left of the screen which is a wide and b tall
    public void rect(int row, int column) throws IndexOutOfBoundsException {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                screen[i][j] = true;
            }
        }
    }
    //rotate row y=A by B shifts all of the pixels in row A (0 is the top row) right by B pixels.
    // Pixels that would fall off the right end appear at the left end of the row. This algorithm takes O(n) times to run.
    public void rotateRow(int row, int steps) throws IndexOutOfBoundsException {
        if (steps > COLUMNS) steps = steps % COLUMNS;
        if (steps == 0) return;
        boolean[] newRow = new boolean[COLUMNS];
        for (int i = 0; i < steps; i++) {
            newRow[i] = screen[row][COLUMNS - steps + i];
        }
        int k = 0;
        for(int i=steps; i<COLUMNS; i++){
            newRow[i] = screen[row][k];
            k++;
        }
        System.arraycopy(newRow, 0, screen[row], 0, COLUMNS);
    }
    // rotate column x=A by B shifts all of the pixels in column A (0 is the left column) down by B pixels.
    // Pixels that would fall off the bottom appear at the top of the column. This algorithm takes O(n) times to run.
    public void rotateColumn(int column, int steps) throws IndexOutOfBoundsException {
        if (steps > ROWS) steps = steps % ROWS;
        if (steps == 0) return;
        boolean[] newColumn = new boolean[ROWS];
        for(int i = 0; i < steps; i++) {
            newColumn[i] = screen[ROWS - steps + i][column];
        }
        int k = 0;
        for(int i=steps; i<ROWS; i++){
            newColumn[i] = screen[k][column];
            k++;
        }
        for (int i = 0; i < ROWS; i++) {
            screen[i][column] = newColumn[i];
        }
    }


    public static void main(String[] args) throws IOException {
        Authentication screen = new Authentication();
        System.out.print("Please provide the path to the input file: ");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        String input = new String(Files.readAllBytes(Paths.get(path)));
        for (String line : input.split("\n")) {
            String[] words = line.split(" ");
            switch (words[0]) {
                case "rect":
                    String[] numbers = words[1].split("x");
                    screen.rect(Integer.parseInt(numbers[1]),Integer.parseInt(numbers[0]));
                    break;
                case "rotate":
                    String coordinate = words[2].split("=")[1];
                    switch (words[1]) {
                        case "row":
                            screen.rotateRow(Integer.parseInt(coordinate), Integer.parseInt(words[4]));
                            break;
                        case "column":
                            screen.rotateColumn(Integer.parseInt(coordinate), Integer.parseInt(words[4]));
                    }
            }
        }
        System.out.println(screen.displayScreen());
    }
}

