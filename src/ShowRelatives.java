import java.util.List;
import java.util.Scanner;

public class ShowRelatives implements Option {

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
        Form idRequest = new Form(tree);
        idRequest.setVisible(true);


//        Scanner input = new Scanner(System.in);
//
//        try {
//            System.out.println("Введите ID человека:");
//            int id = input.nextInt();
//            List<Communication> relations = tree.findHuman(id).getCommunicationList();
//            if (relations.size() > 0) {
//                for (Communication c: relations) {
//                    System.out.println(c);
//                }
//            } else System.out.println("Нет данных");
//
//        } catch (Exception e){
//            System.out.println("Введены неверные данные");
//        }
    }

    @Override
    public void run(int id) {
        String res = "";
        try {
            Human human = tree.findHuman(id);
            List<Communication> relations = human.getCommunicationList();

            if (relations.size() > 0) {
                StringBuilder relativesToString = new StringBuilder();
                relativesToString.append("<html>");
                relativesToString.append("Родственники:");
                relativesToString.append("<br>");
                for (Communication c : relations) {
                    relativesToString.append(c.toWindow(c.toString()));
                }

                relativesToString.append("</html>");
                res = relativesToString.toString();
            } else res = ("Нет данных о родственниках");

        } catch (Exception exc) {
            res = "Введены неверные данные";
        }
        Form showRelatives = new Form("Показать всех родственников выбранного человека", res);
        showRelatives.setVisible(true);
    }
}

