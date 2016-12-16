import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 Day 1: No Time for a Taxicab

 Challenge: http://adventofcode.com/2016/day/1
 */

public class BlocksCounter {

    private static void visitTwice(int old_x, int old_y, int x, int y, Map<Integer, List<Integer>> visited) {
        // Find the range of coordinates to add to visited skipping the start coordinate
        int[] x_range;
        int[] y_range;
        if (old_x < x) {
            x_range = IntStream.rangeClosed(old_x + 1, x).toArray();
        } else if (old_x == x) {
            x_range = IntStream.rangeClosed(old_x, x).toArray();
        } else {
            x_range = IntStream.rangeClosed(x, old_x - 1).toArray();
        }
        if (old_y < y) {
            y_range = IntStream.rangeClosed(old_y + 1, y).toArray();
        } else if (old_y == y) {
            y_range = IntStream.rangeClosed(old_y, y).toArray();
        } else {
            y_range = IntStream.rangeClosed(y, old_y - 1).toArray();
        }
        for (int el_x : x_range) {
            for (int el_y : y_range) {
                if (visited.containsKey(el_x)) {
                    if (visited.get(el_x).contains(el_y)) System.out.printf("I was already at %d \n", Math.abs(el_x) + Math.abs(el_y));
                    visited.get(el_x).add(el_y);
                } else {
                    List<Integer> values = new ArrayList<Integer>();
                    values.add(el_y);
                    visited.put(el_x, values);
                }
            }
        }
    }

    public static int countBlocks(String list) {

        // Create a hash with separate chaining to store visited coordinates
        Map<Integer, List<Integer>> visited = new HashMap<>();

        // Add the start point to the visited coordinates
        int x = 0;
        int y = 0;
        List<Integer> values = new ArrayList<Integer>();
        values.add(y);
        visited.put(x,values);

        // Start facing north
        char pointer = 'n';

        // Keep the coordinates of the previous point
        int old_x;
        int old_y;

        // Read the instructions and make steps accordingly
        for (String direction : list.split(", ")) {
            char turn = direction.charAt(0);
            int step = Integer.parseInt(direction.substring(1));
            old_x = x;
            old_y = y;
            switch (turn) {
                case 'R':
                    switch (pointer) {
                        case 'e' :
                            y -= step;
                            pointer = 's';
                            break;
                        case 's' :
                            x -= step;
                            pointer = 'w';
                            break;
                        case 'w' :
                            y += step;
                            pointer = 'n';
                            break;
                        case 'n' :
                            x += step;
                            pointer = 'e';
                            break;
                    }
                    break;
                case 'L':
                    switch (pointer) {
                        case 'w' :
                            y -= step;
                            pointer = 's';
                            break;
                        case 's' :
                            x += step;
                            pointer = 'e';
                            break;
                        case 'e' :
                            y += step;
                            pointer = 'n';
                            break;
                        case 'n' :
                            x -= step;
                            pointer = 'w';
                            break;
                    }
                    break;
            }
            visitTwice(old_x, old_y, x, y, visited);
        }
        return Math.abs(x) + Math.abs(y);

    }

    // Find the answer for the challenge
    public static void main(String[] args) {
        System.out.println(countBlocks("R4, R3, R5, L3, L5, R2, L2, R5, L2, R5, R5, R5, R1, R3, L2, L2, L1, R5, L3, R1, L2, R1, L3, L5, L1, R3, L4, R2, R4, L3, L1, R4, L4, R3, L5, L3, R188, R4, L1, R48, L5, R4, R71, R3, L2, R188, L3, R2, L3, R3, L5, L1, R1, L2, L4, L2, R5, L3, R3, R3, R4, L3, L4, R5, L4, L4, R3, R4, L4, R1, L3, L1, L1, R4, R1, L4, R1, L1, L3, R2, L2, R2, L1, R5, R3, R4, L5, R2, R5, L5, R1, R2, L1, L3, R3, R1, R3, L4, R4, L4, L1, R1, L2, L2, L4, R1, L3, R4, L2, R3, L1, L5, R4, R5, R2, R5, R1, R5, R1, R3, L3, L2, L2, L5, R2, L2, R5, R5, L2, R3, L5, R5, L2, R4, R2, L1, R3, L5, R3, R2, R5, L1, R3, L2, R2, R1"));
    }
}
