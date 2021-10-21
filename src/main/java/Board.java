import java.util.ArrayList;
import java.util.List;

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
        return this.board.get(0).get(0) == 1 & this.board.get(0).get(1) == 2 &
                this.board.get(1).get(0) == 3 & this.board.get(1).get(1) == 0;
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
}


