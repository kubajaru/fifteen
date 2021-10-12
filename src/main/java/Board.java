import java.util.List;

public class Board {

    private final List<List<Integer>> board;
    private int zeroFieldR;
    private int zeroFieldC;
    private String steps = "";


    public Board(List<List<Integer>> board) {
        this.board = board;
        getZeroCords();
    }

    private void getZeroCords() {
        for (int r = 0; r < this.board.size(); r++) {
            for (int c = 0; c < this.board.get(r).size(); c++) {
                if (this.board.get(r).get(c) == 0) {
                    this.zeroFieldR = r;
                    this.zeroFieldC = c;
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

    public void moveDown() {
        int downValue = getValue(this.zeroFieldR + 1, this.zeroFieldC);
        setValue(this.zeroFieldR + 1, this.zeroFieldC, 0);
        setValue(this.zeroFieldR, this.zeroFieldC, downValue);
        this.zeroFieldR = this.zeroFieldR + 1;
        this.steps = this.steps.concat("D ");
    }

    public void moveLeft() {
        int leftValue = getValue(this.zeroFieldR, this.zeroFieldC - 1);
        setValue(this.zeroFieldR, this.zeroFieldC - 1, 0);
        setValue(this.zeroFieldR, this.zeroFieldC, leftValue);
        this.zeroFieldC = this.zeroFieldC - 1;
        this.steps = this.steps.concat("L ");
    }

    public void moveRight() {
        int rightValue = getValue(this.zeroFieldR, this.zeroFieldC + 1);
        setValue(this.zeroFieldR, this.zeroFieldC + 1, 0);
        setValue(this.zeroFieldR, this.zeroFieldC, rightValue);
        this.zeroFieldC = this.zeroFieldC + 1;
        this.steps = this.steps.concat("R ");
    }
}


