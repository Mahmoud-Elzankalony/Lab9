import java.io.IOException;

public  class Mode0Checker implements Modes {

   private loadFromFile loader = new loadFromFile();
   
    public Mode0Checker() throws IOException {
         loader.getContent() ;
        
    }

    @Override
    public void check() {
        unitCheck check = new unitCheck();
//        unitCheck checkToprint = new unitCheck();



        for ( int i = 0 ; i < 9 ; i ++ )
        {
            if(!check.isValid(loader.getRow(i)) )
            {
                check .printAllsudokuDublicate(0,i) ;
            }
            
            
        }
        
        for ( int i = 0 ; i < 9 ; i ++ )
        {
            if(!check.isValid(loader.getColumn(i)) )
            {
                check.printAllsudokuDublicate(1,i); ;
            }
           
        }
        for ( int i = 0 ; i < 9 ; i ++ )
        {
            if(!check.isValid(loader.getBox(i)) )
            {
                check.printAllsudokuDublicate(2,i) ;
            }
        }

    }

}
