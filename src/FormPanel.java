import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FormPanel extends JPanel {
    //fields
    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton okBtn;

    //constructor
    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        System.out.println(dim);

        nameLabel = new JLabel();
        occupationLabel = new JLabel();
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        okBtn = new JButton("OKay");


        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(0,10,5,10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));


    }


    //methods
}
