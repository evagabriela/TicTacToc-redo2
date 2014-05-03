import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;


public class GameTest {
    private PrintStream out;
    private Game game;
    private BufferedReader reader;
    private Grid grid;
    private ArrayList<String> positions;
    private PrintStream printStream;

    @Test
    public void shouldDrawEmptyGridWhenGameStarts() throws IOException {
        out = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        grid = mock(Grid.class);
        Game game = new Game(out, reader, grid);
        game.start();
        verify(grid).drawEmptyBoard();
    }

    @Test
    public void shouldPromptUserToEnterAPosition() throws IOException {
        out = mock(PrintStream.class);
        grid = mock(Grid.class);
        Game game = new Game(out, reader, grid);
        game.start();
        verify(out).println("Please enter a number between 1 and 9");
    }

    @Test
    public void shouldRedrawBoardWithUserPositionOnceInput1() throws IOException {
        out = mock(PrintStream.class);
        grid = mock(Grid.class);
        reader = mock(BufferedReader.class);
        positions= new ArrayList<String>(Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " "));
        grid = new Grid(printStream, positions, reader);
        Game game = new Game(out, reader,grid);
        when(reader.readLine()).thenReturn("1");
        game.start();
        verify(grid).drawGridWithInput(1, "X");

    }
}