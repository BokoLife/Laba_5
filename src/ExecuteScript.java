import javax.xml.transform.TransformerFactoryConfigurationError;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ExecuteScript implements Command{
    private VehiclesCollectionKeeper collectionKeeper;

    public ExecuteScript(VehiclesCollectionKeeper collectionKeeper){
        this.collectionKeeper = collectionKeeper;
    }

    @Override
    public void execute(){

        File commandsFile = new File(Laba_5.getArgument());

        String fileName = "commands.txt";
        Path path = Paths.get(fileName);

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(commandsFile);
            BufferedInputStream bis = new BufferedInputStream(fis);

            List lines = Files.readAllLines(path);
            for (Object line1 : lines) {
                String line = (String) line1;
                Laba_5.userInputMas = line.split(" ", 3);
                if (Laba_5.getCommandsMap().getKeys().contains(Laba_5.getCommand())) {
                    if (Laba_5.getCommand().equals("execute_script")){
                        System.out.println("Цикл оаоаоа");
                        System.exit(1);
                    }
                    else {
                        Laba_5.getCommandsMap().get(Laba_5.getCommand()).execute();
                    }
                } else {
                    System.out.println("Было введено значение не из списка команд");
                }
            }
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
    }
}
