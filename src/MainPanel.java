import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    //fields
    private JTextArea textArea;

    //constructor
    public MainPanel() {
        setLayout(new BorderLayout());

        textArea = new JTextArea();

        add(new JScrollPane(textArea), BorderLayout.CENTER);

    }


    //methods
    public void appendText(String s) {
        textArea.append(s);
    }
}
