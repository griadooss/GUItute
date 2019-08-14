import java.util.EventObject;

public class FormEvent extends EventObject {
    //fields
    private String name;
    private String occupation;
    private int ageCategory;



    //constructor
    public FormEvent(Object source, String name, String occupation, int ageCat) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCat;
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

    public int getAgeCategory() {
        return ageCategory;
    }
}
