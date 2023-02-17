import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

public class Human {
    private static AtomicLong counter = new AtomicLong(1000);

    private long personalID;
    protected String name;
    protected LocalDate birthdate;
    protected boolean sex;

    protected int motherID;
    protected int fatherID;
    protected int spouseID;

    public static long nextId() {
        return counter.incrementAndGet();
    }  // генерация уникальных ID

    // конструкторы
    public Human(String name, int year, int month, int day, boolean sex, int motherID, int fatherID, int spouseID) {
        this.name = name;
        this.birthdate = LocalDate.of(year, month, day);
        this.sex = sex;
        this.motherID = motherID;
        this.fatherID = fatherID;
        this.spouseID = spouseID;
        this.personalID = Human.nextId();
    }

    public Human() {}

    // методы вывода
    @Override
    public String toString() {
        String sexFormatted;
        if (this.sex) {
            sexFormatted = "Мужской";
        } else sexFormatted = "Женский";

        return String.format("\nИмя: %s\nДата рождения: %s\nПол: %s\nПерсональный ID: %d\nМать: %d\nОтец: %d\nСупруг: %d\n",
                this.name, this.birthdate.toString(), sexFormatted, this.personalID, this.motherID, this.fatherID, this.spouseID);
    }

    public String printJSON(){
        return String.format("""
                {
                    "name": "%s",
                    "birthdate": "%s",
                    "sex": %s,
                    "personalID": %d,
                    "motherID": %d,
                    "fatherID": %d,
                    "spouseID": %d
                }""",
                this.name, this.birthdate.toString(), sex, this.personalID, this.motherID, this.fatherID, this.spouseID);
    }


    // методы для проверки родственных связей
    public boolean isParent(Human par) {
        if (par != null) {
            return this.motherID == par.personalID || this.fatherID == par.personalID;
        }
        return false;
    }

    public boolean isSpouse(Human sp) {
        if (sp != null) {
            return this.spouseID == sp.personalID;
        }
        return false;
    }

    public boolean isSibling(Human sib) {
        if (sib != null) {
            return this.motherID == (int) sib.motherID && this.fatherID == (int) sib.fatherID;
        }
        return false;
    }


    // геттеры и сеттеры
    public long getPersonalID() {
        return personalID;
    }

    public void setPersonalID(long personalID) {
        this.personalID = personalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int year, int month, int day) {
        this.birthdate = LocalDate.of(year, month, day);
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getMotherID() {
        return motherID;
    }

    public void setMotherID(Human mom) {
        this.motherID = (int) mom.personalID;
    }

    public int getFatherID() {
        return fatherID;
    }

    public void setFatherID(Human dad) {
        this.fatherID = (int) dad.personalID;
    }

    public int getSpouseID() {
        return spouseID;
    }

    public void setSpouseID(Human sp) {
        this.spouseID = (int) sp.personalID;
    }
}
