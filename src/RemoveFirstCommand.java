import java.util.NoSuchElementException;

public class RemoveFirstCommand implements Command{
    VehiclesCollectionKeeper collectionKeeper;
    public RemoveFirstCommand(VehiclesCollectionKeeper collectionKeeper){
        this.collectionKeeper = collectionKeeper;
    }

    @Override
    public void execute() {
        try{
            System.out.println("Элемент с id " + this.collectionKeeper.getCollection().remove().getId() + " был удален");
        }
        catch(NoSuchElementException e) {
            System.out.println("Коллекция пуста");
        }
    }
}
