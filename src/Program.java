/*
1. Реализовать, с учетом ооп подхода, приложение для проведения исследований с генеалогическим древом.
Описать некоторое количество компонент:
 - модель человека
 - компонента хранения связей и отношений между людьми: родитель, ребёнок, брат, свекровь, сестра и т. д.
 - компонента для проведения исследований
   (под “проведением исследования” можно понимать получение всех детей выбранного человека)
 - дополнительные компоненты, отвечающие за:
      - вывод данных в консоль,
      - загрузку и сохранения в файл,
      - получение\построение отдельных моделей человека

2. Описать в ООП стиле логику взаимодействия объектов реального мира между собой: шкаф-человек.
Какие члены должны быть у каждого из классов (продумать логику взаимодействия жена разрешает открыть дверцу шкафа мужу,
после чего эту дверцу можно открыть)

3. Подумать как описать логику взаимодействия человека и домашнего питомца.
Сценарий: Человек “зовёт” котика “кис-кис”, котик отзывается. Какое ещё взаимодействие может быть?

4. Продумать какие проблемы могут возникнуть в том коде, который написали.
Например, в первой задаче (с генеалогическим древом) мы можем знать о двух людях,
но не знаем в каких “отношениях” они были - двоюродные или троюродные, или мы точно знаем как звали прапрабабушку,
но совершенно не знаем прабабушку - как хранить такие связи или что будет если в компоненту обхода передать ссылку на null-дерево.
* */

//import com.google.gson.*;
//import org.json.simple.*;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        List<Human> tree = new ArrayList<>();

        // надо реализовать метод считывания JSON файла, а пока так:
        Human hum1 = new Human("Дарья", 1989, 6, 5, false, 0, 0, 0);
        Human hum2 = new Human("Мария", 1965, 12, 10, false, 0, 0, 0);
        Human hum3 = new Human("Александр", 1964, 7, 30, true, 0, 0, 0);
        Human hum4 = new Human("Михаил", 1988, 7, 30, true, 0, 0, 0);
        Human hum5 = new Human("Макар", 1992, 6, 5, true, 0, 0, 0);
        Human hum6 = new Human("Борис", 1990, 6, 5, true, 0, 0, 0);
        Human hum7 = new Human("Антон", 1963, 6, 5, true, 0, 0, 0);
        Human hum8 = new Human("Анастасия", 1945, 12, 10, false, 0, 0, 0);
        Human hum9 = new Human("Дмитрий", 1944, 7, 30, true, 0, 0, 0);
        Human hum10 = new Human("Денис", 2020, 5, 7, true, 1001, 1004, 0);

        // установление родственных связей
        hum1.setMotherID(hum2);
        hum1.setFatherID(hum3);
        hum1.setSpouseID(hum4);
        hum4.setSpouseID(hum1);
        hum2.setSpouseID(hum3);
        hum3.setSpouseID(hum2);
        hum5.setMotherID(hum2);
        hum5.setFatherID(hum3);
        hum2.setMotherID(hum8);
        hum2.setFatherID(hum9);
        hum7.setMotherID(hum8);
        hum7.setFatherID(hum9);
        hum8.setSpouseID(hum9);
        hum9.setSpouseID(hum8);
        hum6.setFatherID(hum7);

        // добавление в список людей
        tree.add(hum1);
        tree.add(hum2);
        tree.add(hum3);
        tree.add(hum4);
        tree.add(hum5);
        tree.add(hum6);
        tree.add(hum7);
        tree.add(hum8);
        tree.add(hum9);
        tree.add(hum10);


        int select = getNumberMainMenu();

        if (select == 1) {
            printAll(tree, "tree.json");
        } else if (select == 2) {
            addNewPerson(tree);
            writeInJSONFile(tree);
        } else if (select == 3) {
            int research = getNumberResearchMenu();
            if (research == 1) {               // выявить родство 2х людей
                System.out.println(isRelative(tree));
            } else if (research == 2) {        // показать всех детей
                System.out.println(showKids(tree));
            } else if (research == 3) {        // показать всех родных братьев и сестер
                System.out.println(showSiblings(tree));
            } else if (research == 4) {        // показать родителей
                System.out.println(showParents(tree));
            } else if (research == 5) {        // показать супруга
                System.out.println(showSpouse(tree));
            }
        } else System.out.println("Некорректный ввод!");


//        System.out.println();
//        System.out.println(hum1.isParent(hum2));
//        System.out.println(hum5.isSibling(hum1));
//        System.out.println(hum1.isSpouse(hum4));
//        System.out.println(isCousins(tree, hum6, hum1));
//        System.out.println("Список детей:\n" + kids(tree, hum2));
//        System.out.println(tree);

//        Gson g = new Gson();
//        Human girl5 = g.fromJson(getDataFromFile("*.json"), Human.class);
    }




    // методы меню для пользователя
    public static int getNumberMainMenu() {
        System.out.println("""
                Выберите одну из команд:
                1 - показать всех людей из списка
                2 - добавить человека в список
                3 - провести исследование на родство
                
                >""");
        try {
            return input.nextInt();
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getNumberResearchMenu() {
        System.out.println("""
                Выберите одну из команд:
                1 - выявить родство 2х людей (родители/дети, братья/сестры, супруги)
                2 - показать всех детей
                3 - показать всех родных братьев и сестер
                4 - показать родителей
                5 - показать супруга

                >""");
        try {
            return input.nextInt();
        } catch (Exception e) {
            return -1;
        }
    }


    // методы главного меню
    public static List<Human> addNewPerson(List<Human> tree) {

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
            boolean sex = true;
            if (personSex.equals("м")) sex = true;
            if (personSex.equals("ж")) sex = false;
            System.out.println("Введите ID матери (при отсутствии данных введите 0):");
            int motherID = input.nextInt();
            System.out.println("Введите ID отца (при отсутствии данных введите 0):");
            int fatherID = input.nextInt();
            System.out.println("Введите ID супруга (при отсутствии данных введите 0):");
            int spouseID = input.nextInt();

            Human hum = new Human(name, year, month, day, sex, motherID, fatherID, spouseID);
            tree.add(hum);
            return tree;
        } catch (Exception e) {
            System.out.println("Введены неверные данные");
        }
        return tree;
    }

    public static void printAll(List<Human> tree, String path) {
        System.out.println(getDataFromJSONFile(path));
        System.out.println("\n___________________");
        System.out.println("Список всех людей: ");
        for (Human h : tree) {
            System.out.println(h);
        }
    }

    public static void writeInJSONFile(List<Human> tree){
        try(FileWriter writer = new FileWriter("src/tree.json", false))
        {
            StringBuilder json = new StringBuilder();
            List<String> resultList = new ArrayList<>();
            for (Human hum : tree) {
                resultList.add(hum.printJSON());
            }
            json.append("[\n");
            json.append(String.join(",\n", resultList));
            json.append("\n]");

            writer.append(json);
            writer.flush();
            System.out.println("Данные успешно записаны в файл");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }


    // методы для проведения исследования на родство
    public static String isRelative(List<Human> tree){
        try {
            System.out.println("Введите ID первого человека:");
            int id1 = input.nextInt();
            System.out.println("Введите ID второго человека:");
            int id2 = input.nextInt();

            Human h1 = findHuman(tree, id1);
            Human h2 = findHuman(tree, id2);

            // родители
            if (id1 == h2.getMotherID()) {
                return String.format("%s  - мать для человека по имени %s",h1.getName(),h2.getName());
            }
            else if (id2 == h1.getMotherID()) {
                return String.format("%s  - мать для человека по имени %s",h2.getName(),h1.getName());
            }
            else if (id1 == h2.getFatherID()) {
                return String.format("%s  - отец для человека по имени %s",h1.getName(),h2.getName());
            }
            else if (id2 == h1.getFatherID()) {
                return String.format("%s  - отец для человека по имени %s",h2.getName(),h1.getName());
            }

            // братья/сестры
            if (h1.isSibling(h2)) {
                return String.format("%s и %s - родные братья/сестры",h2.getName(),h1.getName());
            }

            // двоюродные братья/сестры
            if (isCousins(tree, h1, h2)) {
                return String.format("%s и %s - двоюродные братья/сестры",h2.getName(),h1.getName());
            }

            // супруги
            if (h1.isSpouse(h2)) {
                return String.format("%s и %s - супруги",h2.getName(),h1.getName());
            }

            // бабушки, дедушки и тп
            else return "Другая родственная связь или отсутствие таковой";

        } catch (Exception e) {
            return "Введены неверные данные";
        }

    }

    public static String showKids(List<Human> tree){
        try {
            System.out.println("Введите ID человека:");
            int id = input.nextInt();
            Human hum = findHuman(tree, id);

            if (kids(tree, hum).size() != 0) {
                return "Дети:\n" + kids(tree, hum);
            }
            else return "У человека нет детей";

        } catch (Exception e) {
            System.out.println("Введены неверные данные");
        }
        return "Нет данных о детях";
    }

    public static String showParents(List<Human> tree){
        try {
            System.out.println("Введите ID человека:");
            int id = input.nextInt();
            Human hum = findHuman(tree, id);

            return "Мать: " + findHuman(tree, hum.getMotherID()).getName() +
                    "\nОтец: " + findHuman(tree, hum.getFatherID()).getName();

        } catch (Exception e) {
            System.out.println("Введены неверные данные");
        }
        return "Нет данных о родителях";
    }

    public static String showSpouse(List<Human> tree){
        try {
            System.out.println("Введите ID человека:");
            int id = input.nextInt();
            Human hum = findHuman(tree, id);

            return "Супруг/а: " + findHuman(tree, hum.getSpouseID()).getName();

        } catch (Exception e) {
            System.out.println("Введены неверные данные");
        }
        return "Нет данных о родителях";
    }

    public static String showSiblings(List<Human> tree) {
        try {
            System.out.println("Введите ID человека:");
            int id = input.nextInt();
            Human hum = findHuman(tree, id);
            List<Human> siblings = new ArrayList<>();

            for (Human h: tree) {
                if (hum.isSibling(h) && id != h.getPersonalID()) {
                    siblings.add(h);
                }
            }
            if (siblings.size() != 0) {
                return "Родные братья/сестры: " + siblings;
            } else return "Нет братьев/сестер";
        }
        catch (Exception e) {
            System.out.println("Введены неверные данные");
        }
        return "Нет данных о братьях/сестрах";
    }


    // вспомогательные методы
    public static Human findHuman(List<Human> tree, int id) {
        for (Human hum : tree) {
            if (hum.getPersonalID() == id) return hum;
        }
        return null;
    }

    public static List<Human> kids(List<Human> tree, Human person) {
        List<Human> kids = new ArrayList<>();
        for (Human hum : tree) {
            if (hum.getMotherID() == person.getPersonalID() || hum.getFatherID() == person.getPersonalID())
                kids.add(hum);
        }
        return kids;
    }

    public static Boolean isCousins(List<Human> tree, Human cous_1, Human cous_2) {
        Human m1 = findHuman(tree, cous_1.getMotherID());
        Human f1 = findHuman(tree, cous_1.getFatherID());
        Human m2 = findHuman(tree, cous_2.getMotherID());
        Human f2 = findHuman(tree, cous_2.getFatherID());

        if (m1 != null && m2 != null) {
            return m1.isSibling(m2);
        }
        if (m1 != null && f2 != null) {
            return m1.isSibling(f2);
        }
        if (f1 != null && m2 != null) {
            return f1.isSibling(m2);
        }
        if (f1 != null && f2 != null) {
            return f1.isSibling(f2);
        } else return false;

    }

    public static String getDataFromJSONFile(String path) {
        //TODO метод для считывания данных о людях из файла JSON
        return "Данные успешно считаны";
    }
}
