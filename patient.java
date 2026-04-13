
public class Patient {
    private String Name;
    private int age;
    private String id;

     public String getName() {return name;}
     public int getAge () {return age;}
     public String getId () {return id;}

  public Patient (String Name, int age String id) {
    
    public void setAge (int age) {
        if (age >= 0 && age <= 150)
            
       } else {
        throw new IllegalArgumentException ("age must be between 0 and 150")
       }
       
       if (name == null || name.trim(). isEmpty ()) {
        throw new IllegalArgumentException ("name cannot be empty");
       }
      if (id == null || id.trim().isEmpty ()) {
        throw new IllegalArgumentException ("id is required");
      }

    this.id = id;
    this.name = Name;
    this.age = age;
  }
       
 


 public String describe() {
    return  "name" + name + "age" + age + "Id:" + id ; 
 }
}