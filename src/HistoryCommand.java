public class HistoryCommand implements Command{
    VehiclesCollectionKeeper collectionKeeper;
    public HistoryCommand(VehiclesCollectionKeeper collectionKeeper){
        this.collectionKeeper = collectionKeeper;
    }

    @Override
    public void execute(){
        try {
            String[] history = Laba_5.commandsHistory.toArray(new String[0]);
            if (history.length >= 7) {
                for (int i = history.length - 7; i < history.length; i++) {
                    System.out.println(history[i]);
                }
            } else {
                for (String s : history) {
                    System.out.println(s);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("В истории меньше 7 команд");
        }
    }
}
