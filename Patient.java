public class Patient extends Person{
    private String village;
    private int contactNumber;

    public String getVillage() {return village;}
    public int getContactNumber() {return contactNumber;}

public Patient (String Name, int age, String id, String village, int contactNumber){
    super (Name, age, id);
    this.village = village;
    this.contactNumber = contactNumber;

}

@Override
public String describe(){
    return "name: " + name + " age: " + age + " Id: " + id + " village: " + village + " Contact Number: " + contactNumber;
}
}