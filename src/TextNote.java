import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class TextNote extends Note implements Serializable {

    private String text;

    public TextNote(int day, int month, int year, String fio, String priority) {
        super.id = idCounter.addAndGet(1);
        super.date = LocalDate.now();
        super.time = LocalTime.now();
        super.deadline = LocalDate.of(year, month, day);
        super.fio = fio;
        super.priority = priorityToClass(priority);
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return  super.getDate() + ", " + super.getTime()  + "\n" +
                "Срок выполнения: " + super.getDeadline() + "\n" +
                "Автор: " + super.getFio()  + "\n" +
                "приоритет: " + super.priorityToString() + "\n____________________\n" + text  + "\n\n\n";
    }
}
