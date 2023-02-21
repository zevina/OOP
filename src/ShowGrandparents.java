import java.util.Scanner;

public class ShowGrandparents implements Option{

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
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Введите ID человека:");
            int id = input.nextInt();

            System.out.println("Бабушки/дедушки:");
            System.out.println("- со стороны отца:");
            tree.findHuman(id).getFather().showParents();
            System.out.println("- со стороны матери:");
            tree.findHuman(id).getMother().showParents();

        } catch (Exception e){
            System.out.println("Введены неверные данные");
        }
//
//
//

//        System.out.println();

    }
}
