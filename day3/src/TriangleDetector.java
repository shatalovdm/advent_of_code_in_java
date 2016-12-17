import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Day 3: Squares With Three Sides
 *
 * Challenge: http://adventofcode.com/2016/day/3
 */
public class TriangleDetector {

    private static boolean isTriangle (String[] items) {
        int[] sides = new int[3];
        for (int i = 0; i < items.length; i++) {
            sides[i] = Integer.parseInt(items[i]);
        }
        if (sides[0] + sides[1] > sides[2]) {
            if (sides[1] + sides[2] > sides[0]) {
                if (sides[0] + sides[2] > sides[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    // This method counts the number of triangles when triangles are specified in lines
    public static int detectTriangles1 (String input) {
        String[] items;
        int count = 0;
        for (String line : input.split("\n")) {
            items = line.split("\\s+");
            if (isTriangle(items)) {
                count +=1;
            }
        }
        return count;
    }
    // This method counts the number of triangles when triangles are specified in groups of three vertically
    public static int detectTriangles2 (String input) {
        String[] lines = input.split("\n");
        String[][] triangles;
        int count = 0;
        String[] line;

        for (int i = 0; i < lines.length; i += 3) {
            // Work with three lines and get sides for three possible triangles at once
            triangles = new String[3][3];
            for (int j = 0; j < 3; j++) {
                line = lines[i + j].split("\\s+");
                for (int k = 0; k < line.length; k++) {
                    triangles[k][j] = line[k];
                }
            }
            // Check if they are really triangles
            for (String[] triangle: triangles) {
                if (isTriangle(triangle)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Please provide the path to the input file: ");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        String input = new String(Files.readAllBytes(Paths.get(path)));
        System.out.println(detectTriangles1(input));
        System.out.println(detectTriangles2(input));
    }
}
