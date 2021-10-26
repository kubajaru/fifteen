
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter number of rows and columns:");
        Scanner scan = new Scanner(System.in);
        String rowsAndColumns = scan.nextLine();

        String[] splitRowsAndColumns = rowsAndColumns.split(" ");

        int rows = Integer.parseInt(splitRowsAndColumns[0]);
        int columns = Integer.parseInt(splitRowsAndColumns[1]);
        int[][] temp = new int[rows][columns];

        System.out.println("Filling the table...");

        for (int i = 0; i < rows; i++) {
            temp[i] = getRow(columns);
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
                solvedBoard.printBoard();
                System.out.println(solvedBoard.getSteps());
            }
            case "2" -> {
                System.out.println("DFS");
                DFS dfsSolver = new DFS();
                Board solvedBoard1 = dfsSolver.solveBoard(board);
                solvedBoard1.printBoard();
                System.out.println(solvedBoard1.getSteps());
            }
            default -> System.out.println("Incorrect choice!");
        }
    }

    private static int[] getRow(int columns) {
        Scanner scan = new Scanner(System.in);
        String row = scan.nextLine();
        String[] splitNumbers;
        splitNumbers = row.split(" ");
        int[] column = new int[columns];
        for (int i = 0; i < splitNumbers.length; i++) {
            column[i] = Integer.parseInt(splitNumbers[i]);
        }
        return column;
    }
}
