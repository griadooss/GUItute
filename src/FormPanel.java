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
    private JList<AgeCategory> ageList;

    //constructor
    public FormPanel() {
        //Resize panel
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        //Instantiate fields
        nameLabel = new JLabel("Name:");
        occupationLabel = new JLabel("Occupation:");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);

        //Instantiate List Box
        ageList = new JList<AgeCategory>();
        DefaultListModel<AgeCategory> ageModel = new DefaultListModel<>();
        ageModel.addElement(new AgeCategory(0, "Under 18"));
        ageModel.addElement(new AgeCategory(1, "18 to 65"));
        ageModel.addElement(new AgeCategory(2, "Over 65"));
        ageList.setModel(ageModel);

        ageList.setPreferredSize(new Dimension(110, 68));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);

        /* Instantiate OKay Button */
        okBtn = new JButton("OKay");
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("form button pressed\n");
                String name = nameField.getText();
                String occupation = occupationField.getText();
                /*
                String ageCat = (String) ageList.getSelectedValue();
                but this will return a string! What we really need is it to return an index as that is how these list
                values would be stored in a database ..ie in a lookup table .. so before adding an extra field to the
                FormEvent we need to address this point.

                So do this. (see AgeCategory inner class below)
                */
                AgeCategory ageCat = ageList.getSelectedValue();
                System.out.println(ageCat.getId() +" " + ageCat.toString());

                FormEvent ev = new FormEvent(this, name, occupation);

                System.out.println(ev.getName() + " " + ev.getOccupation() + "\n");

                if (formListener != null) {
                    formListener.formEventOccurred(ev);
                }
            }
        });

        //Create borders around panel
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(0, 10, 5, 10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        //Set layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints(); //has a whole bunch of fields which u must first initialize.

        //Create form
        //////////////// First Row ////////////////////////////////////////////////
        gc.weightx = 1; //for a particular cell weight controls how much space it takes up with regard to other cells
        gc.weighty = 0.1; //the abs value is not import .. what is s how the value compares to values given to other cells

        //Label
        gc.gridx = 0; //first column of grid
        gc.gridy = 0; //first row of grid ... so top left hand corner
        gc.fill = GridBagConstraints.NONE; //tells components whether to take all the space in a cell or not.
        //important to set these at the start because if left out tend to get problems later.
        gc.anchor = GridBagConstraints.LINE_END; //specifies which side of the cell the control sticks to.
        gc.insets = new Insets(0, 0, 0, 5); //paints a space around the inside of the cell.
        add(nameLabel, gc);

        //Field
        gc.gridx = 1; //next column going from Left to Right
        gc.gridy = 0; //still on the first row of grid
        gc.anchor = GridBagConstraints.LINE_START; //specifies which side of the cell the control sticks to.
        gc.insets = new Insets(0, 0, 0, 0); //resets the space around the inside of the cell to nil.
        add(nameField, gc);

        //////////////// Second Row ////////////////////////////////////////////////
        gc.weightx = 1; //for a particular cell weight controls how much space it takes up with regard to other cells
        gc.weighty = 0.1; //the abs value is not import .. what is s how the value compares to values given to other cells

        //Label
        gc.gridy = 1;//move down to the second row
        gc.gridx = 0;//reset position to the first column
        gc.anchor = GridBagConstraints.LINE_END; //specifies which side of the cell the control sticks to.
        gc.insets = new Insets(0, 0, 0, 5);//paints a space around the inside of the cell.
        add(occupationLabel, gc);

        //Field
        gc.gridy = 1;//stay on the same row (the second one)
        gc.gridx = 1;//move to the next column position .. col two
        gc.anchor = GridBagConstraints.LINE_START; //specifies which side of the cell the control sticks to.
        gc.insets = new Insets(0, 0, 0, 0);//resets the space around the inside of the cell to nil.
        add(occupationField, gc);

        //////////////// Third Row ////////////////////////////////////////////////
        gc.weightx = 1; //for a particular cell weight controls how much space it takes up with regard to other cells
        gc.weighty = 0.2; //the abs value is not import .. what is s how the value compares to values given to other cells

        //List Box
        gc.gridy = 2;//move down to the second row
        gc.gridx = 1;//stay in the second column position .. col two
        gc.anchor = GridBagConstraints.LINE_START; //specifies which side of the cell the control sticks to.
        add(ageList, gc);

        //////////////// Fourth Row ////////////////////////////////////////////////
        gc.weightx = 1; //for a particular cell weight controls how much space it takes up with regard to other cells
        gc.weighty = 2.0; //the abs value is not import .. what is s how the value compares to values given to other cells

        //OK Button
        gc.gridy = 3;//move down to the third row of the grid layout
        gc.gridx = 1;//stay in the second column position .. col two
        gc.anchor = GridBagConstraints.FIRST_LINE_START; //specifies which side of the cell the control sticks to.
        add(okBtn, gc);

    }


    //methods
    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}

//to facilitate parsing an index from the list box instead of a string, make this simple inner class. Then use the class when filling the ageList box.
// Just a utility class for matching up IDs with Strings. This class is then added to the ListBox in place of strings.
class AgeCategory {
    //fields
    private int id;
    private String text;

    //constructor
    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    //methods
    @Override
    public String toString() {
        return text;
    }

    public int getId() {
        return id;
    }
}
