import java.util.List;
import java.util.Scanner;

public class ShowSiblings implements Option{

    private Tree tree;

    public ShowSiblings(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String description() {
        return "Показать братьев/сестер выбранного человека";
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
            List<Communication> relations = human.getCommunicationList();

            if (relations.size() > 0) {
                StringBuilder siblingsToString = new StringBuilder();
                siblingsToString.append("<html>");

                boolean hasSiblings = false;

                for (Communication c : relations) {
                    if (c.getTypeCommunication() == TypeCommunication.BROTHER || c.getTypeCommunication() == TypeCommunication.SISTER) {
                        hasSiblings = true;
                        if (c.getTypeCommunication().equals(TypeCommunication.BROTHER)) {
                            siblingsToString.append("Брат: ");
                            siblingsToString.append(c.getHuman().toWindow(c.getHuman().toString()));
                        } else {
                            siblingsToString.append("Сестра: ");
                            siblingsToString.append(c.getHuman().toWindow(c.getHuman().toString()));
                        }
                        siblingsToString.append("</html>");
                        res = siblingsToString.toString();
                    }
                }
                if (!hasSiblings) {
                    res = "Нет братьев/сестер";
                }

            } else res = ("Нет данных о о братьях/сестрах");

        } catch (Exception exc) {
            res = "Введены неверные данные";
        }
        Form showSiblings = new Form("Показать братьев/сестер выбранного человека", res);
        showSiblings.setVisible(true);
    }
}
