import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {
    //fields
    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton okBtn;

    private FormListener formListener;

    //constructor
    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        System.out.println(dim);

        nameLabel = new JLabel("Name:");
        occupationLabel = new JLabel("Occupation:");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        okBtn = new JButton("OKay");

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(0,10,5,10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints(); //has a whole bunch of fields which u must first initialize.


        //////////////// First Row ////////////////////////////////////////////////
        gc.weightx = 1; //for a particular cell weight controls how much space it takes up with regard to other cells
        gc.weighty = 0.1; //the abs value is not import .. what is s how the value compares to values given to other cells

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE; //tells components whether to take all the space in a cell or not.
        //important to set these at the start because if left out tend to get problems later.
        gc.anchor = GridBagConstraints.LINE_END; //specifies which side of the cell the control sticks to.
        gc.insets = new Insets(0,0,0,5);
        add(nameLabel, gc);

        gc.gridx = 1; //going from Left to Right
        gc.gridy = 0; //on the same line
        gc.anchor = GridBagConstraints.LINE_START; //specifies which side of the cell the control sticks to.
        gc.insets = new Insets(0,0,0,0);
        add(nameField, gc);

        //////////////// Second Row ////////////////////////////////////////////////
        gc.weightx = 1; //for a particular cell weight controls how much space it takes up with regard to other cells
        gc.weighty = 0.1; //the abs value is not import .. what is s how the value compares to values given to other cells

        gc.gridy = 1;//move down to the next row
        gc.gridx = 0;//reset position to the first column
        gc.anchor = GridBagConstraints.LINE_END; //specifies which side of the cell the control sticks to.
        gc.insets = new Insets(0,0,0,5);
        add(occupationLabel, gc);

        gc.gridy = 1;//stay on the same row (the second one)
        gc.gridx = 1;//move to the next column position .. col two
        gc.anchor = GridBagConstraints.LINE_START; //specifies which side of the cell the control sticks to.
        gc.insets = new Insets(0,0,0,0);
        add(occupationField, gc);

        //////////////// Third Row ////////////////////////////////////////////////
        gc.weightx = 1; //for a particular cell weight controls how much space it takes up with regard to other cells
        gc.weighty = 2.0; //the abs value is not import .. what is s how the value compares to values given to other cells

        gc.gridy = 2;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START; //specifies which side of the cell the control sticks to.
        add(okBtn, gc);

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("form button pressed\n");
                String name = nameField.getText();
                String occupation = occupationField.getText();

                FormEvent ev = new FormEvent(this, name, occupation);

                System.out.println(ev.getName() + " " + ev.getOccupation() + "\n");

                if (formListener != null) {
                    formListener.formEventOccurred(ev);
                }
            }
        });




    }


    //methods
    public void setFormListener(FormListener listener){
        this.formListener = listener;
    }
}
