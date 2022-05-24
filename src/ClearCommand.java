public class ClearCommand implements Command{
    private VehiclesCollectionKeeper collectionKeeper;

    public ClearCommand(VehiclesCollectionKeeper collectionKeeper){
        this.collectionKeeper = collectionKeeper;
    }
    @Override
    public void execute() {
        this.collectionKeeper.getCollection().clear();
        System.out.println("Из коллекции были удалены все элементы");
    }
}
