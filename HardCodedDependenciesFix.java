public class HardCodedDependenciesFix {
    public static void main(String[] args) {
        ReportGenerator pdfReport = new PDFReportGenerator();
        Report report = new Report(pdfReport);
        report.generateReport();
    }
}

interface ReportGenerator {
    void generateReport();
}

class PDFReportGenerator implements ReportGenerator {
    public void generateReport() {
        System.out.println("Generating PDF Report...");
    }
}

class CSVReportGenerator implements ReportGenerator {
    public void generateReport() {
        System.out.println("Generating CSV Report...");
    }
}

class Report {
    private ReportGenerator reportGenerator;

    public Report(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public void generateReport() {
        reportGenerator.generateReport();
    }
}
