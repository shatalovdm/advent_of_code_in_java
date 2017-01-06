import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Day 4: Security Through Obscurity
 *
 * Challenge: http://adventofcode.com/2016/day/4
 */
public class RoomsCheck {
    private static boolean compareSets(Set<String> letters, String checkSum) {
        String[] currentLetters = letters.toArray(new String[letters.size()]);
        for (int i = 0; i < 5; i++) {
            if (!currentLetters[i].equals(String.valueOf(checkSum.charAt(i)))) return false;
        }
        return true;
    }
    // Part 1
    public static int checkRooms(String input) {
        String[] lines = input.split("\n");
        List<String> elements;
        int sectorId;
        String checkSum;

        Map <String,Integer> letters;
        Map <String,Integer> sortedLetters;
        ValueComparator bvc;

        int result = 0;

        for (String line: lines) {
            // Add elements on the line to the list
            elements = new LinkedList<String>();
            for (String elem: line.split("-|\\[|\\]")) elements.add(elem);

            sectorId = Integer.parseInt(elements.remove(elements.size()-2));
            checkSum = elements.remove(elements.size()-1);

            // Count how often each unique letter is used
            letters = new HashMap<>();
            bvc = new ValueComparator(letters);
            sortedLetters = new TreeMap<>(bvc);
            int count = 0;
            for (String elem : elements) {
                for (String letter: elem.split("")){
                    if (letters.containsKey(letter)) {
                        count = letters.get(letter);
                        letters.put(letter, ++count);
                    } else {
                        letters.put(letter, 0);
                    }
                }
            }

            // Sort values by putting them into TreeMap
            sortedLetters.putAll(letters);

            // Compare checksum and 5 most frequent letters
            if (compareSets(sortedLetters.keySet(), checkSum)) result += sectorId;
        }
        return result;
    }

    // Part 2
    public static int decrypt(String input, String roomToFind){
        String[] lines = input.split("\n");
        List<String> elements;
        int sectorId;

        for (String line: lines) {
            elements = new LinkedList<>();
            for (String elem: line.split("-|\\[|\\]")) elements.add(elem);

            sectorId = Integer.parseInt(elements.remove(elements.size()-2));
            elements.remove(elements.size()-1);

            int rotation = sectorId % 26;
            String result = "";

            // Decrypt each letter and add it to the result string
            for (String word: elements) {
                for (String letter: word.split("")) {
                    int ascii = (int) letter.charAt(0) + rotation;
                    if (ascii > 122) ascii -= 26;
                    result = result.concat(Character.toString((char) ascii));
                }
                result = result.concat(" ");
            }
            if (result.contains(roomToFind)) return sectorId;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Please provide the path to the input file: ");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        String input = new String(Files.readAllBytes(Paths.get(path)));
        System.out.println(checkRooms(input));
        System.out.println(decrypt(input, "northpole"));
    }
}

class ValueComparator implements Comparator<String> {
    Map<String, Integer> base;
    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }
    public int compare(String a, String b) {
        if (base.get(a) > base.get(b)) {
            return -1;
        } else if (base.get(a) == base.get(b)) { // Keep in alphabetical order if values are equal
            if (a.compareTo(b) < 0) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
