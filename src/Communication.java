import java.io.Serializable;

public class Communication implements Serializable {

    private static final long serialVersionUID = 4006521635819787312L;

    private Human human;
    private TypeCommunication typeCommunication;


    public Communication(Human human, TypeCommunication typeCommunication) {
        this.human = human;
        this.typeCommunication = typeCommunication;
    }

    public TypeCommunication getTypeCommunication() {
        return typeCommunication;
    }

    public Human getHuman() {
        return human;
    }

    @Override
    public String toString() {
        return human + ", родственная связь: " + typeCommunication;
    }
}
