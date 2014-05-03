import java.io.PrintStream;

/**
 * Created by gzamudio on 5/3/14.
 */
public class Game {
    private PrintStream printStream;

    public Game(PrintStream printStream){
        this.printStream = printStream;
    }

    public void start() {
        String emptyBoard = (" | | \n"
                + "-----\n"
                + " | | \n"
                + "-----\n"
                + " | | \n");
        printStream.println(emptyBoard);
        printStream.println("Please enter a number between 1 and 9");
    }


}
