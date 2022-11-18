import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Game {
    Deque<Player> players;
    Board gameBoard;

    public Game() {
        setupGame();
    }

    private void setupGame() {
        players = new ArrayDeque<>();

        PlayingPiece crossPiece = new PlayingPieceX(PieceType.X);
        Player p1 = new Player("John", crossPiece);

        PlayingPiece zeroPiece = new PlayingPieceO(PieceType.O);
        Player p2 = new Player("Mike", zeroPiece);

        players.add(p1);
        players.add(p2);
        gameBoard = new Board(3);
    }

    public void start() {
        System.out.println("Let's start 😉");
        boolean noWinner = true;

        while(noWinner) {
            Player playerTurn = players.removeFirst();
            gameBoard.displayBoard();

            List<Pair> freeCells = gameBoard.getFreeCells();
            if (freeCells.isEmpty()) {
                noWinner = false;
                continue;
            }

            System.out.println("Player: " + playerTurn.getName() + "\nEnter row,column: ");
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            String[] values = input.split(",");
            int row = Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);

            boolean pieceAddedSuccessfully = gameBoard.addPiece(row, col, playerTurn.getPlayingPiece());
            if (!pieceAddedSuccessfully) {
                System.out.println("Already filled. Try again!");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);
            boolean isWinner = isThereWinner(row, col, playerTurn.getPlayingPiece().pieceType);
            if (isWinner) {
                System.out.println(playerTurn.getName() + " won the game 🍕");
                return;
            }
        }

        System.out.println("Tie");
        return;
    }

    private boolean isThereWinner(int row, int col, PieceType pieceType) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean leftDiagonal = true;
        boolean rightDiagonal = true;

        for (int j=0; j < gameBoard.size; j++) {
            if (gameBoard.board[row][j] == null || gameBoard.board[row][j].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        for (int i=0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][col] == null || gameBoard.board[i][col].pieceType != pieceType) {
                colMatch = false;
            }
        }

        for (int i=0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][i] == null || gameBoard.board[i][i].pieceType != pieceType) {
                leftDiagonal = false;
            }
        }

        for (int i=0, j= gameBoard.size-1; i < gameBoard.size; i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                rightDiagonal = false;
            }
        }
        return rowMatch || colMatch || leftDiagonal || rightDiagonal;
    }


}
