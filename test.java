import java.io.IOException;
import java.util.Scanner;

public class test
{
    public  static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        String mode = scan.next();
        Modes checker =  Factory.getmode(mode);
           checker.check() ;
           if(unitCheck.isCheckValidity()==true)
               System.out.println("Valid");
    }
}