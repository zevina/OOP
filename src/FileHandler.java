import java.io.*;

public class FileHandler {

    private Notebook<Note> notebook;

    public FileHandler()  {
    }


    // сериализация
    public static void writeFile(String path, Notebook<Note> notebook) throws IOException {
        // TODO
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
        out.writeObject(notebook);
        out.close();
    }

    public static Notebook<Note> readFile(String path) throws IOException, ClassNotFoundException {
        // TODO
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Notebook notebook = (Notebook) in.readObject();
        in.close();
        return notebook;
    }

    // .json
    public static void writeJSONFile(String path, Notebook<Note> notebook)  {
        // TODO
    }

    public String readJSONFile(String path)  {
        // TODO
        return "readJSONFile";
    }

    // .xml
    public static void writeXMLFile(String path, Notebook<Note> notebook)  {
        // TODO
    }

    public String readXMLFile(String path)  {
        // TODO
        return "readXMLFile";
    }

    // .csv
    public static void writeCSVFile(String path, Notebook<Note> notebook)  {
        // TODO
    }

    public String readCSVFile(String path)  {
        // TODO
        return "readCSVFile";
    }
}
