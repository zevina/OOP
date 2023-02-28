import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Note implements Comparable<Note>, Serializable  {

    transient protected static AtomicInteger idCounter = new AtomicInteger(0);
    protected int id;
    protected LocalDate date;
    protected LocalTime time;
    protected LocalDate deadline;
    protected String fio;
    protected Priority priority;


    @Override
    public int compareTo(Note o) {
        return Integer.compare(this.getPriority(), o.getPriority());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getPriority() {
        if (this.priority == Priority.ROUTINE) {
            return 1;
        } else if (this.priority == Priority.IMPORTANT) {
            return 2;
        } else return 3;
    }

    public Priority priorityToClass(String priority) {
        if (priority.contains("низкий")) {
            return Priority.ROUTINE;
        } else if (priority.contains("средний")) {
            return Priority.IMPORTANT;
        } else return Priority.ASAP;
    }

    public String priorityToString() {
        if (this.priority == Priority.ROUTINE) {
            return "низкий";
        } else if (this.priority == Priority.IMPORTANT) {
            return "средний";
        } else return "высокий";
    }

    public abstract String toString();

}
