public class PrintAll implements Option {

    private Tree tree;

    public PrintAll(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String description(){
        return "Показать всё дерево";
    }

    @Override
    public void execute() {
        tree.sort();
        tree.printAll();
    }


}
