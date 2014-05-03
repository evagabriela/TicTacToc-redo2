import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by gzamudio on 5/3/14.
 */
public class Grid {

    private ArrayList<String> positions;
    private PrintStream printStream;
    private BufferedReader reader;


    public Grid(PrintStream printStream, ArrayList<String> positions, BufferedReader reader){
        this.printStream = printStream;
        this.positions = positions;
        this.reader = reader;
    }

    public void drawEmptyBoard() {
        String emptyBoard= " | | \n"
                         + "-----\n"
                         + " | | \n"
                         + "-----\n"
                         + " | | \n" ;
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

    public void drawGridWithInput(int positionMarker, String mark){
        positions.set(positionMarker - 1, mark);
    }



}
