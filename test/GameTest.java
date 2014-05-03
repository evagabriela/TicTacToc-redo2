import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class GameTest {
    private PrintStream out;

    @Test
    public void shouldDrawEmptyGridWhenGameStarts(){
        out = mock(PrintStream.class);
        Game game = new Game(out);
        game.start();
        verify(out).println(" | | \n"
                + "-----\n"
                + " | | \n"
                + "-----\n"
                + " | | \n");
    }

}