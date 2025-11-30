import java.io.IOException;
import java.nio.file.Paths;


import static java.nio.file.Files.readAllLines;

public class loadFromFile
{
    private final String filename = "test2_invalid.txt" ;
    private int[][] content ;

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
                
            }
            
        }
        this.content = sudokuBoard;
        return sudokuBoard;
    }

    public int[] getRow ( int index )
    {
        return this.content[index] ;
    }
    public int[] getColumn ( int index )
    {
        int [] column = new int [9] ;
        for ( int i = 0 ; i < 9 ; i++ )
        {
            column[i] = this.content[i][index] ;
        }
        return column ;
    }
    public int[] getBox ( int index )
    {
        int [] box = new int [9] ;
        int rowStart = ( index / 3 ) * 3 ;
        int colStart = ( index % 3 ) * 3 ;
        int count = 0 ;
        for ( int i = rowStart ; i < rowStart + 3 ; i++ )
        {
            for ( int j = colStart ; j < colStart + 3 ; j++ )
            {
                box[count] = this.content[i][j] ;
                count++ ;
            }
        } 
        return box ;
    }
}