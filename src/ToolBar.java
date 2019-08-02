import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener {
    //fields
    private JButton helloButton;
    private JButton goodbyeButton;


    //constructor
    public ToolBar() {
        setLayout(new FlowLayout(FlowLayout.RIGHT));

        helloButton = new JButton("Hello");
        helloButton.addActionListener(this);
        goodbyeButton = new JButton("Goodbye");
        goodbyeButton.addActionListener(this);

        add(helloButton);
        add(goodbyeButton);



    }



    //methods
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton clicked = (JButton) actionEvent.getSource();
        System.out.println("a button has been pressed.");
        if (clicked == helloButton) {
            System.out.println("HELLO button was clicked.");
        }
        if (clicked == goodbyeButton) {
            System.out.println("GOODBYE button was clicked.");
        }

    }
}
