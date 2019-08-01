import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    //fields
    private JTextArea textArea;
    private JButton btn;

    //constructor
    public MainPanel() {
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        btn = new JButton("Click Me!");

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

    }


    //methods
}
