import java.util.List;
public class SummaryReport implements ReportGenerator {
   private int totalDoses;
   private int missingDoses;

public SummaryReport(int totalDoses, int missingDoses) {
   this.totalDoses = totalDoses;
   this.missingDoses = missingDoses;
}

@Override
public String generateReport(List<VaccinationRecord> records) {
   return "Total Doses: " + totalDoses + "\nMissing Doses: " + missingDoses"
  }
}