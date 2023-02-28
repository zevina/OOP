import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Notebook<T> implements Iterable<T>, Serializable {

    private List<T> notebook;

    public Notebook() {
        this.notebook = new ArrayList<>();
    }

    public void addNote(T note){
        notebook.add(note);
    }

    public void removeNote(T note){
        notebook.add(note);
    }

    public List<T> getNotebook() {
        return notebook;
    }

    public void setNotebook(List<T> notebook) {
        this.notebook = notebook;
    }

    public int getNotebookSize() {
        return notebook.size();
    }

    public String printWindow() {
        StringBuilder notebookToString = new StringBuilder();
//        notebookToString.append("<html>");
        for (T t : notebook) {
            notebookToString.append(t.toString());
        }
//        notebookToString.append("</html>");
        return notebookToString.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return notebook.iterator();
    }
}
