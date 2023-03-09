import java.util.Objects;

class Innerapp {
    IInterface v;

    public Innerapp(IInterface v) {
        this.v = v;
//         this.v = Objects.requireNonNull(v, "Интерфейс не может быть null");
    }

    void write() {
        try {
            v.print();
        } catch (Exception IllegalArgumentException) {
            System.out.println(IllegalArgumentException.getMessage());
        }

    }

}