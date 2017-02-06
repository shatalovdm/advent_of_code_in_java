import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Day 9: Explosives in Cyberspace
 *
 * http://adventofcode.com/2016/day/9
 */
public class Explosives {
    /**
     * The format compresses a sequence of characters. Whitespace is ignored.
     * To indicate that some sequence should be repeated, a marker is added to the file, like (10x2).
     * To decompress this marker, take the subsequent 10 characters and repeat them 2 times.
     * Then, continue reading the file after the repeated data. The marker itself is not included in the decompressed output.
     * @param input list of strings to decompress
     * @return decompressed length of the list
     */
    public int decompressV1(String[] input) {
        int result = 0;
        for (String line: input) {
            result += auxDecompressV1(line, "").length();
        }
        return result;
    }
    private String auxDecompressV1(String input, String result) {
        if (input.isEmpty()) return result;
        String[] line = input.split("\\(|\\)", 3);
        int index = 0;
        for(int i = 0; i < line.length; i++) {
            if (line[i].contains("x")) {
                String[] marker = line[i].split("x");
                String next = line[i + 1].substring(0,Integer.parseInt(marker[0]));
                result += new String(new char[Integer.parseInt(marker[1])]).replace("\0", next);
                index += line[i].length() + next.length() + 2;
                break;
            } else {
                result += line[i];
                index += line[i].length();
            }
        }
        return auxDecompressV1(input.substring(index, input.length()), result);
    }

    /**
     * In version two, the only difference is that markers within decompressed data are decompressed.
     * This, the documentation explains, provides much more substantial compression capabilities,
     * allowing many-gigabyte files to be stored in only a few kilobytes.
     * @param input list of strings to decompress
     * @return decompressed length of the list
     */
    public BigInteger decompressV2(String[] input) {
        BigInteger result = new BigInteger("0");
        for (String line: input) {
            result = result.add(BigInteger.valueOf(auxDecompressV2(line)));
        }
        return result;
    }
    private long auxDecompressV2(String input) {
        int index = 0;
        long result = input.length();
        while (index < input.length()) {
            if (input.charAt(index) == '(') {
                int boundary = index + 1;
                while (input.charAt(boundary) != ')') boundary++;
                String[] marker = input.substring(index+1,boundary).split("x");
                int repeatTimes = Integer.parseInt(marker[1]);
                int charsToTake = Integer.parseInt(marker[0]);
                result += repeatTimes * auxDecompressV2(input.substring(boundary+1, boundary+ charsToTake+1));
                result -= boundary + charsToTake - index + 1;
                index = boundary + charsToTake;
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Please provide the path to the input file: ");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        String input = new String(Files.readAllBytes(Paths.get(path)));
        String[] arrayInput = input.split("\n");
        System.out.println(new Explosives().decompressV1(arrayInput));
        System.out.println(new Explosives().decompressV2(arrayInput));
    }
}
