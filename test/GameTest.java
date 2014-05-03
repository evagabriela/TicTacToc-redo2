import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class GameTest {
    private PrintStream out;
    private Game game;

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

//    Make a move
//Prompt player 1 to enter a number between 1 and 9 to indicate where they wish to move.
// Redraw the board with an ‘X’ in that location. It doesn’t matter what happens if they enter anything besides a number from 1 to 9.
    @Test
    public void shouldPromptUserToEnterAPosition(){
        out = mock(PrintStream.class);
        Game game = new Game(out);
        game.start();
        verify(out).println("Please enter a number between 1 and 9");
    }

}