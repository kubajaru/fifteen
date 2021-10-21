import java.util.LinkedList;
import java.util.Queue;

public class BFS {
  private final Queue<Board> queue = new LinkedList<>();

  public Board  solveBoard(Board boardToSolve) {
      queue.add(boardToSolve);

      while (!queue.isEmpty()) {
          Board board = queue.poll();

          if (board.isSolved()) {
              return board;
          }

          if (board.canMoveUp()) {
              Board newBoard = board.clone();
              newBoard.moveUp();
              queue.add(newBoard);
          }
          if (board.canMoveDown()) {
              Board newBoard = board.clone();
              newBoard.moveDown();
              queue.add(newBoard);
          }
          if (board.canMoveLeft()) {
              Board newBoard = board.clone();
              newBoard.moveLeft();
              queue.add(newBoard);
          }
          if (board.canMoveRight()) {
              Board newBoard = board.clone();
              newBoard.moveRight();
              queue.add(newBoard);
          }
      }
      return null;
  }
}
