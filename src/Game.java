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
        getUserInput();

    }


    public void getUserInput() throws IOException {

       String marker = null;
        while(grid.isNotFull()){
            String input=  reader.readLine() ;
            int inputNum = Integer.parseInt(input);

            if (inputNum % 2 == 0){
                marker = "O";
            }else {
                marker = "X";
            }

            if(grid.isPositionTaken(inputNum)){
                grid.positionTakenMessage();
                grid.drawGameBoard();
                getUserInput();
                break;
            } else {
                grid.drawGridWithInput(inputNum, marker);
                grid.drawGameBoard();

            }
        }
        grid.fullGridMessage();
    }





}
