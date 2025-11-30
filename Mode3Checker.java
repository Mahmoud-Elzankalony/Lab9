import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class Mode3Checker {
    
    private loadFromFile loader = new loadFromFile();
    private AtomicBoolean isValid = new AtomicBoolean(true);
    
    public Mode3Checker() throws IOException {
        loader.getContent();
    }
    
    public boolean checkMode3() {
        isValid.set(true);
        
        // Create three threads for rows, columns, and boxes
        Thread rowThread = new Thread(new RowChecker());
        Thread columnThread = new Thread(new ColumnChecker());
        Thread boxThread = new Thread(new BoxChecker());
        
        rowThread.start();
        columnThread.start();
        boxThread.start();
        
        // Main thread waits for all threads to complete
        try {
            rowThread.join();
            columnThread.join();
            boxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return isValid.get();
    }
    
    // Thread for checking all rows
    private class RowChecker implements Runnable {
        @Override
        public void run() {
            unitCheck check = new unitCheck();
            for (int i = 0; i < 9; i++) {
                if (!check.isValid(loader.getRow(i))) {
                    check.func(0, i);
                    isValid.set(false);
                }
            }
        }
    }
    
    // Thread for checking all columns
    private class ColumnChecker implements Runnable {
        @Override
        public void run() {
            unitCheck check = new unitCheck();
            for (int i = 0; i < 9; i++) {
                if (!check.isValid(loader.getColumn(i))) {
                    check.func(1, i);
                    isValid.set(false);
                }
            }
        }
    }
    
    // Thread for checking all boxes
    private class BoxChecker implements Runnable {
        @Override
        public void run() {
            unitCheck check = new unitCheck();
            for (int i = 0; i < 9; i++) {
                if (!check.isValid(loader.getBox(i))) {
                    check.func(2, i);
                    isValid.set(false);
                }
            }
        }
    }
}