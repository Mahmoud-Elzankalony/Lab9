import java.io.IOException;

public  class Mode0Checker  {

   private loadFromFile loader = new loadFromFile();
   
    public Mode0Checker() throws IOException {
         loader.getContent() ;
        
    }
    

    public boolean checkMode0() {
        boolean flag = true ;
        unitCheck check = new unitCheck();

        for ( int i = 0 ; i < 9 ; i ++ )
        {
            if(!check.isValid(loader.getRow(i)) )
            {
                check .func(0,i) ;
                flag = false ;
            }
            
            
        }
        
        for ( int i = 0 ; i < 9 ; i ++ )
        {
            if(!check.isValid(loader.getColumn(i)) )
            {
                check.func(1,i) ;
                flag = false ;
            }
           
        }
        for ( int i = 0 ; i < 9 ; i ++ )
        {
            if(!check.isValid(loader.getBox(i)) )
            {
                check.func(2,i) ;
                flag = false ;
            }
        }
        return flag ;
    }



  
    
}
