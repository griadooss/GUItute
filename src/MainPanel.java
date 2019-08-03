import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    //fields
    private JTextArea textArea;
    private JButton btn;

    //constructor
    public MainPanel() {
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        btn = new JButton("Click Me!");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.append("The ClickMe button has been pressed.\n");
            }
        });

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

    }


    //methods
    public void appendText(String s) {
        textArea.append(s);
    }
}
