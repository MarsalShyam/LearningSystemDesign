class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public void start() {
        System.out.println(type + " engine started.");
    }

    public String getType() {
        return type;
    }
}

class Car {
    protected String brand;
    protected Engine engine;  //has-an relation composition

    public Car(String brand, Engine engine) {
        this.brand = brand;
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println(brand + " is now driving.");
    }
}

class ManualCar extends Car {
    public ManualCar(String brand, Engine engine) {
        super(brand, engine);
    }

    public void shiftGear() {
        System.out.println("Manual gear shifted.");
    }

    @Override
    public void drive() {
        super.drive();
        shiftGear();
    }
}

class ElectricCar extends Car {
    public ElectricCar(String brand, Engine engine) {
        super(brand, engine);
    }

    public void chargeBattery() {
        System.out.println("Battery is charging...");
    }

    @Override
    public void drive() {
        chargeBattery();
        super.drive();
    }
}

class Composition{
    public static void main(String[] args) {
        Engine petrolEngine = new Engine("Petrol");
        ManualCar manual = new ManualCar("Maruti 800", petrolEngine);

        Engine electricEngine = new Engine("Electric");
        ElectricCar electric = new ElectricCar("Tesla Model 3", electricEngine);

        System.out.println("--- Manual Car ---");
        manual.drive();

        System.out.println("\n--- Electric Car ---");
        electric.drive();
    }
}