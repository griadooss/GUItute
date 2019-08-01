import javax.swing.*;

public class Main {
    //fields



    //constructor



    //methods
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });

    }
}
