import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class AudioNote extends Note  implements Serializable {

    private AudioRecord audio;
    private String description;

    public AudioNote(int day, int month, int year, String fio, String priority) {
        super.id = idCounter.addAndGet(1);
        super.date = LocalDate.now();
        super.time = LocalTime.now();
        super.deadline = LocalDate.of(year, month, day);
        super.fio = fio;
        super.priority = priorityToClass(priority);
    }

    public void setAudio(AudioRecord audio) {
        this.audio = audio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  super.getDate() + ", " + super.getTime()  + "\n" +
                "Срок выполнения: " + super.getDeadline()  + "\n" +
                "Автор: " + super.getFio() + "\n"  +
                "приоритет: " + super.priorityToString() + "\n____________________\n" +
                description + "\n" + "*** some audio-record ***"  + "\n\n\n";
    }

}
