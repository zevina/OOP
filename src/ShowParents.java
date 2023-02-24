import java.util.List;
import java.util.Scanner;

public class ShowParents implements Option {

    private Tree tree;

    public ShowParents(Tree tree) {
        this.tree = tree;
    }


    @Override
    public String description() {
        return "Показать родителей выбранного человека";
    }

    @Override
    public void execute() {
        Form idRequest = new Form(tree);
        idRequest.setVisible(true);
    }

    public void run(int id) {
        String res = "";
        try {
            Human human = tree.findHuman(id);

            if (human.getFather() != null || human.getMother() != null) {
                StringBuilder parentsToString = new StringBuilder();
                parentsToString.append("<html>");
                parentsToString.append("Родители:");
                parentsToString.append("<br>");
                if (human.getFather() != null) {
                    parentsToString.append("Отец:");
                    parentsToString.append(human.toWindow(human.getFather().toString()));
                }
                if (human.getMother() != null) {
                    parentsToString.append("Мать:");
                    parentsToString.append(human.toWindow(human.getMother().toString()));
                }
                parentsToString.append("</html>");
                res = parentsToString.toString();
            } else res = "Нет данных";

        } catch (Exception exc) {
            res = "Введены неверные данные";
        }
        Form showParents = new Form("Показать родителей выбранного человека", res);
        showParents.setVisible(true);
    }

}
