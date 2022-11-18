import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public void displayBoard() {
        for (int i=0; i < size; i++) {
            for (int j=0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + " ");
                } else {
                    System.out.print("  ");
                }

                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public List<Pair> getFreeCells() {
        List<Pair> freeCells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    freeCells.add(new Pair(i, j));
                }
            }
        }
        return freeCells;
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
        if (board[row][col] == null) {
            board[row][col] = playingPiece;
            return true;
        }
        return false;
    }
}

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }
}