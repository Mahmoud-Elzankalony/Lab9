import java.util.ArrayList;

public class Mode27Checker implements Modes{
    private loadFromFile loader ;
    public static  int i =0;

    public Mode27Checker() {
        this.loader = new loadFromFile();
    }

    @Override
    public void check() {
        ArrayList<Thread> threads = new ArrayList<>();
        boolean flag = true ;

        unitCheck check = new unitCheck();

        for ( i = 0 ; i< 9 ; i ++ )
        {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    if(!check.isValid(loader.getRow(i)) )
                    {
                        check .printAllsudokuDublicate(0,i) ;
                    }
                }
            }));
        }

        for ( i = 0 ; i< 9 ; i ++ )
        {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    if(!check.isValid(loader.getColumn(i)) )
                    {
                        check .printAllsudokuDublicate(1,i) ;
                    }
                }
            }));
        }

        for ( i = 0 ; i< 9 ; i ++ )
        {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    if(!check.isValid(loader.getBox(i)) )
                    {
                        check .printAllsudokuDublicate(2,i) ;
                    }
                }
            }));
        }

        for(Thread thread : threads)
            thread.start();

    }
}