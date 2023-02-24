import java.util.List;
import java.util.Scanner;

public class ShowGrandparents implements Option {

    private Tree tree;

    public ShowGrandparents(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String description() {
        return "Показать бабушек/дедушек выбранного человека";
    }

    @Override
    public void execute() {
        Form idRequest = new Form(tree);
        idRequest.setVisible(true);
    }

    @Override
    public void run(int id) {
        String res = "";
        try {
            Human human = tree.findHuman(id);
            StringBuilder grandToString = new StringBuilder();
            grandToString.append("<html>");
            grandToString.append("Бабушки/дедушки:");
            grandToString.append("<br>");
            grandToString.append("<br>");


            grandToString.append("- со стороны отца:");
            grandToString.append("<br>");

            Human father = human.getFather();
            if (father.getFather() != null) {
                grandToString.append("Отец:");
                grandToString.append(father.toWindow(father.getFather().toString()));
            }
            if (father.getMother() != null) {
                grandToString.append("Мать:");
                grandToString.append(father.toWindow(father.getMother().toString()));
                grandToString.append("<br>");
            }

            grandToString.append("- со стороны матери:");
            grandToString.append("<br>");
            Human mother = human.getMother();
            if (mother.getFather() != null) {
                grandToString.append("Отец:");
                grandToString.append(mother.toWindow(mother.getFather().toString()));
            }
            if (mother.getMother() != null) {
                grandToString.append("Мать:");
                grandToString.append(mother.toWindow(mother.getMother().toString()));
            }

            grandToString.append("</html>");
            res = grandToString.toString();

        } catch (Exception exc) {
            res = "Введены неверные данные";
        }
        Form showGrandparents = new Form("Показать бабушек/дедушек выбранного человека", res);
        showGrandparents.setVisible(true);
    }
}
