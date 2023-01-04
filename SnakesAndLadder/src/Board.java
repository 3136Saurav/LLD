import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    public Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        setUpBoard(boardSize);
        addSnakesAndLadders(numberOfSnakes, numberOfLadders);
    }

    private void setUpBoard(int boardSize) {
        cells = new Cell[boardSize][boardSize];

        for (int i=0; i < boardSize; i++) {
            for (int j=0; j < boardSize; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    private void addSnakesAndLadders(int numberOfSnakes, int numberOfLadders) {
        while (numberOfSnakes-- > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);

            if (snakeHead <= snakeTail) {
                continue;
            }

            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;

            Cell cell = getCell(snakeHead);
            cell.jump = snakeObj;
        }

        while (numberOfLadders-- > 0) {
            int ladderHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if (ladderHead >= ladderTail) {
                continue;
            }

            Jump ladderObj = new Jump();
            ladderObj.start = ladderHead;
            ladderObj.end = ladderTail;

            Cell cell = getCell(ladderHead);
            cell.jump = ladderObj;
        }
    }

    public Cell getCell(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardCol = playerPosition % cells.length;
        return cells[boardRow][boardCol];
    }


}