public class UpdateIdCommand implements Command{
    VehiclesCollectionKeeper collectionKeeper;
    Long id;

    public UpdateIdCommand(VehiclesCollectionKeeper collectionKeeper) {
        this.collectionKeeper = collectionKeeper;
    }

    @Override
    public void execute(){
        try{
            this.id = Long.parseLong(Laba_5.getArgument());
            RemoveByIdCommand removeByIdCommand = new RemoveByIdCommand(this.collectionKeeper);
            if (removeByIdCommand.removeById(this.id)){
                AddCommand addCommand = new AddCommand(this.collectionKeeper);
                addCommand.setId(this.id);
                addCommand.execute();
            }
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e){
            System.out.println("Неверно введен аргумент команды: " + Laba_5.getArgument() + "\n" +
                    "Введите число");
        }
    }
}
