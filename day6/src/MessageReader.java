import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Day 6: Signals and Noise
 *
 * http://adventofcode.com/2016/day/6
 */
public class MessageReader {
    public static String[] readMessage(String messages) {

        // Store occurrences of letters in the list of hashmaps representing each column
        List<Map<String, Integer>> letters = new ArrayList<>();
        int n = messages.split("\n")[0].length();
        for (int i = 0; i < n; i++) {
            letters.add(i, new HashMap<>());
        }
        Map<String, Integer> current;
        for (String message : messages.split("\n")) {
            int index = 0;
            for (String letter : message.split("")) {
                current = letters.get(index);
                if (current.containsKey(letter)) {
                    int count = current.get(letter);
                    current.put(letter, ++count);
                } else {
                    current.put(letter, 0);
                }
                letters.set(index, current);
                index++;
            }
        }

        // Sort values by putting them into TreeMap and comparing occurrences using class ValueComparator from day4
        ValueComparator bvc;
        Map<String, Integer> sortedLetters;
        String result_max = "";
        String result_min = "";
        for (Map<String, Integer> letter : letters) {
            bvc = new ValueComparator(letter);
            sortedLetters = new TreeMap<>(bvc);
            sortedLetters.putAll(letter);
            Object[] keys = sortedLetters.keySet().toArray();
            result_max += keys[0];
            result_min += keys[keys.length-1];
        }
        return new String[]{result_max, result_min};
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Please provide the path to the input file: ");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        String input = new String(Files.readAllBytes(Paths.get(path)));
        String[] result = readMessage(input);
        System.out.println("Part 1: " + result[0]);
        System.out.println("Part 2: " + result[1]);
    }
}

