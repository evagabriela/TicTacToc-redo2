import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

public class GridTest {
    private BufferedReader reader;
    private PrintStream out;
    private ArrayList<String> positions;
    private Game game;
    private Grid grid;
    private PrintStream printStream;


    //    Location already taken
//If either player moves into a cell that is already used, display the message, “Location already taken”
// and prompt them to try again (repeat this until they make a valid move).

    @Before

    public void setUp(){
        positions= new ArrayList<String>(Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " "));
        reader = mock(BufferedReader.class);
        out = mock(PrintStream.class);
        game = mock(Game.class);
    }

    @Test
    public void shouldReturnTrueIfPositionAlreadyTaken() throws IOException {
        when(reader.readLine()).thenReturn("1");
        Grid grid = new Grid(printStream, positions, reader);
        int location = 1;
        String marker = "X";
        grid.drawGridWithInput(location, marker);
        assertTrue(grid.isPositionTaken(location));
    }

    @Test
    public void shouldReturnFalseIfPositionIsNotTaken() throws IOException {
        when(reader.readLine()).thenReturn("1");
        Grid grid = new Grid(printStream, positions, reader);
        int location = 3;
        assertFalse(grid.isPositionTaken(location));
    }
    

//    public void shouldDisplayMessageIfUserMovesInAlreadyTakenCell() throws IOException {
//        when(reader.readLine()).thenReturn("1");
////        Grid grid = new Grid( out, positions, reader);
//        grid.isPositionTaken(1);
//        verify(out).println("Location already taken");
//    }

}