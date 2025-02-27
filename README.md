```markdown
# Correções de Violação de Princípios SOLID

Este repositório contém exemplos de correções para várias violações de princípios de design, conhecidos como princípios SOLID. Cada exemplo de código reflete a correção de uma violação específica de um desses princípios.

## 1. Correção de Violação do Princípio da Inversão de Dependência (Dependency Inversion Principle)

```java
public class DependencyInversionViolationFix {
    public static void main(String[] args) {
        Switchable bulb = new LightBulb();
        Switch lightSwitch = new Switch(bulb);
        lightSwitch.turnOn();
    }
}

interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {
    public void turnOn() {
        System.out.println("LightBulb is ON");
    }
    
    public void turnOff() {
        System.out.println("LightBulb is OFF");
    }
}

class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void turnOn() {
        device.turnOn();
    }

    public void turnOff() {
        device.turnOff();
    }
}
```

## 2. Correção de Violação de Encapsulamento (Encapsulation Principle)

```java
public class EncapsulationFix {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(30);
        System.out.println(person.getName() + " is " + person.getAge() + " years old.");
    }
}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be positive");
        }
    }
}
```

## 3. Correção de Violação de Classe Deus (God Class)

```java
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
```

## 4. Correção de Violação de Dependências Duras (Hard-Coded Dependencies)

```java
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
```

## 5. Correção de Violação de Segregação de Interface (Interface Segregation Principle)

```java
public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        MultiFunctionPrinter printer = new MultiFunctionPrinter();
        printer.print();
        printer.scan();
        printer.fax();

        SimplePrinter simplePrinter = new SimplePrinter();
        simplePrinter.print();
    }
}

interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

class MultiFunctionPrinter implements Printer, Scanner, Fax {
    public void print() {
        System.out.println("Printing...");
    }

    public void scan() {
        System.out.println("Scanning...");
    }

    public void fax() {
        System.out.println("Faxing...");
    }
}

class SimplePrinter implements Printer {
    public void print() {
        System.out.println("Printing...");
    }
}
```

## 6. Correção de Violação de Substituição de Liskov (Liskov Substitution Principle)

```java
public class LiskovSubstitutionViolation {
    public static void main(String[] args) {
        Bird bird = new Ostrich();
        bird.fly();
    }
}

class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}
```

## 7. Correção de Violação de Aberto/Fechado (Open/Closed Principle)

```java
public class OpenClosedViolation {
    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println("Discount: " + calculator.calculateDiscount("VIP", 200));
    }
}

class DiscountCalculator {
    public double calculateDiscount(String customerType, double amount) {
        if (customerType.equals("Regular")) {
            return amount * 0.1;
        } else if (customerType.equals("VIP")) {
            return amount * 0.2;
        } else {
            return 0;
        }
    }
}
```

## 8. Correção de Manipulação Apropriada de Exceções (Proper Exception Handling)

```java
public class ProperExceptionHandling {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            calculator.divide(10, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class Calculator {
    public void divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        System.out.println("Result: " + (a / b));
    }
}
```

## 9. Correção de Violação de Responsabilidade Única (Single Responsibility Principle)

```java
public class SingleResponsibilityFix {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(1000);
        InvoicePrinter printer = new InvoicePrinter();
        InvoiceRepository repository = new InvoiceRepository();
        
        printer.printInvoice(invoice);
        repository.saveToDatabase(invoice);
    }
}

class Invoice {
    private double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

class InvoicePrinter {
    public void printInvoice(Invoice invoice) {
        System.out.println("Invoice amount: " + invoice.getAmount());
    }
}

class InvoiceRepository {
    public void saveToDatabase(Invoice invoice) {
        System.out.println("Saving invoice to database...");
    }
}
```

## 10. Correção de Violação de Acoplamento Rígido (Tight Coupling)

```java
public class TightCouplingFix {
    public static void main(String[] args) {
        EngineInterface engine = new PetrolEngine();
        Car car = new Car(engine);
        car.start();
    }
}

interface EngineInterface {
    void start();
}

class PetrolEngine implements EngineInterface {
    public void start() {
        System.out.println("Petrol Engine started");
    }
}

class ElectricEngine implements EngineInterface {
    public void start() {
        System.out.println("Electric Engine started");
    }
}

class Car {
    private EngineInterface engine;

    public Car(EngineInterface engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
        System.out.println("Car is running");
    }
}
```
