import java.util.List;

public class DetailedReport implements ReportGenerator {
    public DetailedReport() {
    }

@Override
public String generateReport(List<VaccinationRecord> records) {
    StringBuilder report = new StringBuilder();

    for (VaccinationRecord record : records) {
            report.append(record.toString()).append("\n");
        }

    return report.toString();
    }
}