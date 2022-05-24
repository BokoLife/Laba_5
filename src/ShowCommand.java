public class ShowCommand implements Command{
    private final VehiclesCollectionKeeper collectionKeeper;

    public ShowCommand(VehiclesCollectionKeeper collection){
        this.collectionKeeper = collection;
    }
    @Override
    public void execute(){
        Vehicle [] veh = collectionKeeper.getCollection().toArray(new Vehicle[0]);
        while (!collectionKeeper.getCollection().isEmpty()){
            System.out.println(collectionKeeper.getCollection().poll());
        }
        for (Vehicle vehicle : veh){
            this.collectionKeeper.add(vehicle);
        }
        if (collectionKeeper.getCollection().isEmpty()){
            System.out.println("Коллекция пуста");
        }
    }
}
