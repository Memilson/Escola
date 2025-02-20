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
