import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Board {

    private final List<List<Integer>> board;
    private int zeroFieldR;
    private int zeroFieldC;
    private String steps = "";

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Board(List<List<Integer>> board) {
        this.board = board;
        getZeroCords();
    }

    public void printBoard() {
        for (int r = 0; r < this.board.size(); r++) {
            for (int c = 0; c < this.board.get(r).size(); c++) {
                if(this.board.get(r).get(c) <10)
                    System.out.print(this.board.get(r).get(c) + "  ");
                else
                System.out.print(this.board.get(r).get(c) + " ");
            }
            System.out.println();
        }
    }

    public boolean isSolved(){
        int value = 1;
        boolean isSolved = true;
        if (this.board.get(this.board.size() - 1).get(this.board.get(0).size() - 1) != 0) return false;
        outerLoop: for (int r = 0; r < this.board.size(); r++) {
            for (int c = 0; c < this.board.get(r).size(); c++, value++) {
                if ( r != this.board.size() - 1 & c != this.board.get(0).size() - 1 & this.board.get(r).get(c) != value) {
                    isSolved = false;
                    break outerLoop;
                }
            }
        }
        return isSolved;
    }

    private void getZeroCords() {
        fff: for (int r = 0; r < this.board.size(); r++) {
            for (int c = 0; c < this.board.get(r).size(); c++) {
                if (this.board.get(r).get(c) == 0) {
                    this.zeroFieldR = r;
                    this.zeroFieldC = c;
                    break fff;
                }
            }
        }
    }
    
    public List<List<Integer>> getBoard() {
        return this.board;
    }

    private Integer getValue(int r, int c) {
        return this.board.get(r).get(c);
    }

    private void setValue(int r, int c, int value) {
        this.board.get(r).set(c, value);
    }

    public void moveUp() {
        int upValue = getValue(this.zeroFieldR - 1, this.zeroFieldC);
        setValue(this.zeroFieldR - 1, this.zeroFieldC, 0);
        setValue(this.zeroFieldR, this.zeroFieldC, upValue);
        this.zeroFieldR = this.zeroFieldR - 1;
        this.steps = this.steps.concat("U ");
    }

    public boolean canMoveUp(){
        return zeroFieldR > 0;
    }

    public void moveDown() {
        int downValue = getValue(this.zeroFieldR + 1, this.zeroFieldC);
        setValue(this.zeroFieldR + 1, this.zeroFieldC, 0);
        setValue(this.zeroFieldR, this.zeroFieldC, downValue);
        this.zeroFieldR = this.zeroFieldR + 1;
        this.steps = this.steps.concat("D ");
    }

    public boolean canMoveDown() {
        return zeroFieldR < this.board.size() - 1;
    }

    public void moveLeft() {
        int leftValue = getValue(this.zeroFieldR, this.zeroFieldC - 1);
        setValue(this.zeroFieldR, this.zeroFieldC - 1, 0);
        setValue(this.zeroFieldR, this.zeroFieldC, leftValue);
        this.zeroFieldC = this.zeroFieldC - 1;
        this.steps = this.steps.concat("L ");
    }

    public boolean canMoveLeft(){
        return zeroFieldC > 0;
    }

    public void moveRight() {
        int rightValue = getValue(this.zeroFieldR, this.zeroFieldC + 1);
        setValue(this.zeroFieldR, this.zeroFieldC + 1, 0);
        setValue(this.zeroFieldR, this.zeroFieldC, rightValue);
        this.zeroFieldC = this.zeroFieldC + 1;
        this.steps = this.steps.concat("R ");
    }

    public boolean canMoveRight(){
        return zeroFieldC < this.board.get(0).size() - 1;
    }

    @Override
    protected Board clone() {
        List<List<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < this.board.size(); i++) {
            temp.add(new ArrayList<>());
        }

        for (int r = 0; r < this.board.size(); r++) {
            for (int c = 0; c < this.board.get(r).size(); c++) {
                temp.get(r).add(this.board.get(r).get(c));
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
        return zeroFieldR == board1.zeroFieldR && zeroFieldC == board1.zeroFieldC && board.equals(board1.board) && steps.equals(board1.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, zeroFieldR, zeroFieldC, steps);
    }
}


