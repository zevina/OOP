import java.io.Serializable;
import java.util.*;

public class Tree implements Iterable<Human>, Serializable {
    private List<Human> tree;
    private static final long serialVersionUID = 6065107814980281665L;

    public Tree() {
        this.tree = new ArrayList<>();
    }

    public List<Human> getTree() {
        return tree;
    }

    public void addHuman(Human human){
        tree.add(human);
    }

    public void removeHuman(Human human){
        tree.remove(human);
    }

    @Override
    public Iterator<Human> iterator() {
        return tree.iterator();
    }

    public void printAll() {
        for (Human h : tree) {
            System.out.println(h);
        }
        System.out.println();
    }

    public void sort() {
        Collections.sort(tree);
    }

    public Human findHuman(int id) {
        for (Human hum: this.tree) {
            if (hum.getPersonalID() == id) return hum;
        }
        return null;
    }
}
