import java.io.*;
import java.util.List;

public class FileHandler {

    private Tree tree;

    public FileHandler()  {
    }


    public void writeFile(String path, Tree tree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();
    }

    public Tree readFile(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        Tree tree = (Tree) objectInputStream.readObject();
        objectInputStream.close();
        return tree;
    }
}
