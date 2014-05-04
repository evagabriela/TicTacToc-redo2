import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class GameTest {
    private PrintStream out;
    private Game game;
    private BufferedReader reader;
    private Grid grid;
    private ArrayList<String> positions;
    private PrintStream printStream;

    @Before
    public void setUp(){
        out = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        grid = mock(Grid.class);

    }

    @Test
    public void shouldDrawEmptyGridWhenGameStarts() throws IOException {
        when(reader.readLine()).thenReturn("1");
        Game game = new Game(out, reader, grid);
        game.start();
        verify(grid).drawEmptyBoard();
    }

    @Test
    public void shouldPromptUserToEnterAPosition() throws IOException {
        when(reader.readLine()).thenReturn("1");
        Game game = new Game(out, reader, grid);
        game.start();
        verify(out).println("Please enter a number between 1 and 9");
    }

    @Test
    public void shouldRedrawBoardWithUserPositionOnceInput1withMarkX() throws IOException {
        when(reader.readLine()).thenReturn("1");
        Game game = new Game(out, reader,grid);
        game.start();
        verify(grid).drawGridWithInput(1, "X");
    }

//    @Test
//    public void shouldRedrawBoardWithUserPositionOnceInput2() throws IOException {
//        when(reader.readLine()).thenReturn("2");
//        Game game = new Game(out, reader,grid);
//        game.start();
//        verify(grid).drawGridWithInput(2, "X");
//    }


    @Test
    public void shouldReDrawBoardWithSecondUserInput1WithMarkO() throws IOException {
        when(reader.readLine()).thenReturn("1").thenReturn("2");
        Game game = new Game (out,reader,grid);
        game.start();
        verify(grid).drawGridWithInput(1, "X");
        verify(grid).drawGridWithInput(2, "O");
    }



    //    Location already taken
//If either player moves into a cell that is already used, display the message, “Location already taken”
// and prompt them to try again (repeat this until they make a valid move).


    @Test
    public void shouldDisplayMessageIfUserMovesInAlreadyTakenCell() throws IOException {
        when(reader.readLine()).thenReturn("1");
        int position = 1;
        grid.isPositionTaken(position);
        verify(grid).drawGridWithInput(position, "X");
    }



}