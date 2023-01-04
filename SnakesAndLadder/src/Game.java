import java.util.*;

public class Game {
    Deque<Player> players;
    Board gameBoard;
    Dice dice;
    Player winner;

    public Game() {
        setupBoard();
    }

    private void setupBoard() {
        gameBoard = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        players = new LinkedList<>();
        Player p1 = new Player("p1", 0);
        Player p2 = new Player("p2", 0);

        players.add(p1);
        players.add(p2);
    }

    public void start() {

        while (winner == null) {
            Player player = findPlayer();
            System.out.println("Player ID: " + player.id + ", Current Position: " + player.position);

            int diceValue = dice.rollDice();
            System.out.println("Dice Rolled: " + diceValue);

            int playerNewPosition = player.position + diceValue;
            playerNewPosition = jumpCheck(playerNewPosition);
            player.position = playerNewPosition;

            if (playerNewPosition >= gameBoard.cells.length * gameBoard.cells.length - 1) {
                winner = player;
            }

            System.out.println("Player ID: " + player.id + ", New Position: " + player.position);
        }

        System.out.println("Winner: " + winner.id);
    }

    private int jumpCheck(int playerNewPosition) {
        if (playerNewPosition >= gameBoard.cells.length * gameBoard.cells.length - 1) {
            return playerNewPosition;
        }

        Cell cell = gameBoard.getCell(playerNewPosition);

        if (cell.jump != null && cell.jump.start == playerNewPosition) {
            System.out.println("Jump Done by: " + ((cell.jump.start < cell.jump.end) ? "ladder" : "snake"));
            System.out.println("Jump, Start= " + cell.jump.start + ", End=" + cell.jump.end);
            return cell.jump.end;
        }

        return playerNewPosition;
    }

    private Player findPlayer() {
        Player player = players.removeFirst();
        players.addLast(player);

        return player;
    }

}
