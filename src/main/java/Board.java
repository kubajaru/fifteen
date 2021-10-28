import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class Board {

    private final int[][] board;
    private int zeroFieldR;
    private int zeroFieldC;
    private LinkedList<String> steps = new LinkedList<>();

    public LinkedList<String> getSteps() {
        return this.steps;
    }

    public Board(int[][] board) {
        this.board = board;
        getZeroCords();
    }

    public void printBoard() {
        for (int[] ints : this.board) {
            for (int c = 0; c < this.board[0].length; c++) {
                if (ints[c] < 10)
                    System.out.print(ints[c] + "  ");
                else
                    System.out.print(ints[c] + " ");
            }
            System.out.println();
        }
    }

    public boolean isSolved(){
        int value = 1;
        boolean isSolved = true;
        if (this.board[this.board.length - 1][this.board[0].length - 1] != 0) return false;
        outerLoop: for (int r = 0; r < this.board.length; r++) {
            for (int c = 0; c < this.board[0].length; c++, value++) {
                if (this.board[r][c] != value & this.board[r][c] != 0) {
                    isSolved = false;
                    break outerLoop;
                }
            }
        }
        return isSolved;
    }

    private void getZeroCords() {
        fff: for (int r = 0; r < this.board.length; r++) {
            for (int c = 0; c < this.board[0].length; c++) {
                if (this.board[r][c] == 0) {
                    this.zeroFieldR = r;
                    this.zeroFieldC = c;
                    break fff;
                }
            }
        }
    }
    
    public int[][] getBoard() {
        return this.board;
    }

    private Integer getValue(int r, int c) {
        return this.board[r][c];
    }

    private void setValue(int r, int c, int value) {
        this.board[r][c] = value;
    }

    public void moveUp() {
        int upValue = getValue(this.zeroFieldR - 1, this.zeroFieldC);
        setValue(this.zeroFieldR - 1, this.zeroFieldC, 0);
        setValue(this.zeroFieldR, this.zeroFieldC, upValue);
        this.zeroFieldR = this.zeroFieldR - 1;
        steps.addLast("U ");
    }

    public boolean canMoveUp(){
        return zeroFieldR > 0;
    }

    public void moveDown() {
        int downValue = getValue(this.zeroFieldR + 1, this.zeroFieldC);
        setValue(this.zeroFieldR + 1, this.zeroFieldC, 0);
        setValue(this.zeroFieldR, this.zeroFieldC, downValue);
        this.zeroFieldR = this.zeroFieldR + 1;
        steps.addLast("D ");
    }

    public boolean canMoveDown() {
        return zeroFieldR < this.board.length - 1;
    }

    public void moveLeft() {
        int leftValue = getValue(this.zeroFieldR, this.zeroFieldC - 1);
        setValue(this.zeroFieldR, this.zeroFieldC - 1, 0);
        setValue(this.zeroFieldR, this.zeroFieldC, leftValue);
        this.zeroFieldC = this.zeroFieldC - 1;
        steps.addLast("L ");
    }

    public boolean canMoveLeft(){
        return zeroFieldC > 0;
    }

    public void moveRight() {
        int rightValue = getValue(this.zeroFieldR, this.zeroFieldC + 1);
        setValue(this.zeroFieldR, this.zeroFieldC + 1, 0);
        setValue(this.zeroFieldR, this.zeroFieldC, rightValue);
        this.zeroFieldC = this.zeroFieldC + 1;
        steps.addLast("R ");
    }

    public boolean canMoveRight(){
        return zeroFieldC < this.board[0].length - 1;
    }

    @Override
    protected Board clone() {
        int[][] temp = new int[this.board.length][this.board[0].length];
        for (int r = 0; r < this.board.length; r++) {
            System.arraycopy(this.board[r], 0, temp[r], 0, this.board[0].length);
        }
        Board board = new Board(temp);
        LinkedList<String> stepsCloned = new LinkedList<>();
        for (String str :
                this.steps) {
            stepsCloned.addLast(str);
        }
        board.steps = stepsCloned;
        return board;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board1 = (Board) o;
        return zeroFieldR == board1.zeroFieldR && zeroFieldC == board1.zeroFieldC && Arrays.deepEquals(board, board1.board);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(zeroFieldR, zeroFieldC);
        result = 31 * result + Arrays.deepHashCode(board);
        return result;
    }
}


