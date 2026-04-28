package model;
public class Patient {
    private String Name;
    private int age;
    private String id;

    public Patient (String name, int age, String id) {
        setName(name);
        setAge(age);
        setId(id);
    }

     public String getName() {return name;}
     public int getAge () {return age;}
     public String getId () {return id;}

  public Patient (String Name, int age String id) {
    
    public void setAge (int age) {
        if (age >= 0 && age <= 150) {
        this.age = age; 
        } else {
        throw new IllegalArgumentException ("age must be between 0 and 150");
       }
       }
        public void setName(String name) {
        if (name == null || name.trim(). isEmpty ()) {
            throw new IllegalArgumentException ("name cannot be empty");
        }
            this.name = name; 
        }
        public void setId(String id) {
        if (id == null || id.trim().isEmpty ()) {
          throw new IllegalArgumentException ("id is required");
      }
           this.id = id 
   }
       
 


 public String describe() {
    return  "name" + name + "age" + age + "Id:" + id ; 
 }
}
