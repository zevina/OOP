import java.util.List;
import java.util.Scanner;

public class ShowKids implements Option {

    private Tree tree;

    public ShowKids(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String description() {
        return "Показать детей выбранного человека";
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
            List<Human> kids = human.getKids();
            if (kids.size() != 0) {
                StringBuilder kidsToString = new StringBuilder();
                kidsToString.append("<html>");
                kidsToString.append("Дети:");
                kidsToString.append("<br>");
                for (Human kid: kids) {
                    kidsToString.append(kid.toWindow(kid.toString()));
                }

                kidsToString.append("</html>");
                res = kidsToString.toString();
            } else res = ("Нет данных о детях");

        } catch (Exception exc) {
            res = "Введены неверные данные";
        }
        Form showKids = new Form("Показать детей выбранного человека", res);
        showKids.setVisible(true);
    }

}
