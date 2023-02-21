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
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Введите ID человека:");
            int id = input.nextInt();
            List<Communication> relations = tree.findHuman(id).getCommunicationList();
            boolean hasSiblings = false;

            for (Communication c : relations) {
                if (c.getTypeCommunication() == TypeCommunication.BROTHER || c.getTypeCommunication() == TypeCommunication.SISTER) {
                    hasSiblings = true;
                    if (c.getTypeCommunication().equals(TypeCommunication.BROTHER)) {
                        System.out.println(c.getHuman() + "  - Брат");
                    } else System.out.println(c.getHuman() + "  - Сестра");
                }
            }
            if (!hasSiblings) {
                System.out.println("Нет данных о братьях/сестрах");
            }
        } catch (Exception e){
            System.out.println("Введены неверные данные");
        }
    }
}
