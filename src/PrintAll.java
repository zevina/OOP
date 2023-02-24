public class PrintAll implements Option {

    private Tree tree;

    public PrintAll(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String description() {
        return "Показать всё дерево";
    }

    @Override
    public void execute() {
        tree.sort();
        Form allTree = new Form("Показать всё дерево", tree.printWindow());
        allTree.setVisible(true);
    }

    @Override
    public void run(int id) {

    }


}
