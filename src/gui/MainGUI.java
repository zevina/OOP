package gui;

import constants.CommonConstants;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.*;

public class MainGUI extends JFrame {

    static JFrame jFrame;
    static JPanel jPanel = new JPanel();

    public MainGUI() throws IOException {
    }

    public static void MainGUI(Logger logger) throws IOException, ClassNotFoundException {

        setUIFont(new javax.swing.plaf.FontUIResource("Montserrat", Font.PLAIN, 14));
        Font font2 = new Font("Montserrat", Font.PLAIN, 10);
        jFrame = getJMainFrame();
        jFrame.add(jPanel);
        jPanel.setBackground(Color.LIGHT_GRAY);


        // главное меню
        jPanel.setLayout(new BorderLayout());

        JButton allButton = new JButton("Рациональные числа");
        allButton.setPreferredSize(new Dimension(200, 120));
        jPanel.add(allButton, BorderLayout.NORTH);
        allButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.log(Level.INFO, String.format("\n%s\n", "Выбран режим работы с рациональными числами"));
                CalculatorGuiRN calculatorRN = new CalculatorGuiRN(logger);
            }
        });

        JButton newTextButton = new JButton("Комплексные числа");
        newTextButton.setPreferredSize(new Dimension(200, 120));
        jPanel.add(newTextButton, BorderLayout.SOUTH);
        newTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.log(Level.INFO, String.format("\n%s\n", "Выбран режим работы с комплексными числами"));
                CalculatorGuiCN calculatorCN = new CalculatorGuiCN(logger);
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
        jFrame.setTitle("Калькулятор");
        jFrame.setResizable(false);
        return jFrame;
    }

    //установка пользовательского шрифта
    static void setUIFont(javax.swing.plaf.FontUIResource f) {
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put(key, f);
        }
    }
}
