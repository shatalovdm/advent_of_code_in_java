import java.util.ArrayList;
import java.util.List;

/**
 * Day 2: Bathroom Security
 *
 * Challenge: http://adventofcode.com/2016/day/2
 */
public class Decoder {
    private static final String[][] KEYPAD_1 = new String[][]{{"1","2","3"},{"4","5","6"},{"7","8","9"}};
    private static final String[][] KEYPAD_2 = new String[][]{{"","","1","",""},{"","2","3","4",""},{"5","6","7","8","9"},{"","A","B","C",""},{"","","D","",""}};

    public static String decode1 (String lines) {
        // Start at 5
        int row = 1;
        int column = 1;
        String key;

        List<String> result = new ArrayList<>();
        for (String line : lines.split("\n")) {
            for (String instruction : line.split("")) {
                switch (instruction) {
                    case "U":
                        row = (row == 0) ? row : (row -= 1);
                        break;
                    case "D":
                        row = (row == 2) ? row : (row += 1);
                        break;
                    case "R":
                        column = (column == 2) ? column : (column += 1);
                        break;
                    case "L":
                        column = (column == 0) ? column : (column -= 1);
                }
            }
            key = KEYPAD_1[row][column];
            result.add(key);
        }
        return String.join("", result);
    }
    public static String decode2 (String lines) {
        int row = 2;
        int column = 0;
        List<String> result = new ArrayList<>();
        String key;
        for (String line : lines.split("\n")) {
            for (String instruction : line.split("")) {
                switch (instruction) {
                    case "U":
                        row = (row == 0 || KEYPAD_2[row - 1][column] == "") ? row : (row -= 1);
                        break;
                    case "D":
                        row = (row == 4 || KEYPAD_2[row + 1][column] == "") ? row : (row += 1);
                        break;
                    case "R":
                        column = (column == 4 || KEYPAD_2[row][column + 1] == "") ? column : (column += 1);
                        break;
                    case "L":
                        column = (column == 0 || KEYPAD_2[row][column - 1] == "") ? column : (column -= 1);
                        break;
                }
            }
            key = KEYPAD_2[row][column];
            result.add(key);
        }
        return String.join("", result);
    }

    public static void main(String[] args) {
        String input = "LDUDDRUDRRURRRRDRUUDULDLULRRLLLUDDULRDLDDLRULLDDLRUURRLDUDDDDLUULUUDDDDLLLLLULLRURDRLRLRLLURDLLDDUULUUUUDLULLRLUUDDLRDRRURRLURRLLLRRDLRUDURRLRRRLULRDLUDRDRLUDDUUULDDDDDURLDULLRDDRRUDDDDRRURRULUDDLLRRDRURDLLLLLUUUDLULURLULLDRLRRDDLUDURUDRLRURURLRRDDLDUULURULRRLLLDRURDULRDUURRRLDLDUDDRLURRDRDRRLDLRRRLRURDRLDRUDLURRUURDLDRULULURRLDLLLUURRULUDDDRLDDUDDDRRLRDUDRUUDDULRDDULDDURULUDLUDRUDDDLRRRRRDLULDRLRRRRUULDUUDRRLURDLLUUDUDDDLUUURDRUULRURULRLLDDLLUDLURRLDRLDDDLULULLURLULRDLDRDDDLRDUDUURUUULDLLRDRUDRDURUUDDLRRRRLLLUULURRURLLDDLDDD\n" +
                "DRURURLLUURRRULURRLRULLLURDULRLRRRLRUURRLRRURRRRUURRRLUDRDUDLUUDULURRLDLULURRLDURLUUDLDUDRUURDDRDLLLDDRDDLUUDRDUDDRRDLDUDRLDDDRLLDDLUDRULRLLURLDLURRDRUDUDLDLULLLRDLLRRDULLDRURRDLDRURDURDULUUURURDLUDRRURLRRLDULRRDURRDRDDULLDRRRLDRRURRRRUURDRLLLRRULLUDUDRRDDRURLULLUUDDRLDRRDUDLULUUDRDDDDLRLRULRLRLLDLLRRDDLDRDURRULLRLRRLULRULDDDRDRULDRUUDURDLLRDRURDRLRDDUDLLRUDLURURRULLUDRDRDURLLLDDDRDRURRDDRLRRRDLLDDLDURUULURULRLULRLLURLUDULDRRDDLRDLRRLRLLULLDDDRDRU\n" +
                "URUUDUDRDDRDRRRDLLUDRUDRUUUURDRRDUDUULDUDLLUDRRUDLLRDLLULULDRRDDULDRLDLDDULLDDRDDDLRLLDLLRDUUDUURLUDURDRRRRLRRLDRRUULLDLDLRDURULRURULRRDRRDDUUURDURLLDDUUDLRLDURULURRRDRRUUUDRDDLRLRRLLULUDDRRLRRRRLRDRUDDUULULRRURUURURRLRUDLRRUUURUULLULULRRDDULDRRLLLDLUDRRRLLRDLLRLDUDDRRULULUDLURLDRDRRLULLRRDRDLUURLDDURRLDRLURULDLDRDLURRDRLUUDRUULLDRDURLLDLRUDDULLLLDLDDDLURDDUDUDDRLRDDUDDURURLULLRLUDRDDUDDLDRUURLDLUUURDUULRULLDDDURULDDLLD\n" +
                "LRRLLRURUURRDLURRULDDDLURDUURLLDLRRRRULUUDDLULLDLLRDLUDUULLUDRLLDRULDDURURDUUULRUDRLLRDDDURLRDRRURDDRUDDRRULULLLDLRLULLDLLDRLLLUDLRURLDULRDDRDLDRRDLUUDDLURDLURLUDLRDLDUURLRRUULDLURULUURULLURLDDURRURDRLUULLRRLLLDDDURLURUURLLLLDLLLUDLDLRDULUULRRLUUUUDLURRURRULULULRURDDRRRRDRUDRURDUDDDDUDLURURRDRRDRUDRLDLDDDLURRRURRUDLDURDRLDLDLDDUDURLUDUUDRULLRLLUUDDUURRRUDURDRRUURLUDRRUDLUDDRUUDLULDLLDLRUUDUULLDULRRLDRUDRRDRLUUDDRUDDLLULRLULLDLDUULLDRUUDDUDLLLLDLDDLDLURLDLRUUDDUULLUDUUDRUDLRDDRDLDRUUDUDLLDUURRRLLLLRLLRLLRLUUDULLRLURDLLRUUDRULLULRDRDRRULRDLUDDURRRRURLLRDRLLDRUUULDUDDLRDRD\n" +
                "DDLRRULRDURDURULLLLRLDDRDDRLLURLRDLULUDURRLUDLDUDRDULDDULURDRURLLDRRLDURRLUULLRUUDUUDLDDLRUUDRRDDRLURDRUDRRRDRUUDDRLLUURLURUDLLRRDRDLUUDLUDURUUDDUULUURLUDLLDDULLUURDDRDLLDRLLDDDRRDLDULLURRLDLRRRLRRURUUDRLURURUULDURUDRRLUDUDLRUDDUDDRLLLULUDULRURDRLUURRRRDLLRDRURRRUURULRUDULDULULUULULLURDUDUDRLDULDRDDULRULDLURLRLDDDDDDULDRURRRRDLLRUDDRDDLUUDUDDRLLRLDLUDRUDULDDDRLLLLURURLDLUUULRRRUDLLULUUULLDLRLDLLRLRDLDULLRLUDDDRDRDDLULUUR\n";

        System.out.println(decode1(input));
        System.out.println(decode2(input));
    }
}
