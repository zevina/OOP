import java.util.Scanner;

public class AddHuman implements Option {

    private Tree tree;

    public AddHuman(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String description() {
        return "Добавить нового человека";
    }

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Введите имя:");
            String name = input.next();
            System.out.println("Введите год рождения:");
            int year = input.nextInt();
            System.out.println("Введите месяц рождения:");
            int month = input.nextInt();
            System.out.println("Введите день рождения:");
            int day = input.nextInt();
            System.out.println("Введите пол (М/Ж):");
            String personSex = input.next().toLowerCase();
            String sex = "";
            if (personSex.equals("м")) sex = "М";
            else if (personSex.equals("ж")) sex = "Ж";
            else System.out.println("Введены неверные данные");

            System.out.println("Введите ID матери (при отсутствии данных введите 0):");
            int motherID = input.nextInt();
            System.out.println("Введите ID отца (при отсутствии данных введите 0):");
            int fatherID = input.nextInt();
            System.out.println("Введите ID супруга (при отсутствии данных введите 0):");
            int spouseID = input.nextInt();

            Human human = new Human(name, year, month, day, sex);
            tree.addHuman(human);
            try {
                human.addCommunication(tree.findHuman(motherID), TypeCommunication.MOTHER);
                human.setMother(tree.findHuman(motherID));
                tree.findHuman(motherID).addKid(human);


                human.addCommunication(tree.findHuman(fatherID), TypeCommunication.FATHER);
                human.setFather(tree.findHuman(fatherID));
                tree.findHuman(fatherID).addKid(human);

                for (Human h : tree) {
                    if (h.getFather() == human.getFather() && h.getMother() == human.getMother()) {
                        if (sex.equals("М")) {
                            h.addCommunication(human, TypeCommunication.BROTHER);
                            if (h.getSex().equals("М")) {
                                human.addCommunication(h, TypeCommunication.BROTHER);
                            } else human.addCommunication(h, TypeCommunication.SISTER);
                        }
                        if (sex.equals("Ж")) {
                            h.addCommunication(human, TypeCommunication.SISTER);
                            if (h.getSex().equals("М")) {
                                human.addCommunication(h, TypeCommunication.BROTHER);
                            } else human.addCommunication(h, TypeCommunication.SISTER);
                        }
                    }
                }

                if (sex.equals("М")) {
                    tree.findHuman(motherID).addCommunication(human, TypeCommunication.SON);
                    tree.findHuman(fatherID).addCommunication(human, TypeCommunication.SON);
                } else {
                    tree.findHuman(motherID).addCommunication(human, TypeCommunication.DAUGHTER);
                    tree.findHuman(fatherID).addCommunication(human, TypeCommunication.DAUGHTER);
                }

                if (sex.equals("М")) {
                    human.addCommunication(tree.findHuman(spouseID), TypeCommunication.WIFE);
                    tree.findHuman(spouseID).addCommunication(human, TypeCommunication.HUSBAND);
                } else {
                    human.addCommunication(tree.findHuman(spouseID), TypeCommunication.HUSBAND);
                    tree.findHuman(spouseID).addCommunication(human, TypeCommunication.WIFE);
                }
            } catch (Exception ignored) {
            }

            System.out.println("Добавлено успешно");
        } catch (
                Exception e) {
            System.out.println("Введены неверные данные");
        }
    }

}
