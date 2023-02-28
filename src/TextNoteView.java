import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TextNoteView {

    static JFrame jFrame;
    static JPanel jPanel = new JPanel();

    public TextNoteView(Notebook<Note> notebook) {
        TextNoteView(notebook);
    }

    public static void TextNoteView(Notebook<Note> notebook) {
        setUIFont(new javax.swing.plaf.FontUIResource("Montserrat", Font.PLAIN, 14));
        Font font2 = new Font("Montserrat", Font.PLAIN, 10);
        jFrame = getJNoteFrame();
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
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(jPanel);
                File file = fileChooser.getSelectedFile();
                System.out.println(file.getName());
                try {
                    FileHandler.readFile(file.getName());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(jPanel,"Ошибка при открытии файла");
                }
            }
        });
        JMenu save = new JMenu("Сохранить как");
        JMenuItem json = new JMenuItem("json");
        JMenuItem xml = new JMenuItem("xml");
        JMenuItem csv = new JMenuItem("csv");
        save.add(json);
        save.add(csv);
        save.add(xml);
        JMenuItem exit = new JMenuItem("Выход");
        json.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(jPanel);
                File file = fileChooser.getSelectedFile();
                FileHandler.writeJSONFile(file.getName(), notebook);
                JOptionPane.showMessageDialog(jPanel,"json файл сохранен");
                System.out.println("json saved");
            }
        });
        xml.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(jPanel);
                File file = fileChooser.getSelectedFile();
                FileHandler.writeXMLFile(file.getName(), notebook);
                JOptionPane.showMessageDialog(jPanel,"xml файл сохранен");
                System.out.println("xml saved");
            }
        });
        csv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(jPanel);
                File file = fileChooser.getSelectedFile();
                FileHandler.writeCSVFile(file.getName(), notebook);
                JOptionPane.showMessageDialog(jPanel,"csv файл сохранен");
                System.out.println("csv saved");

            }
        });
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




        // создание текстовой заметки
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.location(0,0);
        jPanel.setLayout(gridBagLayout);

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.gridwidth = 2;
        constraints1.gridheight = 1;
        constraints1.fill = 2;
        JLabel mLabel = new JLabel("ФИО автора: ");
        jPanel.add(mLabel,constraints1);

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.weightx = 0;
        constraints2.weighty = 0;
        constraints2.gridx = 2;
        constraints2.gridy = 0;
        constraints2.gridwidth = 9;
        constraints2.gridheight = 1;
        constraints2.fill = 8;
        JTextArea fioTextArea = new JTextArea(1,32);
        jPanel.add(fioTextArea,constraints2);

        GridBagConstraints constraints5 = new GridBagConstraints();
        constraints5.weightx = 0;
        constraints5.weighty = 0;
        constraints5.gridx = 0;
        constraints5.gridy = 1;
        constraints5.gridwidth = 2;
        constraints5.gridheight = 1;
        constraints1.fill = 2;
        JLabel pLabel = new JLabel("Приоритет задачи: ");
        jPanel.add(pLabel,constraints5);

        GridBagConstraints constraints4 = new GridBagConstraints();
        constraints4.weightx = 0;
        constraints4.weighty = 0;
        constraints4.gridx = 2;
        constraints4.gridy = 1;
        constraints4.gridwidth = 2;
        constraints4.gridheight = 1;
        constraints2.fill = 2;
        JComboBox jComboBox = new JComboBox<String>();
        jComboBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
        jComboBox.addItem("низкий");
        jComboBox.addItem("средний");
        jComboBox.addItem("высокий");
        jPanel.add(jComboBox,constraints4);

        GridBagConstraints constraints6 = new GridBagConstraints();
        constraints6.weightx = 0;
        constraints6.weighty = 0;
        constraints6.gridx = 4;
        constraints6.gridy = 1;
        constraints6.gridwidth = 1;
        constraints6.gridheight = 1;
        constraints1.fill = 1;
        JLabel dLabel = new JLabel("           Дата выполнения: ");
        jPanel.add(dLabel,constraints6);

        GridBagConstraints constraints7 = new GridBagConstraints();
        constraints7.weightx = 0;
        constraints7.weighty = 0;
        constraints7.gridx = 5;
        constraints7.gridy = 1;
        constraints7.gridwidth = 1;
        constraints7.gridheight = 1;
        constraints2.fill = 1;
        JComboBox dComboBox = new JComboBox<String>();
        dComboBox.addItem(1);
        dComboBox.addItem(2);
        dComboBox.addItem(3);
        dComboBox.addItem(4);
        dComboBox.addItem(5);
        dComboBox.addItem(6);
        dComboBox.addItem(7);
        dComboBox.addItem(8);
        dComboBox.addItem(9);
        dComboBox.addItem(10);
        dComboBox.addItem(11);
        dComboBox.addItem(12);
        dComboBox.addItem(13);
        dComboBox.addItem(14);
        dComboBox.addItem(15);
        dComboBox.addItem(16);
        dComboBox.addItem(17);
        dComboBox.addItem(18);
        dComboBox.addItem(19);
        dComboBox.addItem(20);
        dComboBox.addItem(21);
        dComboBox.addItem(22);
        dComboBox.addItem(23);
        dComboBox.addItem(24);
        dComboBox.addItem(25);
        dComboBox.addItem(26);
        dComboBox.addItem(27);
        dComboBox.addItem(28);
        dComboBox.addItem(29);
        dComboBox.addItem(30);
        dComboBox.addItem(31);
        jPanel.add(dComboBox,constraints7);

        GridBagConstraints constraints8 = new GridBagConstraints();
        constraints8.weightx = 0;
        constraints8.weighty = 0;
        constraints8.gridx = 6;
        constraints8.gridy = 1;
        constraints8.gridwidth = 2;
        constraints8.gridheight = 1;
        constraints2.fill = 2;
        JComboBox mComboBox = new JComboBox<String>();
        mComboBox.addItem("январь");
        mComboBox.addItem("февраль");
        mComboBox.addItem("март");
        mComboBox.addItem("апрель");
        mComboBox.addItem("май");
        mComboBox.addItem("июнь");
        mComboBox.addItem("июль");
        mComboBox.addItem("август");
        mComboBox.addItem("сентябрь");
        mComboBox.addItem("октябрь");
        mComboBox.addItem("ноябрь");
        mComboBox.addItem("декабрь");
        jPanel.add(mComboBox,constraints8);

        GridBagConstraints constraints9 = new GridBagConstraints();
        constraints9.weightx = 0;
        constraints9.weighty = 0;
        constraints9.gridx = 8;
        constraints9.gridy = 1;
        constraints9.gridwidth = 1;
        constraints9.gridheight = 1;
        constraints2.fill = 1;
        JComboBox yComboBox = new JComboBox<String>();
        yComboBox.addItem(2023);
        yComboBox.addItem(2024);
        yComboBox.addItem(2025);
        jPanel.add(yComboBox,constraints9);

        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.weightx = 0;
        constraints3.weighty = 0;
        constraints3.gridx = 0;
        constraints3.gridy = 2;
        constraints3.gridwidth = 11;
        constraints3.gridheight = 6;
        constraints3.fill = 11;
        JTextArea textArea = new JTextArea(10,41);
        jPanel.add(textArea,constraints3);

        GridBagConstraints constraints10 = new GridBagConstraints();
        constraints10.weightx = 0;
        constraints10.weighty = 0;
        constraints10.gridx = 7;
        constraints10.gridy = 21;
        constraints10.gridwidth = 2;
        constraints10.gridheight = 1;
        constraints2.fill = 3;
        JButton sButton = new JButton("     Сохранить      ");
        jPanel.add(sButton,constraints10);
        sButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int day = dComboBox.getSelectedIndex()+1;
                int month = mComboBox.getSelectedIndex()+1;
                int year = (Integer) yComboBox.getItemAt(yComboBox.getSelectedIndex());
                String fio = fioTextArea.getText();
                String priority = (String) jComboBox.getItemAt(jComboBox.getSelectedIndex());
                System.out.println(day);
                System.out.println(month);
                System.out.println(year);
                System.out.println(fio);
                System.out.println(priority);
                String text = textArea.getText();
                TextNote note = new TextNote(day, month, year, fio, priority);
                note.setText(text);
                notebook.addNote(note);
                try {
                    FileHandler.writeFile("Notebook.out", notebook);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(jPanel, "Ошибка при сохранении файла");
                }
            }
        });

        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
        Border border1 = BorderFactory.createTitledBorder(border,"Текстовая заметка", 0, 0, font2, Color.DARK_GRAY);
        jPanel.setBorder(border1);


        jPanel.revalidate();
    }

    static JFrame getJNoteFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 325, dimension.height / 2 - 175, 650, 350);
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

//    static class NewTextNote extends Dialog {
//
//        public NewTextNote() {
//            super(getJNoteFrame(), "Создание новой текстовой заметки", false); // true - модальное окно
//
//            Font font2 = new Font("Montserrat", Font.PLAIN, 10);
//            jFrame = getJNoteFrame();
//            jFrame.add(jPanel);
//            jPanel.setBackground(Color.LIGHT_GRAY);
//
////            // Строка меню
////            JMenuBar jMenuBar = new JMenuBar();
////            JMenu file = new JMenu("Файл");
////            jMenuBar.add(file);
////            JMenuItem open = new JMenuItem("Открыть");
////            open.addActionListener(new ActionListener() {
////                @Override
////                public void actionPerformed(ActionEvent e) {
////                    JFileChooser fileChooser = new JFileChooser();
////                    fileChooser.showOpenDialog(jPanel);
////                    File file = fileChooser.getSelectedFile();
////                    System.out.println(file.getName());
////                    try {
////                        FileHandler.readFile(file.getName());
////                    } catch (Exception ex) {
////                        JOptionPane.showMessageDialog(jPanel,"Ошибка при открытии файла");
////                    }
////                }
////            });
////            JMenu save = new JMenu("Сохранить как");
////            JMenuItem json = new JMenuItem("json");
////            JMenuItem xml = new JMenuItem("xml");
////            JMenuItem csv = new JMenuItem("csv");
////            save.add(json);
////            save.add(csv);
////            save.add(xml);
////            JMenuItem exit = new JMenuItem("Выход");
////            json.addActionListener(new ActionListener() {
////                @Override
////                public void actionPerformed(ActionEvent e) {
////                    JFileChooser fileChooser = new JFileChooser();
////                    fileChooser.showSaveDialog(jPanel);
////                    File file = fileChooser.getSelectedFile();
////                    FileHandler.writeJSONFile(file.getName(), notebook);
////                    JOptionPane.showMessageDialog(jPanel,"json файл сохранен");
////                    System.out.println("json saved");
////                }
////            });
////            xml.addActionListener(new ActionListener() {
////                @Override
////                public void actionPerformed(ActionEvent e) {
////                    JFileChooser fileChooser = new JFileChooser();
////                    fileChooser.showSaveDialog(jPanel);
////                    File file = fileChooser.getSelectedFile();
////                    FileHandler.writeXMLFile(file.getName(), notebook);
////                    JOptionPane.showMessageDialog(jPanel,"xml файл сохранен");
////                    System.out.println("xml saved");
////                }
////            });
////            csv.addActionListener(new ActionListener() {
////                @Override
////                public void actionPerformed(ActionEvent e) {
////                    JFileChooser fileChooser = new JFileChooser();
////                    fileChooser.showSaveDialog(jPanel);
////                    File file = fileChooser.getSelectedFile();
////                    FileHandler.writeCSVFile(file.getName(), notebook);
////                    JOptionPane.showMessageDialog(jPanel,"csv файл сохранен");
////                    System.out.println("csv saved");
////
////                }
////            });
////            exit.addActionListener(new ActionListener() {
////                @Override
////                public void actionPerformed(ActionEvent e) {
////                    System.exit(0);
////                }
////            });
////            file.add(open);
////            file.add(save);
////            file.addSeparator();
////            file.add(exit);
////            jFrame.setJMenuBar(jMenuBar);
//
//
//
//
//            // создание текстовой заметки
//            GridBagLayout gridBagLayout = new GridBagLayout();
//            gridBagLayout.location(0,0);
//            jPanel.setLayout(gridBagLayout);
//
//            GridBagConstraints constraints1 = new GridBagConstraints();
//            constraints1.weightx = 0;
//            constraints1.weighty = 0;
//            constraints1.gridx = 0;
//            constraints1.gridy = 0;
//            constraints1.gridwidth = 2;
//            constraints1.gridheight = 1;
//            constraints1.fill = 2;
//            JLabel mLabel = new JLabel("ФИО автора: ");
//            jPanel.add(mLabel,constraints1);
//
//            GridBagConstraints constraints2 = new GridBagConstraints();
//            constraints2.weightx = 0;
//            constraints2.weighty = 0;
//            constraints2.gridx = 2;
//            constraints2.gridy = 0;
//            constraints2.gridwidth = 9;
//            constraints2.gridheight = 1;
//            constraints2.fill = 8;
//            JTextArea fioTextArea = new JTextArea(1,32);
//            jPanel.add(fioTextArea,constraints2);
//
//            GridBagConstraints constraints5 = new GridBagConstraints();
//            constraints5.weightx = 0;
//            constraints5.weighty = 0;
//            constraints5.gridx = 0;
//            constraints5.gridy = 1;
//            constraints5.gridwidth = 2;
//            constraints5.gridheight = 1;
//            constraints1.fill = 2;
//            JLabel pLabel = new JLabel("Приоритет задачи: ");
//            jPanel.add(pLabel,constraints5);
//
//            GridBagConstraints constraints4 = new GridBagConstraints();
//            constraints4.weightx = 0;
//            constraints4.weighty = 0;
//            constraints4.gridx = 2;
//            constraints4.gridy = 1;
//            constraints4.gridwidth = 2;
//            constraints4.gridheight = 1;
//            constraints2.fill = 2;
//            JComboBox jComboBox = new JComboBox<String>();
//            jComboBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
//            jComboBox.addItem("низкий");
//            jComboBox.addItem("средний");
//            jComboBox.addItem("высокий");
//            jPanel.add(jComboBox,constraints4);
//
//            GridBagConstraints constraints6 = new GridBagConstraints();
//            constraints6.weightx = 0;
//            constraints6.weighty = 0;
//            constraints6.gridx = 4;
//            constraints6.gridy = 1;
//            constraints6.gridwidth = 1;
//            constraints6.gridheight = 1;
//            constraints1.fill = 1;
//            JLabel dLabel = new JLabel("           Дата выполнения: ");
//            jPanel.add(dLabel,constraints6);
//
//            GridBagConstraints constraints7 = new GridBagConstraints();
//            constraints7.weightx = 0;
//            constraints7.weighty = 0;
//            constraints7.gridx = 5;
//            constraints7.gridy = 1;
//            constraints7.gridwidth = 1;
//            constraints7.gridheight = 1;
//            constraints2.fill = 1;
//            JComboBox dComboBox = new JComboBox<String>();
//            dComboBox.addItem(1);
//            dComboBox.addItem(2);
//            dComboBox.addItem(3);
//            dComboBox.addItem(4);
//            dComboBox.addItem(5);
//            dComboBox.addItem(6);
//            dComboBox.addItem(7);
//            dComboBox.addItem(8);
//            dComboBox.addItem(9);
//            dComboBox.addItem(10);
//            dComboBox.addItem(11);
//            dComboBox.addItem(12);
//            dComboBox.addItem(13);
//            dComboBox.addItem(14);
//            dComboBox.addItem(15);
//            dComboBox.addItem(16);
//            dComboBox.addItem(17);
//            dComboBox.addItem(18);
//            dComboBox.addItem(19);
//            dComboBox.addItem(20);
//            dComboBox.addItem(21);
//            dComboBox.addItem(22);
//            dComboBox.addItem(23);
//            dComboBox.addItem(24);
//            dComboBox.addItem(25);
//            dComboBox.addItem(26);
//            dComboBox.addItem(27);
//            dComboBox.addItem(28);
//            dComboBox.addItem(29);
//            dComboBox.addItem(30);
//            dComboBox.addItem(31);
//            jPanel.add(dComboBox,constraints7);
//
//            GridBagConstraints constraints8 = new GridBagConstraints();
//            constraints8.weightx = 0;
//            constraints8.weighty = 0;
//            constraints8.gridx = 6;
//            constraints8.gridy = 1;
//            constraints8.gridwidth = 2;
//            constraints8.gridheight = 1;
//            constraints2.fill = 2;
//            JComboBox mComboBox = new JComboBox<String>();
//            mComboBox.addItem("январь");
//            mComboBox.addItem("февраль");
//            mComboBox.addItem("март");
//            mComboBox.addItem("апрель");
//            mComboBox.addItem("май");
//            mComboBox.addItem("июнь");
//            mComboBox.addItem("июль");
//            mComboBox.addItem("август");
//            mComboBox.addItem("сентябрь");
//            mComboBox.addItem("октябрь");
//            mComboBox.addItem("ноябрь");
//            mComboBox.addItem("декабрь");
//            jPanel.add(mComboBox,constraints8);
//
//            GridBagConstraints constraints9 = new GridBagConstraints();
//            constraints9.weightx = 0;
//            constraints9.weighty = 0;
//            constraints9.gridx = 8;
//            constraints9.gridy = 1;
//            constraints9.gridwidth = 1;
//            constraints9.gridheight = 1;
//            constraints2.fill = 1;
//            JComboBox yComboBox = new JComboBox<String>();
//            yComboBox.addItem(2023);
//            yComboBox.addItem(2024);
//            yComboBox.addItem(2025);
//            jPanel.add(yComboBox,constraints9);
//
//            GridBagConstraints constraints3 = new GridBagConstraints();
//            constraints3.weightx = 0;
//            constraints3.weighty = 0;
//            constraints3.gridx = 0;
//            constraints3.gridy = 2;
//            constraints3.gridwidth = 11;
//            constraints3.gridheight = 6;
//            constraints3.fill = 11;
//            jPanel.add(new JTextArea(10,41),constraints3);
//
//            GridBagConstraints constraints10 = new GridBagConstraints();
//            constraints10.weightx = 0;
//            constraints10.weighty = 0;
//            constraints10.gridx = 7;
//            constraints10.gridy = 21;
//            constraints10.gridwidth = 2;
//            constraints10.gridheight = 1;
//            constraints2.fill = 3;
//            JButton sButton = new JButton("     Сохранить      ");
//            jPanel.add(sButton,constraints10);
//            sButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//
//                }
//            });
//
//            Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
//            Border border1 = BorderFactory.createTitledBorder(border,"Текстовая заметка", 0, 0, font2, Color.DARK_GRAY);
//            jPanel.setBorder(border1);
//
//
//            jPanel.revalidate();
//
//        }
//    }
}
