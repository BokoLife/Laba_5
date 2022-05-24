import java.util.PriorityQueue;
import java.util.Queue;

public class RemoveGreaterCommand implements Command{
    VehiclesCollectionKeeper collectionKeeper;
    Vehicle newVehicle;
    public RemoveGreaterCommand(VehiclesCollectionKeeper collectionKeeper){
        this.collectionKeeper = collectionKeeper;
    }

    @Override
    public void execute(){
        AddCommand addCommand = new AddCommand(this.collectionKeeper);
        addCommand.execute();
        this.newVehicle = addCommand.getNewVehicle();
        Queue<Vehicle> newCollection = new PriorityQueue<>();
        while (true){
            Vehicle polled = this.collectionKeeper.getCollection().poll();
            if (polled != this.newVehicle){
                newCollection.add(polled);
            }
            else {
                newCollection.add(newVehicle);
                break;
            }
        }
        System.out.println("Элементы превышающие заданный были удалены из коллекции");
        collectionKeeper.getCollection().clear();
        for (Vehicle vehicle : newCollection){
            collectionKeeper.getCollection().add(vehicle);
        }
    }
}
