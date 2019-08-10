import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    //fields
    private MainPanel mainPanel;
    private ToolBar toolBar;
    private FormPanel formPanel;
    private JButton btn;


    //constructor
    public MainFrame() {
        super("MySuperFrame");
        setLayout(new BorderLayout());

        btn = new JButton("Click Me!");
        add(btn, BorderLayout.SOUTH);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainPanel.appendText("The ClickMe button has been pressed.\n");

            }
        });
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

        formPanel = new FormPanel();
        add(formPanel, BorderLayout.WEST);
        formPanel.setFormListener(new FormListener() {
            @Override
            public void formEventOccurred(FormEvent event) {
                mainPanel.appendText(event.getName() + ": " + event.getOccupation() + "\n");
            }
        });


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
    }


    //methods
}
