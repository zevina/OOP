import javax.swing.*;
import java.awt.*;

public class NotebookView {

    static JFrame jFrame;
    static JPanel jPanel = new JPanel();

    public NotebookView(Notebook<Note> notebook) {
        NotebookView(notebook);
    }

    public static void NotebookView(Notebook<Note> notebook) {
        setUIFont(new javax.swing.plaf.FontUIResource("Montserrat", Font.PLAIN, 14));
        Font font2 = new Font("Montserrat", Font.PLAIN, 10);
        jFrame = getJNoteFrame();
        jFrame.add(jPanel);
        jPanel.setBackground(Color.LIGHT_GRAY);

        int rows = notebook.getNotebookSize();
        JTextArea textArea = new JTextArea(rows,40);
        textArea.setLineWrap(true);
        textArea.setText(notebook.printWindow());
        jPanel.add(textArea);
    }

    static JFrame getJNoteFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 325, dimension.height / 2 - 175, 650, 350);
        jFrame.setTitle("Планировщик задач");
//        jFrame.setResizable(false);
        return jFrame;
    }

    //установка пользовательского шрифта
    public static void setUIFont(javax.swing.plaf.FontUIResource f) {
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put(key, f);
        }
    }
}
