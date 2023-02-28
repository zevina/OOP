import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainView {

    static JFrame jFrame;
    static JPanel jPanel = new JPanel();

    public static void MainView() throws IOException, ClassNotFoundException {

        // десериализация
        FileHandler fileHandler = new FileHandler();
        Notebook<Note> notebook = FileHandler.readFile("Notebook.out");
//        Notebook<Note> notebook = new Notebook<>();

//        TextNote textNote = new TextNote(28, 2, 2023, "Зевина Елена Юрьевна", "высокий");
//        textNote.setText("Сдать ДЗ по ООП на отлично");
//        notebook.addNote(textNote);
//
//        AudioNote audioNote = new AudioNote(28, 2, 2023, "Зевина Елена Юрьевна", "средний");
//        audioNote.setDescription("найти трек для плодотворной учебы");
//        notebook.addNote(audioNote);

//        fileHandler.writeFile("Notebook.out", notebook);

        setUIFont(new javax.swing.plaf.FontUIResource("Montserrat", Font.PLAIN, 14));
        Font font2 = new Font("Montserrat", Font.PLAIN, 10);
        jFrame = getJMainFrame();
        jFrame.add(jPanel);
        jPanel.setBackground(Color.LIGHT_GRAY);

        // Строка меню
        JMenuBar jMenuBar = new JMenuBar();
        JMenu file = new JMenu("Файл");
        jMenuBar.add(file);
        JMenuItem open = new JMenuItem("Открыть");
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileHandler.readFile("Notebook.out");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(jPanel, "Ошибка при открытии файла");
                    ;
                }
            }
        });
        JMenuItem save = new JMenuItem("Сохранить");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileHandler.writeFile("Notebook.out", notebook);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(jPanel, "Ошибка при сохранении файла");
                }
                JOptionPane.showMessageDialog(jPanel, "Блокнот сохранен");
                System.out.println("Notebook saved");
            }
        });
        JMenuItem exit = new JMenuItem("Выход");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);
        jFrame.setJMenuBar(jMenuBar);


        // главное меню
        jPanel.setLayout(new BorderLayout());

        JButton allButton = new JButton("Показать весь блокнот");
        allButton.setPreferredSize(new Dimension(200, 70));
        jPanel.add(allButton, BorderLayout.PAGE_START);
        allButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Notebook<Note> notebook = null;
                try {
                    notebook = FileHandler.readFile("Notebook.out");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(jPanel, "Ошибка при открытии файла");
                }
                NotebookView notebookView = new NotebookView(notebook);
            }
        });

        JButton newTextButton = new JButton("Создать новую текстовую заметку");
        newTextButton.setPreferredSize(new Dimension(200, 70));
        jPanel.add(newTextButton, BorderLayout.CENTER);
        newTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextNoteView textNoteView = new TextNoteView(notebook);
            }
        });

        JButton newAudioButton = new JButton("Создать новую аудио заметку");
        newAudioButton.setPreferredSize(new Dimension(200, 70));
        jPanel.add(newAudioButton, BorderLayout.PAGE_END);
        newAudioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AudioNoteView audioNoteView = new AudioNoteView(notebook);

            }
        });

        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
        Border border1 = BorderFactory.createTitledBorder(border, "Главное меню", 0, 0, font2, Color.DARK_GRAY);
        jPanel.setBorder(border1);


        jPanel.revalidate();
    }

    static JFrame getJMainFrame() {
        JFrame jFrame = new JFrame() {
        };
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 175, dimension.height / 2 - 150, 350, 300);
        jFrame.setTitle("Планировщик задач");
        jFrame.setResizable(false);
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
