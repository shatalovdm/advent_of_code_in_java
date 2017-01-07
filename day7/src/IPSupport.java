import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Day 7: Internet Protocol Version 7
 *
 * http://adventofcode.com/2016/day/7
 */
public class IPSupport {
    // Check if provided annotation has ABBA
    private static boolean isTLS(String annotation) {
        for (int i = 0; i + 4 <= annotation.length(); i++) {
            String a = annotation.substring(i, i + 2);
            String b = annotation.substring(i + 2, i + 4);
            if (a.compareTo(b) == 0) continue;
            if (a.compareTo(new StringBuilder(b).reverse().toString()) == 0) return true;
        }
        return false;
    }

    public static int supportTLS(String ips) {
        int count = 0;
        for (String ip: ips.split("\n")) {
            boolean isTLC = false;
            boolean inBrackets = false;
            String[] annotations = ip.split("(\\[|\\])+");
            for (int i = 0; i < annotations.length; i++) {
                if (isTLS(annotations[i])) {
                    if (i % 2 != 0) { inBrackets = true; } else { isTLC = true; }
                }
            }
            if (isTLC && !inBrackets) count += 1;
        }
        return count;
    }

    // Find all the possible accessors in the annotation
    private static List<String> getSSL(String annotation) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i + 3 <= annotation.length(); i++) {
            if (annotation.charAt(i) == annotation.charAt(i+2) && annotation.charAt(i) != annotation.charAt(i + 1)) result.add(annotation.substring(i,i+3));
        }
        return result;
    }

    public static int supportSSL(String ips) {
        int count = 0;
        List<String> supernetSequence;
        List<String> hypernetSequence;
        for (String ip: ips.split("\n")) {
            supernetSequence = new LinkedList<>();
            hypernetSequence = new LinkedList<>();
            String[] annotations = ip.split("(\\[|\\])+");
            // Find all supernet and hypernet sequences
            for (int i = 0; i < annotations.length; i++) {
                if (i % 2 == 0) { hypernetSequence.addAll(getSSL(annotations[i])); } else { supernetSequence.addAll(getSSL(annotations[i])); }
            }
            // Check if ABA corresponds to any BAB
            for (String element: supernetSequence) {
                if (hypernetSequence.contains(element.charAt(1) + element.substring(0,2))) {
                    count += 1;
                    break;
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
        System.out.printf("There are %d IPs that support TLS.\n", supportTLS(input));
        System.out.printf("There are %d IPs that support SSL.", supportSSL(input));
    }
}
