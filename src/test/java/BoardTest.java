import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BoardTest {

    @Test
    void testMoveUp() {
        List<List<Integer>> temp = new ArrayList<>();

        temp.add(new ArrayList<>());
        temp.add(new ArrayList<>());

        temp.get(0).add(1); temp.get(0).add(2);
        temp.get(1).add(0); temp.get(1).add(3);

        Board board = new Board(temp);
        board.moveUp();

        Assertions.assertEquals(board.getBoard().get(0).get(0), 0);
        Assertions.assertEquals(board.getBoard().get(1).get(0), 1);
    }

    @Test
    void testMoveDown() {
        List<List<Integer>> temp = new ArrayList<>();

        temp.add(new ArrayList<>());
        temp.add(new ArrayList<>());

        temp.get(0).add(0); temp.get(0).add(2);
        temp.get(1).add(1); temp.get(1).add(3);

        Board board = new Board(temp);
        board.moveDown();

        Assertions.assertEquals(board.getBoard().get(0).get(0), 1);
        Assertions.assertEquals(board.getBoard().get(1).get(0), 0);
    }

    @Test
    void testMoveLeft() {
        List<List<Integer>> temp = new ArrayList<>();

        temp.add(new ArrayList<>());
        temp.add(new ArrayList<>());

        temp.get(0).add(1); temp.get(0).add(0);
        temp.get(1).add(2); temp.get(1).add(3);

        Board board = new Board(temp);
        board.moveLeft();

        Assertions.assertEquals(board.getBoard().get(0).get(0), 0);
        Assertions.assertEquals(board.getBoard().get(0).get(1), 1);
    }

    @Test
    void testMoveRight() {
        List<List<Integer>> temp = new ArrayList<>();

        temp.add(new ArrayList<>());
        temp.add(new ArrayList<>());

        temp.get(0).add(0); temp.get(0).add(1);
        temp.get(1).add(2); temp.get(1).add(3);

        Board board = new Board(temp);
        board.moveRight();

        Assertions.assertEquals(board.getBoard().get(0).get(0), 1);
        Assertions.assertEquals(board.getBoard().get(0).get(1), 0);
    }

    @Test
    void testIsSolved() {
        List<List<Integer>> temp = new ArrayList<>();

        temp.add(new ArrayList<>());
        temp.add(new ArrayList<>());

        temp.get(0).add(1); temp.get(0).add(2);
        temp.get(1).add(3); temp.get(1).add(0);

        Board board = new Board(temp);
        Assertions.assertTrue(board.isSolved());
    }

    @Test
    void testIsNotSolved() {
        List<List<Integer>> temp = new ArrayList<>();

        temp.add(new ArrayList<>());
        temp.add(new ArrayList<>());

        temp.get(0).add(2); temp.get(0).add(2);
        temp.get(1).add(0); temp.get(1).add(3);

        Board board = new Board(temp);
        Assertions.assertFalse(board.isSolved());
    }

    @Test
    void testIsNotSolvedZeroCorrect() {
        List<List<Integer>> temp = new ArrayList<>();

        temp.add(new ArrayList<>());
        temp.add(new ArrayList<>());

        temp.get(0).add(2); temp.get(0).add(1);
        temp.get(1).add(3); temp.get(1).add(0);

        Board board = new Board(temp);
        Assertions.assertFalse(board.isSolved());
    }

}