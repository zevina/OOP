import java.util.List;
import java.util.Scanner;

public class ShowRelatives implements Option{

    private Tree tree;

    public ShowRelatives(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String description() {
        return "Показать всех родственников выбранного человека";
    }

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Введите ID человека:");
            int id = input.nextInt();
            List<Communication> relations = tree.findHuman(id).getCommunicationList();
            if (relations.size() > 0) {
                for (Communication c: relations) {
                    System.out.println(c);
                }
            } else System.out.println("Нет данных");

        } catch (Exception e){
            System.out.println("Введены неверные данные");
        }
    }
}
