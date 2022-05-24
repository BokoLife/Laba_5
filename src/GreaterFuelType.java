public class GreaterFuelType implements Command {
    VehiclesCollectionKeeper collectionKeeper;
    String stringFuelType;

    public GreaterFuelType(VehiclesCollectionKeeper collectionKeeper) {
        this.collectionKeeper = collectionKeeper;
    }

    @Override
    public void execute() {
        try {
            stringFuelType = Laba_5.getArgument();
            //if (Arrays.asList(FuelType.values()).contains(FuelType.valueOf(stringFuelType)))
            Vehicle[] vehicles = collectionKeeper.getCollection().toArray(new Vehicle[0]);
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getFuelType().compareTo(FuelType.valueOf(stringFuelType)) > 0) {
                    System.out.println(vehicle);
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Введено значение не из списка констант");
            for (FuelType value : FuelType.values()) {
                System.out.println(value);
            }
        }
    }
}
