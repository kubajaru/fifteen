import java.util.HashSet;
import java.util.LinkedList;

public class BFS {
  private final LinkedList<Board> queue = new LinkedList<>();
  private final HashSet<Board> visited = new HashSet<>();

  public Board  solveBoard(Board boardToSolve) {
      queue.add(boardToSolve);
      visited.add(boardToSolve);

      while (!queue.isEmpty()) {
          Board board = queue.getFirst();
          queue.removeFirst();

          if (board.isSolved()) {
              System.out.println("Nodes visited: " + visited.size());
              return board;
          }

          if (board.canMoveUp()) {
              Board newBoard = board.clone();
              newBoard.moveUp();
              if (!visited.contains(newBoard))  {
                  queue.add(newBoard);
                  visited.add(newBoard);
              }

          }
          if (board.canMoveDown()) {
              Board newBoard = board.clone();
              newBoard.moveDown();
              if (!visited.contains(newBoard))  {
                  queue.add(newBoard);
                  visited.add(newBoard);
              }
          }
          if (board.canMoveLeft()) {
              Board newBoard = board.clone();
              newBoard.moveLeft();
              if (!visited.contains(newBoard))  {
                  queue.add(newBoard);
                  visited.add(newBoard);
              }
          }
          if (board.canMoveRight()) {
              Board newBoard = board.clone();
              newBoard.moveRight();
              if (!visited.contains(newBoard))  {
                  queue.add(newBoard);
                  visited.add(newBoard);
              }
          }
      }
      return null;
  }
}
