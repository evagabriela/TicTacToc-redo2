import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by gzamudio on 5/3/14.
 */
public class Grid {

    private ArrayList<String> positions;
    private PrintStream printStream;


    public Grid(PrintStream printStream, ArrayList<String> positions) {
        this.printStream = printStream;
        this.positions = positions;
    }

    public void drawEmptyBoard() {
        String emptyBoard = " | | \n"
                + "-----\n"
                + " | | \n"
                + "-----\n"
                + " | | \n";
        printStream.println(emptyBoard);
    }

    public void drawGameBoard() throws IOException {
        String Board = positions.get(0) + "|" + positions.get(1) + "|" + positions.get(2) + "\n"
                + "-----" + "\n"
                + positions.get(3) + "|" + positions.get(4) + "|" + positions.get(5) + "\n"
                + "-----" + "\n"
                + positions.get(6) + "|" + positions.get(7) + "|" + positions.get(8) + "\n";

        printStream.println(Board);
    }

    public void drawGridWithInput(int positionMarker, String mark) {
        positions.set(positionMarker - 1, mark);
    }

    public boolean isPositionTaken(int position) {
        return !(positions.get(position - 1).equals(" "));

    }

    public void positionTakenMessage() {
        printStream.println("Location was already taken");
    }

    public boolean isNotFull() {
        return (positions.contains(" "));
    }


    public void fullGridMessage() {
        printStream.println("Game is a draw");
    }

    public boolean threeInARow() {
        String first = "";
        String second = "";
        String third = "";

        // Horizontal Check
        for (int i = 0; i < positions.size(); i = i + 3) {
            first = positions.get(i);
            second = positions.get(i + 1);
            third = positions.get(i + 2);

            if (first.equals(second) && first.equals(third) && !first.equals(" ")) {
                return true;
            }

        }

        // Diagonal Check
        first= positions.get(0);
        second= positions.get(4);
        third= positions.get(8);

        if (first.equals(second) && first.equals(third) && !first.equals(" ")) {
            return true;

        }

        first= positions.get(2);
        third= positions.get(6);

        if (first.equals(second) && first.equals(third) && !first.equals(" ")) {
            return true;
        }

        // Vertical Check
        for (int i = 0; i < positions.size() / 3; i++) {
            first = positions.get(i);
            second = positions.get(i + 3);
            third = positions.get(i + 6);

            if (first.equals(second) && first.equals(third) && !first.equals(" ")) {
                return true;
            }

        }

        // None worked
        return false;


    }

    public void winnerMessage() {
        if (threeInARow()){
            printStream.println("Player <#> Wins!");
        }
    }
}
