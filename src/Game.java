import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by gzamudio on 5/3/14.
 */
public class Game {
    private PrintStream printStream;
    private Grid grid;
    private BufferedReader reader;

    public Game(PrintStream printStream, BufferedReader reader, Grid grid){
        this.printStream = printStream;
        this.reader = reader;
        this.grid = grid;
    }

    public void start() throws IOException {
       grid.drawEmptyBoard();

        printStream.println("Please enter a number between 1 and 9");
        grid.drawGameBoard();
        String input = reader.readLine();
        int inputNum = Integer.parseInt(input);

        grid.drawGridWithInput(inputNum, "X");
        grid.drawGameBoard();
        String input2 = reader.readLine();
//        int inputNum2 = Integer.parseInt(input2);
//
//        grid.drawGridWithInput(inputNum2, "O");
//        grid.drawGameBoard();
    }





}
