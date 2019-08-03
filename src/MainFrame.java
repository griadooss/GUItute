import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //fields
    private MainPanel mainPanel;
    private ToolBar toolBar;


    //constructor
    public MainFrame() {
        super("MySuperFrame");
        setLayout(new BorderLayout());

        mainPanel = new MainPanel();
        add(mainPanel, BorderLayout.CENTER);
        toolBar = new ToolBar();
        toolBar.setStringListener(new StringListener() {
            @Override
            public void textSentFromToolbar(String s) {
                mainPanel.appendText(s);
            }
        });
        add(toolBar, BorderLayout.NORTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
    }


    //methods
}
