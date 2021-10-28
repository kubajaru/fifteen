import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BoardTest {

    @Test
    void testMoveUp() {
        int[][] temp = new int[2][2];

        temp[0][0] = 1; temp[0][1] = 2;
        temp[1][0] = 0; temp[1][1] = 3;

        Board board = new Board(temp);
        board.moveUp();

        Assertions.assertEquals(board.getBoard()[0][0], 0);
        Assertions.assertEquals(board.getBoard()[1][0], 1);
    }

    @Test
    void testCanMoveUp() {
        int[][] temp = new int[2][2];

        temp[0][0] = 0; temp[0][1] = 2;
        temp[1][0] = 1; temp[1][1] = 3;

        Board board = new Board(temp);

        Assertions.assertFalse(board.canMoveUp());
    }


    @Test
    void testMoveDown() {
        int[][] temp = new int[2][2];

        temp[0][0] = 0; temp[0][1] = 2;
        temp[1][0] = 1; temp[1][1] = 3;

        Board board = new Board(temp);
        board.moveDown();

        Assertions.assertEquals(board.getBoard()[0][0], 1);
        Assertions.assertEquals(board.getBoard()[1][0], 0);
    }

    @Test
    void testCanMoveLeft() {
        int[][] temp = new int[2][2];

        temp[0][0] = 0; temp[0][1] = 2;
        temp[1][0] = 1; temp[1][1] = 3;

        Board board = new Board(temp);

        Assertions.assertFalse(board.canMoveLeft());
    }

    @Test
    void testMoveLeft() {
        int[][] temp = new int[2][2];

        temp[0][0] = 1; temp[0][1] = 0;
        temp[1][0] = 2; temp[1][1] = 3;

        Board board = new Board(temp);
        board.moveLeft();

        Assertions.assertEquals(board.getBoard()[0][0], 0);
        Assertions.assertEquals(board.getBoard()[0][1], 1);
    }

    @Test
    void testCanMoveDown() {
        int[][] temp = new int[2][2];

        temp[0][0] = 3; temp[0][1] = 2;
        temp[1][0] = 1; temp[1][1] = 0;

        Board board = new Board(temp);

        Assertions.assertFalse(board.canMoveDown());
    }

    @Test
    void testMoveRight() {
        int[][] temp = new int[2][2];

        temp[0][0] = 0; temp[0][1] = 1;
        temp[1][0] = 2; temp[1][1] = 3;

        Board board = new Board(temp);
        board.moveRight();

        Assertions.assertEquals(board.getBoard()[0][0], 1);
        Assertions.assertEquals(board.getBoard()[0][1], 0);
    }

    @Test
    void testCanMoveRight() {
        int[][] temp = new int[2][2];

        temp[0][0] = 3; temp[0][1] = 2;
        temp[1][0] = 1; temp[1][1] = 0;

        Board board = new Board(temp);

        Assertions.assertFalse(board.canMoveRight());
    }

    @Test
    void testIsSolved() {
        int[][] temp = new int[2][2];

        temp[0][0] = 1; temp[0][1] = 2;
        temp[1][0] = 3; temp[1][1] = 0;

        Board board = new Board(temp);
        Assertions.assertTrue(board.isSolved());
    }

    @Test
    void testIsNotSolved() {
        int[][] temp = new int[2][2];

        temp[0][0] = 1; temp[0][1] = 2;
        temp[1][0] = 0; temp[1][1] = 3;

        Board board = new Board(temp);
        Assertions.assertFalse(board.isSolved());
    }

    @Test
    void testIsNotSolvedZeroCorrect() {
        int[][] temp = new int[2][2];

        temp[0][0] = 2; temp[0][1] = 1;
        temp[1][0] = 3; temp[1][1] = 0;

        Board board = new Board(temp);
        Assertions.assertFalse(board.isSolved());
    }

    @Test
    void testGetZeroCords() {
        int[][] temp = new int[2][2];

        temp[0][0] = 2; temp[0][1] = 1;
        temp[1][0] = 3; temp[1][1] = 0;

        Board board = new Board(temp);
        Assertions.assertTrue(board.canMoveUp());
        board.moveUp();
        Assertions.assertFalse(board.canMoveUp());
    }

    @Test
    void testClone() throws CloneNotSupportedException {
        int[][] temp = new int[2][2];

        temp[0][0] = 2; temp[0][1] = 1;
        temp[1][0] = 3; temp[1][1] = 0;

        Board board = new Board(temp);
        Board clonedBoard = board.clone();

        Assertions.assertNotSame(board, clonedBoard);

        for (int r = 0; r < board.getBoard().length; r++) {
            for (int c = 0; c < board.getBoard()[0].length; c++) {
                Assertions.assertEquals(board.getBoard()[r][c], clonedBoard.getBoard()[r][c]);
            }
        }
    }


}