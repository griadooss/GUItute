import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FormPanel extends JPanel {
    //fields



    //constructor
    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        System.out.println(dim);

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(0,10,5,10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));


    }


    //methods
}
