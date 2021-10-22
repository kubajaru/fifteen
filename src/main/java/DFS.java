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

            if (board.canMoveDown()) {
                Board newBoard = board.clone();
                newBoard.moveDown();
                if (!visited.contains(newBoard)) {
                    stack.push(newBoard);
                }
            }
            if (board.canMoveLeft()) {
                Board newBoard = board.clone();
                newBoard.moveLeft();
                if (!visited.contains(newBoard)) {
                    stack.push(newBoard);
                }
            }
            if (board.canMoveRight()) {
                Board newBoard = board.clone();
                newBoard.moveRight();
                if (!visited.contains(newBoard)) {
                    stack.push(newBoard);
                }
            }
            if (board.canMoveUp()) {
                Board newBoard = board.clone();
                newBoard.moveUp();
                if (!visited.contains(newBoard)) {
                    stack.push(newBoard);
                }
            }
        }
        return null;
    }
}
