import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveByIdCommand implements Command {
    private final VehiclesCollectionKeeper collectionKeeper;
    private Long id;

    public RemoveByIdCommand(VehiclesCollectionKeeper collectionKeeper) {
        this.collectionKeeper = collectionKeeper;
    }

    @Override
    public void execute() {
        try {
//            if (Reader.getArgument() != null)
            this.id = Long.parseLong(Laba_5.getArgument());
            Vehicle[] veh = collectionKeeper.getCollection().toArray(new Vehicle[0]);
            List<Vehicle> vehList = new ArrayList<>(Arrays.asList(veh));
            vehList.removeIf(vehicle -> vehicle.getId().equals(this.id));
            if (veh.length == vehList.size()) {
                System.out.println("Элемента с таким id нет в коллекции");
            }
            else {
                collectionKeeper.getCollection().clear();
                for (Vehicle vehicle : vehList) {
                    this.collectionKeeper.add(vehicle);
                }
                System.out.println("Элемент " + this.id + " был удален");
            }
            //}
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Неверно введен аргумент команды: " + Laba_5.getArgument() + "\n" +
                    "Введите число");
        }
    }

    public boolean removeById(Long id) {
        try {
            Vehicle[] veh = collectionKeeper.getCollection().toArray(new Vehicle[0]);
            List<Vehicle> vehList = new ArrayList<>(Arrays.asList(veh));
            vehList.removeIf(vehicle -> vehicle.getId().equals(id));
            if (veh.length == vehList.size()) {
                System.out.println("Элемента с таким id нет в коллекции");
                return false;
            }
            else {
                collectionKeeper.getCollection().clear();
                for (Vehicle vehicle : vehList) {
                    this.collectionKeeper.add(vehicle);
                }
                return true;
                //System.out.println("Элемент " + id + " был удален");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Неверно введен аргумент команды: " + Laba_5.getArgument() + "\n" +
                    "Введите число");
        }
        return false;
    }

    public void setId(Long id){
        this.id = id;
    }
}
