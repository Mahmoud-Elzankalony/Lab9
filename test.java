import java.io.IOException;

public class test
{
    public  static void main(String[] args) throws IOException
    {
        Mode0Checker checker = new Mode0Checker() ;
        boolean flag = checker.checkMode0() ;
        if(flag)
        {
            System.out.println("Valid") ;
        }
        else
        {
            System.out.println("Invalid") ;
        }
        
    }
}