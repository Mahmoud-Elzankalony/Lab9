import java.io.IOException;
import java.util.Locale;

public class Factory {
    public static  Modes getmode(String mode) throws IOException {
        if(mode==null || mode.isEmpty())
            return  null;
        switch (mode.toUpperCase())
        {
            case "MODE0" :
                try {
                    return new Mode0Checker();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            case "MODE27" :
                try {
                    return new Mode0Checker();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            case "MODE3" :
                try {
                    return new Mode3Checker();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            default:
                return  null;
        }

    }
}
