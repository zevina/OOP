import java.util.Scanner;

public class ShowKids implements Option{

    private Tree tree;

    public ShowKids(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String description(){
        return "Показать детей выбранного человека";
    }

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Введите ID человека:");
            int id = input.nextInt();
            tree.findHuman(id).showKids();

        } catch (Exception e){
            System.out.println("Введены неверные данные");
        }
    }

}
