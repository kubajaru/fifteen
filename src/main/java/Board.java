import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Board {

    private final int[][] board;
    private int zeroFieldR;
    private int zeroFieldC;
    private List<Integer> steps = new ArrayList<>();

    public String getSteps() {
        String steps = "";
        for (Integer step:
             this.steps) {
            if (step == 1) {
                steps = steps.concat("U ");
            } else if (step == 2) {
                steps = steps.concat("D ");
            } else if (step == 3) {
                steps = steps.concat("L ");
            }else if (step == 4) {
                steps = steps.concat("R ");
            }
        }
        return steps;
    }

    public void setSteps(List<Integer> steps) {
        this.steps = steps;
    }

    public Board(int[][] board) {
        this.board = board;
        getZeroCords();
    }

    public void printBoard() {
        for (int r = 0; r < this.board.length; r++) {
            for (int c = 0; c < this.board[0].length; c++) {
                if(this.board[r][c] <10)
                    System.out.print(this.board[r][c] + "  ");
                else
                System.out.print(this.board[r][c] + " ");
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
                if ( r != this.board.length - 1 & c != this.board[0].length - 1 & this.board[r][c] != value) {
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
        //this.steps.add(1);
    }

    public boolean canMoveUp(){
        return zeroFieldR > 0;
    }

    public void moveDown() {
        int downValue = getValue(this.zeroFieldR + 1, this.zeroFieldC);
        setValue(this.zeroFieldR + 1, this.zeroFieldC, 0);
        setValue(this.zeroFieldR, this.zeroFieldC, downValue);
        this.zeroFieldR = this.zeroFieldR + 1;
        //this.steps.add(2);
    }

    public boolean canMoveDown() {
        return zeroFieldR < this.board.length - 1;
    }

    public void moveLeft() {
        int leftValue = getValue(this.zeroFieldR, this.zeroFieldC - 1);
        setValue(this.zeroFieldR, this.zeroFieldC - 1, 0);
        setValue(this.zeroFieldR, this.zeroFieldC, leftValue);
        this.zeroFieldC = this.zeroFieldC - 1;
        //this.steps.add(3);
    }

    public boolean canMoveLeft(){
        return zeroFieldC > 0;
    }

    public void moveRight() {
        int rightValue = getValue(this.zeroFieldR, this.zeroFieldC + 1);
        setValue(this.zeroFieldR, this.zeroFieldC + 1, 0);
        setValue(this.zeroFieldR, this.zeroFieldC, rightValue);
        this.zeroFieldC = this.zeroFieldC + 1;
        //this.steps.add(4);
    }

    public boolean canMoveRight(){
        return zeroFieldC < this.board[0].length - 1;
    }

    @Override
    protected Board clone() {
        int[][] temp = new int[this.board.length][this.board[0].length];
        for (int r = 0; r < this.board.length; r++) {
            for (int c = 0; c < this.board[0].length; c++) {
                temp[r][c] = this.board[r][c];
            }
        }
        Board clonedBoard = new Board(temp);
        clonedBoard.setSteps(this.steps);
        return clonedBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board1 = (Board) o;
        return zeroFieldR == board1.zeroFieldR && zeroFieldC == board1.zeroFieldC && Arrays.deepEquals(board, board1.board) && steps.equals(board1.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.deepHashCode(board), zeroFieldR, zeroFieldC, steps);
    }
}


