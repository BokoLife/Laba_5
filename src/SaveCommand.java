import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import java.io.*;

public class SaveCommand implements Command {
    private VehiclesCollectionKeeper collectionKeeper;

    public SaveCommand(VehiclesCollectionKeeper collectionKeeper) {
        this.collectionKeeper = collectionKeeper;
    }

    @Override
    public void execute() {
        // Создается построитель документа
        DocumentBuilder documentBuilder = null;
        Document document = null;

        try {
            String fileName = Laba_5.getArgument();
            File file = new File(fileName);
            try {
                documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                document = documentBuilder.parse(file);

                for (Vehicle veh : this.collectionKeeper.getCollection()){
                    DomParser.addNewVehicle(document, veh, file);
                }
                System.out.println("Коллекция была сохранена в файл " + fileName);
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Имя файла задано неверно");
            }
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
