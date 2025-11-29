import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.Files.readAllLines;

public class loadFromFile
{
    private final String filename = "test1_valid.txt" ;

    public int[][] getContent() throws IOException
    {
        String[] lines = readAllLines(Paths.get(filename)).toArray(new String[0]);

        int[][] sudokuBoard = new int[9][9];

        for (int i = 0; i < lines.length; i++)
        {
            String[] line = lines[i].split(",");
            for (int j = 0; j < line.length; j++)
            {
                sudokuBoard[i][j] = Integer.parseInt(line[j]);
                System.out.print(sudokuBoard[i][j] + " ");
            }
            System.out.println();
        }
        return sudokuBoard;
    }
}