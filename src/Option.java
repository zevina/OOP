import com.sun.source.tree.Tree;

public interface Option {
    public String description();
    public void execute();
    public void run(int id);

}
