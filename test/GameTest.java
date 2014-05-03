import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class GameTest {
    private PrintStream out;
    private Game game;
    private BufferedReader reader;
    private Grid grid;

    @Test
    public void shouldDrawEmptyGridWhenGameStarts() throws IOException {
        out = mock(PrintStream.class);
        Game game = new Game(out);
        game.start();
        verify(out).println(" | | \n"
                + "-----\n"
                + " | | \n"
                + "-----\n"
                + " | | \n");
    }

    @Test
    public void shouldPromptUserToEnterAPosition(){
        out = mock(PrintStream.class);
        Game game = new Game(out);
        game.start();
        verify(out).println("Please enter a number between 1 and 9");
    }

    @Test
    public void shouldRedrawBoardWithUserPositionInput() throws IOException {
        out = mock(PrintStream.class);
        grid = mock(Grid.class);
        reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("1");
        Game game = new Game(out);
        game.start();
        verify(grid).drawGrid(1, "X");
    }

}