
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Enter number of rows and columns:");
        Scanner scan = new Scanner(System.in);
        String rowsAndColumns = scan.nextLine();

        String[] splitRowsAndColumns = rowsAndColumns.split(" ");

        int numberOfRows = Integer.parseInt(splitRowsAndColumns[0]);
        int numberOfColumns = Integer.parseInt(splitRowsAndColumns[1]);
        int[][] temp = new int[numberOfRows][numberOfColumns];

        System.out.println("Filling the table...");

        for (int i = 0; i < numberOfRows; i++) {
            temp[i] = getRow(numberOfColumns);
        }
        Board board = new Board(temp);
        board.printBoard();

        System.out.println("Choose the algorithm (1 - BFS, 2 - DFS): ");
        Scanner scanner = new Scanner(System.in);
        String algorithm = scanner.nextLine();

        switch (algorithm) {
            case "1" -> {
                System.out.println("BFS");
                BFS bfsSolver = new BFS();
                Board solvedBoard = bfsSolver.solveBoard(board);
                if (solvedBoard != null) {
                    System.out.println("-------------");
                    solvedBoard.printBoard();
                    System.out.println(solvedBoard.getSteps());
                } else System.out.println("No solution");

            }
            case "2" -> {
                System.out.println("DFS");
                DFS dfsSolver = new DFS();
                Board solvedBoard1 = dfsSolver.solveBoard(board);
                if (solvedBoard1 != null) {
                    System.out.println("-------------");
                    solvedBoard1.printBoard();
                    System.out.println(solvedBoard1.getSteps());
                } else System.out.println("No solution");
            }
            default -> System.out.println("Incorrect choice!");
        }
    }

    private static int[] getRow(int numberOfColumns) {
        Scanner scan = new Scanner(System.in);
        String inputRow = scan.nextLine();
        String[] splitNumbers;
        splitNumbers = inputRow.split(" ");
        int[] row = new int[numberOfColumns];
        for (int i = 0; i < splitNumbers.length; i++) {
            row[i] = Integer.parseInt(splitNumbers[i]);
        }
        return row;
    }
}
