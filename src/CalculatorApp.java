import gui.MainGUI;

import java.io.IOException;
import java.util.logging.*;

public class CalculatorApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Logger logger = Logger.getLogger(CalculatorApp.class.getName());

        FileHandler fh = new FileHandler("log.log");
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        MainGUI.MainGUI(logger);
    }
}
