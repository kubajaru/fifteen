import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {
    private final LinkedList<Board> stack = new LinkedList<>();
    private final HashSet<Board> visited = new HashSet<>();

    public Board solveBoard(Board boardToSolve) {
        stack.add(boardToSolve);
        visited.add(boardToSolve);

        while (!stack.isEmpty()) {
            Board board = stack.getLast();
            stack.removeLast();

            if (board.isSolved()) {
                System.out.println("Nodes visited: " + visited.size());
                return board;
            }

            if (board.canMoveUp()) {
                Board newBoard = board.clone();
                newBoard.moveUp();
                if (!visited.contains(newBoard)) {
                    stack.add(newBoard);
                    visited.add(newBoard);
                }
            }
            if (board.canMoveDown()) {
                Board newBoard = board.clone();
                newBoard.moveDown();
                if (!visited.contains(newBoard)) {
                    stack.add(newBoard);
                    visited.add(newBoard);
                }
            }
            if (board.canMoveLeft()) {
                Board newBoard = board.clone();
                newBoard.moveLeft();
                if (!visited.contains(newBoard)) {
                    stack.add(newBoard);
                    visited.add(newBoard);
                }
            }
            if (board.canMoveRight()) {
                Board newBoard = board.clone();
                newBoard.moveRight();
                if (!visited.contains(newBoard)) {
                    stack.add(newBoard);
                    visited.add(newBoard);
                }
            }
        }
        return null;
    }
}
