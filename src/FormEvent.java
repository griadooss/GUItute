import java.util.EventObject;

public class FormEvent extends EventObject {
    //fields
    private String name;
    private String occupation;



    //constructor
    public FormEvent(Object source, String name, String occupation) {
        super(source);
        this.name = name;
        this.occupation = occupation;
    }


    //methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
