import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandsMap {
    private Map<String, Command> commands = new HashMap<>();
    private VehiclesCollectionKeeper collectionKeeper;

    public CommandsMap(VehiclesCollectionKeeper collectionKeeper){
        this.collectionKeeper = collectionKeeper;
        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand(collectionKeeper));
        commands.put("show", new ShowCommand(collectionKeeper));
        commands.put("add", new AddCommand(collectionKeeper));
        commands.put("update", new UpdateIdCommand(collectionKeeper));
        commands.put("remove_by_id", new RemoveByIdCommand(collectionKeeper));
        commands.put("clear", new ClearCommand(collectionKeeper));
        commands.put("save", new SaveCommand(collectionKeeper));
        commands.put("execute_script", new ExecuteScript(collectionKeeper));
        commands.put("exit", new ExitCommand());
        commands.put("remove_first", new RemoveFirstCommand(collectionKeeper));
        commands.put("remove_greater", new RemoveGreaterCommand(collectionKeeper));
        commands.put("history", new HistoryCommand(collectionKeeper));
        commands.put("filter_greater_than_fuel_type", new GreaterFuelType(collectionKeeper));
        commands.put("print_ascending", new PrintAscendingCommand(collectionKeeper));
        commands.put("print_field_descending_engine_power", new PrintEnginePowerCommand(collectionKeeper));
    }

    public void put(String commandName, Command command){
        this.commands.put(commandName, command);
    }

    public Command get(String key){
        return this.commands.get(key);
    }

    public Set<String> getKeys(){
        return this.commands.keySet();
    }

    public void setElement(String element){
    }
}
