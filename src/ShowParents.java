import java.util.Scanner;

public class ShowParents implements Option{

    private Tree tree;

    public ShowParents(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String description(){
        return "Показать родителей выбранного человека";
    }

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Введите ID человека:");
            int id = input.nextInt();
            tree.findHuman(id).showParents();

        } catch (Exception e){
            System.out.println("Введены неверные данные");
        }
    }

}
