import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Human implements Serializable, Comparable<Human> {

    private static final long serialVersionUID = -7620980782155224836L;
    private static AtomicLong counter = new AtomicLong(1000);

    private long personalID;
    private String name;
    private LocalDate date;
    private String sex;
    private Human father;
    private Human mother;
    private List<Human> kids;
    private List<Communication> communicationList;

    public static long nextId() {
        return counter.incrementAndGet();
    }  // генерация уникальных ID

    public Human(String name, int year, int month, int day, String sex) {
        this.name = name;
        this.date = LocalDate.of(year, month, day);
        this.sex = sex;
        this.communicationList = new ArrayList<>();
        this.kids = new ArrayList<>();
        this.personalID = Human.nextId();
    }

    public Human() {
    }

    // геттеры и сеттеры
    public long getPersonalID() {
        return personalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getKids() {
        return kids;
    }

    public List<Communication> getCommunicationList() {
        return communicationList;
    }


    // методы для добавления родственных связей
    public void addCommunication(Human human, TypeCommunication typeCommunication) {
        communicationList.add(new Communication(human, typeCommunication));
        if (typeCommunication == TypeCommunication.FATHER) {
            this.father = human;
        }
        if (typeCommunication == TypeCommunication.MOTHER) {
            this.mother = human;
        }
        if (typeCommunication == TypeCommunication.SON || typeCommunication == TypeCommunication.DAUGHTER) {
            addKid(human);
        }
    }

    public void addKid(Human human) {
        kids.add(human);
    }


    // методы для отображения родственных связей
    public void showKids() {
        if (kids.size() != 0) {
            System.out.println("\nДети:");
            for (Human h : kids) {
                if (h.getSex().equals("Ж")) {
                    System.out.println("Дочь - " + h);
                } else System.out.println("Сын  - " + h);
            }
        } else System.out.println("\nНет данных о детях");
    }

    public void showParents() {
        if (father != null || mother != null) {
            System.out.println("Родители:");
            if (father != null) {
                System.out.println("Отец:" + father);
            }
            if (mother != null) {
                System.out.println("Мать:" + mother);
            }
        } else System.out.println("Нет данных");
    }

    public void showSiblings() {
        try {
            List<Human> children = mother.getKids();
            if (children.size() > 1) {
                System.out.println("Братья/сестры:");
                for (Human h : children) {
                    if (h != this) {
                        System.out.println(h);
                    }
                }
            } else System.out.println("Нет данных о братьях/сестрах");
        } catch (NullPointerException e) {
            System.out.println("Нет данных о братьях/сестрах");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void showSpouse() {

    }

    @Override
    public String toString() {
        return "ID: " + personalID +
                "  Имя: " + String.format("%-10s", name) +
                " дата рождения: " + date +
                ", пол: " + sex;
    }

    @Override
    public int compareTo(Human o) {
        if (date.isBefore(o.getDate())) {
            return -1;
        } else if (date.isAfter(o.getDate())) {
            return 1;
        } else return 0;
    }


}

