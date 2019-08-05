import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener {
    //fields
    private JButton helloButton;
    private JButton goodbyeButton;

    private StringListener stringListener;


    //constructor
    public ToolBar() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        helloButton = new JButton("Hello");
        helloButton.addActionListener(this);
        goodbyeButton = new JButton("Goodbye");
        goodbyeButton.addActionListener(this);

        add(helloButton);
        add(goodbyeButton);



    }



    //methods
    public void setStringListener(StringListener listener) {
        this.stringListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton clicked = (JButton) actionEvent.getSource();
        System.out.println("a button has been pressed.");
        if (clicked == helloButton) {
            System.out.println("HELLO button was clicked.");
            if (stringListener != null) {
                stringListener.textSentFromToolbar("Hello.\n");
            }
        }
        if (clicked == goodbyeButton) {
            System.out.println("GOODBYE button was clicked.");
            if (stringListener != null) {
                stringListener.textSentFromToolbar("Goodbye.\n");
            }
        }

    }
}
