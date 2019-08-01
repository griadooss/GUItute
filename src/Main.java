import javax.swing.*;

public class Main {
    //fields



    //constructor



    //methods
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Hello World");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(600,500);
                frame.setVisible(true);

            }
        });

    }
}
