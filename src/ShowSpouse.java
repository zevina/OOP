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
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Введите ID человека:");
            int id = input.nextInt();
            List<Communication> relations = tree.findHuman(id).getCommunicationList();
            boolean hasSpouse = false;

            for (Communication c : relations) {
                if (c.getTypeCommunication() == TypeCommunication.HUSBAND || c.getTypeCommunication() == TypeCommunication.WIFE) {
                    hasSpouse = true;
                    if (c.getTypeCommunication().equals(TypeCommunication.HUSBAND)) {
                        System.out.println(c.getHuman() + "  - Муж");
                    } else System.out.println(c.getHuman() + "  - Жена");
                }
            }
            if (!hasSpouse) {
                System.out.println("Нет данных о супруге");
            }

        } catch (Exception e) {
            System.out.println("Введены неверные данные");
        }
    }
}
