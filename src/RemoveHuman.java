import java.util.List;
import java.util.Scanner;

public class RemoveHuman implements Option {

    private Tree tree;

    public RemoveHuman(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String description() {
        return "Удалить данные человека";
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
//            Human human = tree.findHuman(id);
//
//
//            try {
//                for (Human h : tree) {
//                    if (h.getFather().equals(human)) {
//                        h.setFather(null);
//                    }
//                    if (h.getMother().equals(human)) {
//                        h.setMother(null);
//                    }
//                    List<Human> kids = h.getKids();
//                    if (kids.contains(human)) {
//                        kids.remove(human);
//                        h.setKids(kids);
//                    }
//                    List<Communication> communications = h.getCommunicationList();
//                    for (Communication com : communications) {
//                        if (com.getHuman().equals(human)) {
//                            communications.remove(com);
//                        }
//                    }
//                    h.setCommunicationList(communications);
//                }
//
//                tree.removeHuman(human);
//                System.out.println("Данные успешно удалены");
//
//            } catch (Exception ignored) {
//            }
//        } catch (Exception e) {
//            System.out.println("Введены неверные данные");
//        }
    }

    @Override
    public void run(int id) {

        String res = "";

        try {
            Human human = tree.findHuman(id);
            try {
                for (Human h : tree) {
                    if (h.getFather().equals(human)) {
                        h.setFather(null);
                    }
                    if (h.getMother().equals(human)) {
                        h.setMother(null);
                    }
                    List<Human> kids = h.getKids();
                    if (kids.contains(human)) {
                        kids.remove(human);
                        h.setKids(kids);
                    }
                    List<Communication> communications = h.getCommunicationList();
                    for (Communication com : communications) {
                        if (com.getHuman().equals(human)) {
                            communications.remove(com);
                        }
                    }
                    h.setCommunicationList(communications);
                }

                tree.removeHuman(human);
                res = "Данные успешно удалены";

            } catch (Exception ignored) {
            }
        } catch (Exception e) {
            res = "Введены неверные данные";
        }
        Form removeHuman = new Form("Удалить данные человека", res);
        removeHuman.setVisible(true);
    }

}
