import java.util.HashSet;
import java.util.Stack;

public class DFS {
    private final Stack<Board> stack = new Stack<>();
    private final HashSet<Board> visited = new HashSet<>();

    public Board solveBoard(Board boardToSolve) {
        stack.push(boardToSolve);

        while (!stack.isEmpty()) {
            Board board = stack.pop();

            if (board.isSolved()) {
                return board;
            }

            visited.add(board);

            if (board.canMoveUp()) {
                Board newBoard = board.clone();
                newBoard.moveUp();
                System.out.println("=================");
                newBoard.printBoard();
                if (!visited.contains(newBoard)) {
                    stack.push(newBoard);
                }
            }

            if (board.canMoveDown()) {
                Board newBoard = board.clone();
                newBoard.moveDown();
                System.out.println("=================");
                newBoard.printBoard();
                if (!visited.contains(newBoard)) {
                    stack.push(newBoard);
                }
            }
            if (board.canMoveLeft()) {
                Board newBoard = board.clone();
                newBoard.moveLeft();
                System.out.println("=================");
                newBoard.printBoard();
                if (!visited.contains(newBoard)) {
                    stack.push(newBoard);
                }
            }
            if (board.canMoveRight()) {
                Board newBoard = board.clone();
                newBoard.moveRight();
                System.out.println("=================");
                newBoard.printBoard();
                if (!visited.contains(newBoard)) {
                    stack.push(newBoard);
                }
            }
        }
        return null;
    }
}
