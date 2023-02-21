import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
//        Tree tree = new Tree();
//        Human h1 = new Human("Дмитрий", 1945, 12, 21, "М");
//        Human h2 = new Human("Антонина", 1948, 7, 1, "Ж");
//        h1.addCommunication(h2, TypeCommunication.WIFE);
//        h2.addCommunication(h1, TypeCommunication.HUSBAND);
//        Human h3 = new Human("Мария", 1965, 8, 10, "Ж");
//        h3.addCommunication(h1, TypeCommunication.FATHER);
//        h3.addCommunication(h2, TypeCommunication.MOTHER);
//        h1.addCommunication(h3, TypeCommunication.DAUGHTER);
//        h2.addCommunication(h3, TypeCommunication.DAUGHTER);
//        Human h4 = new Human("Павел", 1968, 1, 19, "М");
//        h4.addCommunication(h1, TypeCommunication.FATHER);
//        h4.addCommunication(h2, TypeCommunication.MOTHER);
//        h4.addCommunication(h3, TypeCommunication.SISTER);
//        h3.addCommunication(h4, TypeCommunication.BROTHER);
//        h1.addCommunication(h4, TypeCommunication.SON);
//        h2.addCommunication(h4, TypeCommunication.SON);
//        Human h5 = new Human("Аркадий", 1915, 1, 1, "М");
//        Human h6 = new Human("Виолетта", 1918, 11, 11, "Ж");
//        h5.addCommunication(h6, TypeCommunication.WIFE);
//        h6.addCommunication(h5, TypeCommunication.HUSBAND);
//        h1.addCommunication(h5, TypeCommunication.FATHER);
//        h1.addCommunication(h6, TypeCommunication.MOTHER);
//        h5.addCommunication(h1, TypeCommunication.SON);
//        h6.addCommunication(h1, TypeCommunication.SON);
//        Human h7 = new Human("Владимир", 1916, 10, 5, "М");
//        Human h8 = new Human("Ольга", 1917, 9, 9, "Ж");
//        h7.addCommunication(h8, TypeCommunication.WIFE);
//        h8.addCommunication(h7, TypeCommunication.HUSBAND);
//        h2.addCommunication(h7, TypeCommunication.FATHER);
//        h2.addCommunication(h8, TypeCommunication.MOTHER);
//        h7.addCommunication(h2, TypeCommunication.DAUGHTER);
//        h8.addCommunication(h2, TypeCommunication.DAUGHTER);
//        Human h10 = new Human("Михаил", 1964, 4, 17, "М");
//        h10.addCommunication(h3, TypeCommunication.WIFE);
//        h3.addCommunication(h10, TypeCommunication.HUSBAND);
//        Human h9 = new Human("Андрей", 1990, 1, 7, "М");
//        h9.addCommunication(h3, TypeCommunication.MOTHER);
//        h9.addCommunication(h10, TypeCommunication.FATHER);
//        h3.addCommunication(h9, TypeCommunication.SON);
//        h10.addCommunication(h9, TypeCommunication.SON);
//
//        tree.addHuman(h1);
//        tree.addHuman(h2);
//        tree.addHuman(h3);
//        tree.addHuman(h4);
//        tree.addHuman(h5);
//        tree.addHuman(h6);
//        tree.addHuman(h7);
//        tree.addHuman(h8);
//        tree.addHuman(h9);
//        tree.addHuman(h10);


        FileHandler fileHandler = new FileHandler();
        Tree tree = fileHandler.readFile("tree.out");

        List<Option> commandList = new ArrayList<>();
        commandList.add(new PrintAll(tree));
        commandList.add(new AddHuman(tree));
        commandList.add(new ShowParents(tree));
        commandList.add(new ShowKids(tree));
        commandList.add(new ShowSpouse(tree));
        commandList.add(new ShowSiblings(tree));
        commandList.add(new ShowGrandparents(tree));
        commandList.add(new ShowRelatives(tree));

        System.out.println("Выберите нужный пункт:");
        for (int i = 0; i < commandList.size(); i++) {
            System.out.println(i+1 + ": " + commandList.get(i).description());
        }
        Scanner scanner = new Scanner(System.in);
        try {
            int choose = scanner.nextInt();
            if (choose > 0 && choose < commandList.size()+1){
                commandList.get(choose-1).execute();
            }
            else System.out.println("Некорректный ввод!");
        }
        catch (Exception e) {
            System.out.println("Некорректный ввод!");
        }



//
//        System.out.println("Родители:");
//        h3.showParents();
//        h3.showSiblings();
//
//        h2.showKids();


        fileHandler.writeFile("tree.out", tree);
    }

}