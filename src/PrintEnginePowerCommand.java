import java.util.*;

public class PrintEnginePowerCommand implements Command{
    VehiclesCollectionKeeper collectionKeeper;
    public PrintEnginePowerCommand(VehiclesCollectionKeeper collectionKeeper){
        this.collectionKeeper = collectionKeeper;
    }

    @Override
    public void execute(){
        Vehicle[] vehicles = collectionKeeper.getCollection().toArray(new Vehicle[0]);
        List<Vehicle> vehiclesList = new ArrayList<>(Arrays.asList(vehicles));
        vehiclesList.sort(new EngineComparator());
        for (Vehicle vehicle : vehiclesList){
            System.out.println(vehicle.getId() + " " + vehicle.getName() + " " + vehicle.getEnginePower());
        }
    }
}
