import java.util.ArrayList;
import java.util.TreeMap;

public class unitCheck
{
    public boolean isValid (int[] numbers , int type , int index )
    {
        TreeMap<Integer,Integer> mapValues = new TreeMap<>();
        TreeMap<Integer,ArrayList<Integer>> mapLocations = new TreeMap<>();

        for ( int i = 1 ; i < 10 ; i++ )
        {
            mapValues.put( i , 0 );
            mapLocations.put( i , new ArrayList<Integer>() ) ;
        }
        int flag = 1 ;
        for ( int i = 0; i < numbers.length ; i++ )
        {
            if (mapValues.get(numbers[i]) == 0 )
            {
                mapValues.put( numbers[i], 1 );
            }
            else
            {
                mapValues.put( numbers[i], mapValues.get(numbers[i]) + 1 );
                flag = 0 ;
            }
            mapLocations.get(numbers[i]).add( i+1 );
        }
        for ( int i = 1 ; i < 10 ; i++ )
        {
            if ( mapValues.get(i) > 1 )
            {
                printPattern( type , index , i , mapLocations.get(i) );
            }
        }
        if ( flag == 1 )
        {
            return true ;
        }
        else
        {
            return false ;
        }
    }

    public void printPattern ( int type , int index , int duplicateNum , ArrayList<Integer> Locations )
    {
        String t = null ;
        switch ( type )
        {
            case 0 :
                t = "row" ;
                break;
            case 1 :
                t = "column" ;
                break;
            case 2 :
                t = "box" ;
                break;
        }

        System.out.println( t + " " + index + " " + "#" + duplicateNum + " " + Locations ); ;
    }
}
