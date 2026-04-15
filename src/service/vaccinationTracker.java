import package service;
import java.util.ArrayList;
import java.util.List;
import model.Person;
import model.VaccinationRecord;
import model.Vaccine;

public class vaccinationTracker {
     private List<Person> person;    //uses person in model for patient name, age etc
     private List <Vaccine> vaccineCatalogue;  // Uses vaccine from model to show names of vaccines in the record
     private List <VaccinationRecord> vaccinationRecords;   //Uses vaccinationRecord in model to show patient name, age and vaccination history ie vaccineAdministered, Dosage given etc

           public VaccinationTracker() {
            this.person = new ArrayList<>();   // creates the person object
            this.vaccineCatalogue = new ArrayList<>();
            this.vaccinationRecord = new ArrayList<>();

           } 
           public void registerPerson (String name, int age, String id) {
            Person newPerson = new Person(name, age, id);
            person.add(newPerson);
           }
           public Person findPersonByID(String id){
            //code to be added
           }
           public  List<Patient> getAllPatients(){
            //code to be added
           }
                  public void addVaccinationRecord (VaccinationRecord record) {
                    //code to added
                      public List<VaccinationRecord> getRecordsByPerson (String patientId) {
                        //code to be added
                      }                  }
                           public List <VaccinationRecord> getAllRecords(){
                            //code to be added
                           }
                               public void addVaccine (String name, String manufacturer) {
                                //code to be added
                               }
                                    public List <Vaccine> getAllVaccines() {
                                        //code to be added
                                    }
                                         public Vaccine findVaccineByName (String name){
                                            //code to be added
                                         }
}
