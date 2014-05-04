import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static ArrayList<String> positions;
    private static PrintStream out;

    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        ArrayList<String> positions = new ArrayList<String>(Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " "));
        Grid grid = new Grid(out, positions);
        Game game = new Game(out, reader, grid);
	    game.start();
    }
}
