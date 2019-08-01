import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //fields
    private MainPanel mainPanel;


    //constructor
    public MainFrame() {
        super("MySuperFrame");
        setLayout(new BorderLayout());

        mainPanel = new MainPanel();
        add(mainPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
    }


    //methods
}
