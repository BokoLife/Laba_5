public class PrintAscendingCommand implements Command{
    VehiclesCollectionKeeper collectionKeeper;
    public PrintAscendingCommand(VehiclesCollectionKeeper collectionKeeper){
        this.collectionKeeper = collectionKeeper;
    }

    @Override
    public void execute(){
        if (this.collectionKeeper.getCollection().isEmpty()){
            System.out.println("Коллекция пуста");
        } else {
            new ShowCommand(this.collectionKeeper).execute();
        }
    }
}
