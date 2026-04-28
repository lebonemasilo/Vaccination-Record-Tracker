package app;
import java.util.Scanner;
import service.VaccinatioTracker;
import utils.InputHelper;
import service.SummaryReport;
import service.DeatiledReport;
import service.ReportGenerator;
import utils.InputHelper;
import model.Patient;
import model.Vaccine;
import model.VaccinationRecord;

public class VaccineMenu{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        VacciantionTracker tracker = new VaccinationTracker();
        int choice;

        do{
            System.out.println("===Welcome===");
            System.out.println("1. Register a new Patient");
            System.out.printin("2. Record a vaccination dose");
            System.out.printin("3. View patient vaccination history");
            System.out.println("4. Generate summary report");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    registerPatient (sc, tracker);
                    break;
                case 2:
                   recordVaccination (sc tracker);
                    break;
                case 3:
                  viewHistory (sc, tracker);
                    break;
                case 4: 
                    generateReport (tracker);
                    break;

                case 5:
                    System.out.println("Exiting. Thank you..."); 
                    break;
                
                default:
                    System.out.println("Invalid input, please try again.");
            }
        } while (choice !=5); // run while user has not opted to exit.
        sc.close();
    }

    private static void registerPatient (Scanner sc, VaccinationTracker tracker) {
        System.out.println ("\n---Register New Patient ---");

        String name = InputHelper.readString(sc,"Enter patient name: ");
        int age = InputHelper.readString (sc, "Enter patient age:");
        String id = InputHelper.readString(sc,"Enter patient id: ");
        String village = InputHelper.readString(sc, "Enter village:");

        Patient patient = new Patient  (name, age, id, village);

        try{
            tracker.registerPatient(patient);
            System.out.println("Patient registered successfully");
        } catch (IllegalArgumentException e) {
            System.out.println ("Error: " + e.getMessage ());
        }
    }

    private static void recordVaccination(Scanner sc, VaccinationTracker tracker) {
        System.out.println("\n--- Record Vaccination Dose ---");

        String patientId = InputHelper.readString (sc, "Enter patient ID:");
        Patient patient = tracker.findPatientById(patientId);

        if (patient == null) {
            System.out.println("Error: Patient not found. Please register the patient first");
            return;
        }

        System.out.println("Patient found: "+ patient.getName());

        String vaccineName = InputHelper.readString(sc, "Enter vaccine name");
        Vaccine vaccine = tracker.findVaccineByName (vaccineName);

        if (vaccine == null) {
            System.out.println("Error: Vaccine not found in catalogue. ")
            System.out.println("Available vaccines: + List<vaccine> ");
            return;
        }
        int doseNumber = InputHelper.readInt(sc,1, vaccine.getRequiredDoses());

        System.out.print("Enter date (YYYY-MM-DD):");
        String dateStr = sc.nextLine();
        LocalDate date;
        try {
            date = LcalDate.parse(dateStr);
        } catch (Exception e) {
            System.out.println ("Invalid date format. Using today's date");
            date = LocalDate.now();
        }

        String nurse = InputHelper.readString(sc, "Enter nurse/ administrator name:");

        VaccinationRecord record = new VaccinationRecord (patient, vaccine, doseNumber,date,nurse);

        try {
            tracker.addVaccinationRecord(record);
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewHistory (Scanner sc, VaccinationTracker tracker) {
        System.out.println("\n--- Patient Vaccination History ---");

        String patientId = InputHelper.readString(sc, "Enter patient ID:");
        var history = tracker.getRecordsByPatient(patientId);

        if (history.isEmpty()) {
            System.out.println ("No vaccination records found for patient ID: " + patientId);
        } else {
            Patient patient = history.get(0).gerPatient();
            System.out.println ("-------------------------------------------");
            System.out.println ("Total doses: " + history.size());
        }
    }

    private static void generateReport (Scanner sc, VaccinationTracker tracker) {
        System.out.println("\n---GenerateReport ----");
        System.out.println("1. Summary Report");
        System.out.println("2. Detailed Report");
        System.out.println("Choose report type:");

        int reportChoice = InputHelper.readInt(sc,1,2);

        ReportGenerator generator;
        if (reportChoice == 1) {generator = new SummaryReport();
        } else {
            generator = new DetailedReport();
        }
        
        String report = generator.generateReport(tracker.getAllRecords());
        System.out.println("\n" + report);


    }
            
            
}
