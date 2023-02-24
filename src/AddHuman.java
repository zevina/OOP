import java.util.Scanner;

public class AddHuman implements Option {

    private Tree tree;

    public AddHuman(Tree tree) {
        this.tree = tree;
    }

    public Tree getTree() {
        return tree;
    }

    @Override
    public String description() {
        return "Добавить нового человека";
    }

    @Override
    public void execute() {
        Form addHuman = new Form();
        addHuman.setVisible(true);
        this.tree = addHuman.getTree();


    }

    @Override
    public void run(int id) {

    }

}
