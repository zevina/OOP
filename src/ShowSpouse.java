import java.util.List;
import java.util.Scanner;

public class ShowSpouse implements Option {

    private Tree tree;

    public ShowSpouse(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String description() {
        return "Показать супруга выбранного человека";
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
                StringBuilder spouseToString = new StringBuilder();
                spouseToString.append("<html>");

                boolean hasSpouse = false;

                for (Communication c : relations) {
                    if (c.getTypeCommunication() == TypeCommunication.HUSBAND || c.getTypeCommunication() == TypeCommunication.WIFE) {
                        hasSpouse = true;
                        if (c.getTypeCommunication().equals(TypeCommunication.HUSBAND)) {
                            spouseToString.append("Муж: ");
                            spouseToString.append(c.getHuman().toWindow(c.getHuman().toString()));
                        } else {
                            spouseToString.append("Жена: ");
                            spouseToString.append(c.getHuman().toWindow(c.getHuman().toString()));
                        }
                        spouseToString.append("</html>");
                        res = spouseToString.toString();
                    }
                }
                if (!hasSpouse) {
                    res = "Нет супруга";
                }

            } else res = ("Нет данных о супруге");

        } catch (Exception exc) {
            res = "Введены неверные данные";
        }
        Form showSpouse = new Form("Показать супруга выбранного человека", res);
        showSpouse.setVisible(true);
    }
}
