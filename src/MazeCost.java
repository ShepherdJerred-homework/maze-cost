// Maze Cost
// Jerred Shepherd
// Time complexity: O(N)

import java.io.*;
import java.util.Scanner;

public class MazeCost {
    private static final int PATH_COST = 10;
    private static final int HEDGE_COST = 50;
    private static final int DECORATION_COST = 500;
    private static final char PATH_CHAR = '-';
    private static final char HEDGE_CHAR = 'X';
    private static final char DECORATION_CHAR = '+';

    public static void main(String[] args) throws IOException {
        File inputFile = new File("mazecost.in.txt");
        File outputFile = new File("mazecost.out.txt");

        Scanner scanner = new Scanner(inputFile);
        PrintWriter printWriter = new PrintWriter(outputFile);

        String input = scanner.nextLine();

        int numberOfMazes = Integer.valueOf(input);

        for (int i = 0; i < numberOfMazes; i++) {
            int totalCost = 0;
            input = scanner.nextLine();
            String[] mazeDimensions = input.split(" ");
            int rows = Integer.valueOf(mazeDimensions[0]);
            int columns = Integer.valueOf(mazeDimensions[1]);

            for (int row = 0; row < rows; row++) {
                input = scanner.nextLine();
                char[] rowChars = input.toCharArray();
                for (char c : rowChars) {
                    int segmentCost;
                    if (c == PATH_CHAR) {
                        segmentCost = PATH_COST;
                    } else if (c == HEDGE_CHAR) {
                        segmentCost = HEDGE_COST;
                    } else if (c == DECORATION_CHAR) {
                        segmentCost = DECORATION_COST;
                    } else {
                        throw new RuntimeException("Invalid character read: " + c);
                    }
                    totalCost += segmentCost;
                }
            }

            System.out.println(totalCost);
            printWriter.println(totalCost);
        }
        printWriter.close();
    }
}
