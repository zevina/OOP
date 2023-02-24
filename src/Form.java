import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class Form extends JFrame {

    JTextField idRequestField;
    JTextField nameField;
    JTextField motherIDField;
    JTextField fatherIDField;
    JTextField spouseIDField;
    JTextField dayField;
    JTextField monthField;
    JTextField yearField;

    int id;
    int i;
    List<Option> commandList;
    boolean flag = false;
    Tree tree;

    public Form() throws HeadlessException {
        super("Добавить нового человека");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        super.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 250, 400, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = super.getContentPane();
        container.setLayout(new GridLayout(9, 2, 10, 5));

        JLabel name = new JLabel("Имя: ");
        name.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(name);
        nameField = new JTextField();
        container.add(nameField);

        JLabel day = new JLabel("День: ");
        day.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(day);
        dayField = new JTextField();
        container.add(dayField);

        JLabel month = new JLabel("Месяц: ");
        month.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(month);
        monthField = new JTextField();
        container.add(monthField);

        JLabel year = new JLabel("Год: ");
        year.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(year);
        yearField = new JTextField();
        container.add(yearField);

        JRadioButton male = new JRadioButton("мужской");
        male.setHorizontalAlignment(SwingConstants.RIGHT);
        male.setSelected(true);
        JRadioButton female = new JRadioButton("женский");
        container.add(male);
        container.add(female);

        JLabel motherID = new JLabel("ID матери: ");
        motherID.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(motherID);
        motherIDField = new JTextField();
        container.add(motherIDField);

        JLabel fatherID = new JLabel("ID отца: ");
        fatherID.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(fatherID);
        fatherIDField = new JTextField();
        container.add(fatherIDField);

        JLabel spouseID = new JLabel("ID супруга: ");
        spouseID.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(spouseID);
        spouseIDField = new JTextField();
        container.add(spouseIDField);

        JLabel space = new JLabel("_____________________________");
        container.add(space);
        space.setHorizontalAlignment(SwingConstants.RIGHT);
        JButton send = new JButton("Отправить");
        container.add(send);

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String res = "";

                try {
                    String name = nameField.getText();
                    int day = Integer.parseInt(dayField.getText());
                    int month = Integer.parseInt(monthField.getText());
                    int year = Integer.parseInt(yearField.getText());

                    String sex = "";
                    if (male.isSelected()) sex = "М";
                    else sex = "Ж";

                    int motherID = Integer.parseInt(motherIDField.getText());
                    int fatherID = Integer.parseInt(fatherIDField.getText());
                    int spouseID = Integer.parseInt(spouseIDField.getText());

                    Human human = new Human(name, year, month, day, sex);
                    tree.addHuman(human);
                    try {
                        human.addCommunication(tree.findHuman(motherID), TypeCommunication.MOTHER);
                        human.setMother(tree.findHuman(motherID));
                        tree.findHuman(motherID).addKid(human);

                        human.addCommunication(tree.findHuman(fatherID), TypeCommunication.FATHER);
                        human.setFather(tree.findHuman(fatherID));
                        tree.findHuman(fatherID).addKid(human);

                        for (Human h : tree) {
                            if (h.getFather() == human.getFather() && h.getMother() == human.getMother()) {
                                if (sex.equals("М")) {
                                    h.addCommunication(human, TypeCommunication.BROTHER);
                                    if (h.getSex().equals("М")) {
                                        human.addCommunication(h, TypeCommunication.BROTHER);
                                    } else human.addCommunication(h, TypeCommunication.SISTER);
                                }
                                if (sex.equals("Ж")) {
                                    h.addCommunication(human, TypeCommunication.SISTER);
                                    if (h.getSex().equals("М")) {
                                        human.addCommunication(h, TypeCommunication.BROTHER);
                                    } else human.addCommunication(h, TypeCommunication.SISTER);
                                }
                            }
                        }

                        if (sex.equals("М")) {
                            tree.findHuman(motherID).addCommunication(human, TypeCommunication.SON);
                            tree.findHuman(fatherID).addCommunication(human, TypeCommunication.SON);
                        } else {
                            tree.findHuman(motherID).addCommunication(human, TypeCommunication.DAUGHTER);
                            tree.findHuman(fatherID).addCommunication(human, TypeCommunication.DAUGHTER);
                        }

                        if (sex.equals("М")) {
                            human.addCommunication(tree.findHuman(spouseID), TypeCommunication.WIFE);
                            tree.findHuman(spouseID).addCommunication(human, TypeCommunication.HUSBAND);
                        } else {
                            human.addCommunication(tree.findHuman(spouseID), TypeCommunication.HUSBAND);
                            tree.findHuman(spouseID).addCommunication(human, TypeCommunication.WIFE);
                        }
                    } catch (Exception ignored) {
                    }
                    res = "Добавлено успешно";
                } catch (Exception exception) {
                    res = "Введены неверные данные";
                }

                Form addHuman = new Form("Добавить нового человека", res);
                addHuman.setVisible(true);
            }
        });


    }

    public Form(List<String> menu, List<Option> commandList) throws HeadlessException {
        super("Главное меню");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        super.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 250, 400, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.commandList = commandList;


        Container container = super.getContentPane();
        container.setLayout(new GridLayout(menu.size() + 3, 1, 100, 2));

        JLabel menuString = new JLabel("Выберите нужный пункт из списка команд: ");
        container.add(menuString);

        for (int i = 0; i < menu.size(); i++) {
            JButton menuItem = new JButton(menu.get(i));
            menuItem.setHorizontalAlignment(SwingConstants.LEFT);
            menuItem.setBackground(Color.getHSBColor(170, 10, 80));
            container.add(menuItem);
            ButtonMainManager buttonMainManager = new ButtonMainManager(i);
            menuItem.addActionListener(buttonMainManager);
        }

        JButton exitButton = new JButton("Выход");
        exitButton.setBackground(Color.getHSBColor(0, 24, 64));
        container.add(exitButton);
        ButtonExitManager exitButtonManager = new ButtonExitManager();
        exitButton.addActionListener(exitButtonManager);
    }

    public Form(String title, String text) {
        super(title);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        super.setBounds(dimension.width / 2 - 200 + 400, dimension.height / 2 - 250, 550, 500);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container container = super.getContentPane();
        container.setLayout(new GridLayout(1, 1, 1, 2));
        JLabel info = new JLabel(text);
        container.add(info);
    }

    public Form(Tree tree) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        super.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 75, 300, 150);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.tree = tree;

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(3, 1, 1, 2));

        JLabel idRequest = new JLabel("Введите ID человека: ");
        container.add(idRequest);
        idRequestField = new JTextField();
        container.add(idRequestField);
        JButton send = new JButton("Отправить");
        container.add(send);

//        ButtonIdManager buttonIdManager = new ButtonIdManager(iCom);
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id = Integer.parseInt(idRequestField.getText());
                System.out.println(id);
                for (Option c: commandList) {
                    System.out.println(c.toString());
                }
                commandList.get(i).run(id);
//
//                String res = "";
//                try {
//                    Human human = tree.findHuman(id);
//
//                    if (human.getFather() != null || human.getMother() != null) {
//                        StringBuilder parentsToString = new StringBuilder();
//                        parentsToString.append("<html>");
//                        parentsToString.append("Родители:");
//                        parentsToString.append("<br>");
//                        if (human.getFather() != null) {
//                            parentsToString.append("Отец:");
//                            parentsToString.append(human.toWindow(human.getFather().toString()));
//                        }
//                        if (human.getMother() != null) {
//                            parentsToString.append("Мать:");
//                            parentsToString.append(human.toWindow(human.getMother().toString()));
//                        }
//                        parentsToString.append("</html>");
//                        res = parentsToString.toString();
//                    } else res = "Нет данных";
//
//                } catch (Exception exc) {
//                    res = "Введены неверные данные";
//                }
//                Form showParents = new Form("Показать родителей выбранного человека", res);
//                showParents.setVisible(true);

            }
        });

    }


    public void setI(int i) {
        this.i = i;
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFlag() {
        return flag;
    }

    public List<Option> getCommandList() {
        return commandList;
    }

    public Tree getTree() {
        return tree;
    }

    public class ButtonMainManager implements ActionListener {

        int i;

        public ButtonMainManager(int i) {
            this.i = i;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            commandList.get(i).execute();
            System.out.println(i);

        }
    }

    public class ButtonExitManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public class ButtonIdManager implements ActionListener {

        int i;

        public ButtonIdManager(int i) {
            this.i = i;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            id = Integer.parseInt(idRequestField.getText());
            commandList.get(this.i).run(id);


        }
    }

}
