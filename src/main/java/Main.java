import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter number of rows and columns:");
        Scanner scan = new Scanner(System.in);
        String rowsAndColumns = scan.nextLine();
        String [] splitRowsAndColumns;
        splitRowsAndColumns=rowsAndColumns.split(" ");
        int rows = Integer.parseInt(splitRowsAndColumns[0]);
        int columns = Integer.parseInt(splitRowsAndColumns[1]);
        List<List<Integer>> temp = new ArrayList<>();
        System.out.println("Filling the table...");
        for (int i = 0; i < rows; i++) {
            temp.add(getRow());
        }
        Board board = new Board(temp);
        board.printBoard();

        BFS solver = new BFS();
        Board solvedBoard = solver.solveBoard(board);
        solvedBoard.printBoard();
        System.out.println(solvedBoard.getSteps());

    }
    private static List<Integer> getRow() {
        Scanner scan = new Scanner(System.in);
        String row = scan.nextLine();
        String [] splitNumbers;
        splitNumbers = row.split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < splitNumbers.length; i++) {
            list.add(Integer.parseInt(splitNumbers[i]));
        }
        return list;
    }
}
