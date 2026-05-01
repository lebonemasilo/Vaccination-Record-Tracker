package app;

import model.*;
import service.*;

import java.time.LocalDate;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        VaccinationTracker tracker = new VaccinationTracker();  // Create the tracker (service)

        
        // Create patients 

        Patient p1 = new Patient( 
                "P001",
                "Thabo Molefe",
                LocalDate.of(2010, 5, 12),
                "Serowe",
                "71234567"
        );

        Patient p2 = new Patient(
                "P002",
                "Naledi Dube",
                LocalDate.of(2012, 8, 20),
                "Maun",
                "72345678"
        );

        tracker.registerPatient(p1);
        tracker.registerPatient(p2);

        
        // Create vaccines
        
        Vaccine bcg = new Vaccine("BCG", 1, 0);
        Vaccine polio = new Vaccine("Polio", 3, 30);

        
        // Record vaccinations
        
        tracker.recordVaccination(
                p1,
                bcg,
                1,
                LocalDate.now(),
                "Nurse Alice"
        );

        tracker.recordVaccination(
                p2,
                polio,
                1,
                LocalDate.now().minusDays(40),
                "Nurse John"
        );

        
        // View patient history
        
        System.out.println("\n--- Vaccination History for Thabo ---");
        List<VaccinationRecord> history = tracker.getHistory(p1);

        for (VaccinationRecord record : history) {
            System.out.println(record);
        }

        
        // Report Generator Polymorphism
        
        System.out.println("\n--- Summary Report ---");
        ReportGenerator summaryReport = new SummaryReport();
        summaryReport.generateReport(tracker.getAllRecords());

        System.out.println("\n--- Detailed Report ---");
        ReportGenerator detailedReport = new DetailedReport();
        detailedReport.generateReport(tracker.getAllRecords());
    }
}