public class GodClassViolationFix {
    public static void main(String[] args) {
        Application app = new Application(new Authenticator(), new Dashboard(), new PaymentProcessor(), new ReportGenerator());
        app.run();
    }
}

class Application {
    private Authenticator auth;
    private Dashboard dashboard;
    private PaymentProcessor payment;
    private ReportGenerator report;

    public Application(Authenticator auth, Dashboard dashboard, PaymentProcessor payment, ReportGenerator report) {
        this.auth = auth;
        this.dashboard = dashboard;
        this.payment = payment;
        this.report = report;
    }

    public void run() {
        System.out.println("Running application...");
        auth.authenticateUser();
        dashboard.loadDashboard();
        payment.processPayments();
        report.generateReports();
    }
}

class Authenticator {
    public void authenticateUser() {
        System.out.println("Authenticating user...");
    }
}

class Dashboard {
    public void loadDashboard() {
        System.out.println("Loading dashboard...");
    }
}

class PaymentProcessor {
    public void processPayments() {
        System.out.println("Processing payments...");
    }
}

class ReportGenerator {
    public void generateReports() {
        System.out.println("Generating reports...");
    }
}

