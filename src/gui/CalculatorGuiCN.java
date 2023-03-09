package gui;

import constants.CommonConstants;
import service.CalculatorServiceCN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.*;

public class CalculatorGuiCN extends JFrame {

    private static JPanel jPanel = new JPanel();
    private static JTextField displayField;  // поле ввода и вывода

    private static CalculatorServiceCN calculatorService;
    private static Logger logger;

    private static boolean pressedOperator = false;  // флаги
    private static boolean pressedEquals = false;

    JButton buttonD;
    JButton buttonX;
    JButton buttonM;
    JButton buttonP;
    JButton iButton;

    public CalculatorGuiCN(Logger logger) {
        CalculatorGuiCN(logger);
        CalculatorGuiCN.logger = logger;

    }

    public void CalculatorGuiCN(Logger logger) {
        setUIFont(new javax.swing.plaf.FontUIResource("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        Font font2 = new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE);
        JFrame jFrame = getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setBackground(Color.DARK_GRAY);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.location(0, 0);
        jPanel.setLayout(gridBagLayout);
//        buttonPanel.setLayout(gridBagLayout);


        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.gridwidth = 1;
        constraints1.gridheight = 1;
//        constraints1.fill = 4;
//        displayField.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.TEXTFIELD_FONTSIZE));
        displayField.setEditable(false);
//        displayField.setText("");
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        jPanel.add(displayField, constraints1);

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.weightx = 0;
        constraints2.weighty = 0;
        constraints2.gridx = 0;
        constraints2.gridy = 1;
        constraints2.gridwidth = 2;
        constraints2.gridheight = 1;
        constraints2.fill = 2;
        JButton cButton = new JButton(" C");
        cButton.setBackground(Color.lightGray);
        cButton.addActionListener(actionListenerCN);
        jPanel.add(cButton, constraints2);

        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.weightx = 0;
        constraints3.weighty = 0;
        constraints3.gridx = 2;
        constraints3.gridy = 1;
        constraints3.gridwidth = 2;
        constraints3.gridheight = 1;
        constraints3.fill = 2;
        JButton bsButton = new JButton("<<");
        bsButton.setBackground(Color.lightGray);
        bsButton.addActionListener(actionListenerCN);
        jPanel.add(bsButton, constraints3);

        GridBagConstraints constraints4 = new GridBagConstraints();
        constraints4.weightx = 0;
        constraints4.weighty = 0;
        constraints4.gridx = 0;
        constraints4.gridy = 2;
        constraints4.gridwidth = 1;
        constraints4.gridheight = 1;
        constraints4.fill = 1;
        JButton button7 = new JButton("7");
        button7.addActionListener(actionListenerCN);
        jPanel.add(button7, constraints4);

        GridBagConstraints constraints5 = new GridBagConstraints();
        constraints5.weightx = 0;
        constraints5.weighty = 0;
        constraints5.gridx = 1;
        constraints5.gridy = 2;
        constraints5.gridwidth = 1;
        constraints5.gridheight = 1;
        constraints5.fill = 1;
        JButton button8 = new JButton("8");
        button8.addActionListener(actionListenerCN);
        jPanel.add(button8, constraints5);

        GridBagConstraints constraints6 = new GridBagConstraints();
        constraints6.weightx = 0;
        constraints6.weighty = 0;
        constraints6.gridx = 2;
        constraints6.gridy = 2;
        constraints6.gridwidth = 1;
        constraints6.gridheight = 1;
        constraints6.fill = 1;
        JButton button9 = new JButton("9");
        button9.addActionListener(actionListenerCN);
        jPanel.add(button9, constraints6);

        GridBagConstraints constraints7 = new GridBagConstraints();
        constraints7.weightx = 0;
        constraints7.weighty = 0;
        constraints7.gridx = 3;
        constraints7.gridy = 2;
        constraints7.gridwidth = 1;
        constraints7.gridheight = 1;
        constraints7.fill = 1;
        buttonD = new JButton("/");
        buttonD.setBackground(Color.orange);
        buttonD.addActionListener(actionListenerCN);
        jPanel.add(buttonD, constraints7);

        GridBagConstraints constraints8 = new GridBagConstraints();
        constraints8.weightx = 0;
        constraints8.weighty = 0;
        constraints8.gridx = 0;
        constraints8.gridy = 3;
        constraints8.gridwidth = 1;
        constraints8.gridheight = 1;
        constraints8.fill = 1;
        JButton button4 = new JButton("4");
        button4.addActionListener(actionListenerCN);
        jPanel.add(button4, constraints8);

        GridBagConstraints constraints9 = new GridBagConstraints();
        constraints9.weightx = 0;
        constraints9.weighty = 0;
        constraints9.gridx = 1;
        constraints9.gridy = 3;
        constraints9.gridwidth = 1;
        constraints9.gridheight = 1;
        constraints9.fill = 1;
        JButton button5 = new JButton("5");
        button5.addActionListener(actionListenerCN);
        jPanel.add(button5, constraints9);

        GridBagConstraints constraints10 = new GridBagConstraints();
        constraints10.weightx = 0;
        constraints10.weighty = 0;
        constraints10.gridx = 2;
        constraints10.gridy = 3;
        constraints10.gridwidth = 1;
        constraints10.gridheight = 1;
        constraints10.fill = 1;
        JButton button6 = new JButton("6");
        button6.addActionListener(actionListenerCN);
        jPanel.add(button6, constraints10);

        GridBagConstraints constraints11 = new GridBagConstraints();
        constraints11.weightx = 0;
        constraints11.weighty = 0;
        constraints11.gridx = 3;
        constraints11.gridy = 3;
        constraints11.gridwidth = 1;
        constraints11.gridheight = 1;
        constraints11.fill = 1;
        buttonX = new JButton("x");
        buttonX.setBackground(Color.orange);
        buttonX.addActionListener(actionListenerCN);
        jPanel.add(buttonX, constraints11);

        GridBagConstraints constraints12 = new GridBagConstraints();
        constraints12.weightx = 0;
        constraints12.weighty = 0;
        constraints12.gridx = 0;
        constraints12.gridy = 4;
        constraints12.gridwidth = 1;
        constraints12.gridheight = 1;
        constraints12.fill = 1;
        JButton button1 = new JButton("1");
        button1.addActionListener(actionListenerCN);
        jPanel.add(button1, constraints12);

        GridBagConstraints constraints13 = new GridBagConstraints();
        constraints13.weightx = 0;
        constraints13.weighty = 0;
        constraints13.gridx = 1;
        constraints13.gridy = 4;
        constraints13.gridwidth = 1;
        constraints13.gridheight = 1;
        constraints13.fill = 1;
        JButton button2 = new JButton("2");
        button2.addActionListener(actionListenerCN);
        jPanel.add(button2, constraints13);

        GridBagConstraints constraints14 = new GridBagConstraints();
        constraints14.weightx = 0;
        constraints14.weighty = 0;
        constraints14.gridx = 2;
        constraints14.gridy = 4;
        constraints14.gridwidth = 1;
        constraints14.gridheight = 1;
        constraints14.fill = 1;
        JButton button3 = new JButton("3");
        button3.addActionListener(actionListenerCN);
        jPanel.add(button3, constraints14);

        GridBagConstraints constraints15 = new GridBagConstraints();
        constraints15.weightx = 0;
        constraints15.weighty = 0;
        constraints15.gridx = 3;
        constraints15.gridy = 4;
        constraints15.gridwidth = 1;
        constraints15.gridheight = 1;
        constraints15.fill = 1;
        buttonM = new JButton("-");
        buttonM.setBackground(Color.orange);
        buttonM.addActionListener(actionListenerCN);
        jPanel.add(buttonM, constraints15);

        GridBagConstraints constraints16 = new GridBagConstraints();
        constraints16.weightx = 0;
        constraints16.weighty = 0;
        constraints16.gridx = 0;
        constraints16.gridy = 5;
        constraints16.gridwidth = 1;
        constraints16.gridheight = 1;
        constraints16.fill = 1;
        JButton button0 = new JButton("0");
        button0.addActionListener(actionListenerCN);
        jPanel.add(button0, constraints16);

        GridBagConstraints constraints17 = new GridBagConstraints();
        constraints17.weightx = 0;
        constraints17.weighty = 0;
        constraints17.gridx = 1;
        constraints17.gridy = 5;
        constraints17.gridwidth = 1;
        constraints17.gridheight = 1;
        constraints17.fill = 1;
        JButton buttonDot = new JButton(".");
        buttonDot.addActionListener(actionListenerCN);
        jPanel.add(buttonDot, constraints17);

        GridBagConstraints constraints18 = new GridBagConstraints();
        constraints18.weightx = 0;
        constraints18.weighty = 0;
        constraints18.gridx = 2;
        constraints18.gridy = 5;
        constraints18.gridwidth = 1;
        constraints18.gridheight = 1;
        constraints18.fill = 1;
        JButton buttonE = new JButton("=");
        buttonE.setBackground(Color.red);
        buttonE.addActionListener(actionListenerCN);
        jPanel.add(buttonE, constraints18);

        GridBagConstraints constraints19 = new GridBagConstraints();
        constraints19.weightx = 0;
        constraints19.weighty = 0;
        constraints19.gridx = 3;
        constraints19.gridy = 5;
        constraints19.gridwidth = 1;
        constraints19.gridheight = 1;
        constraints19.fill = 1;
        buttonP = new JButton("+");
        buttonP.setBackground(Color.orange);
        buttonP.addActionListener(actionListenerCN);
        jPanel.add(buttonP, constraints19);

        GridBagConstraints constraints20 = new GridBagConstraints();
        constraints20.weightx = 0;
        constraints20.weighty = 0;
        constraints20.gridx = 0;
        constraints20.gridy = 6;
        constraints20.gridwidth = 1;
        constraints20.gridheight = 1;
        constraints20.fill = 1;
        JButton buttonIP = new JButton("+i");
        buttonIP.setBackground(Color.orange);
        buttonIP.addActionListener(actionListenerCN);
        jPanel.add(buttonIP, constraints20);

        GridBagConstraints constraints21 = new GridBagConstraints();
        constraints21.weightx = 0;
        constraints21.weighty = 0;
        constraints21.gridx = 1;
        constraints21.gridy = 6;
        constraints21.gridwidth = 1;
        constraints21.gridheight = 1;
        constraints21.fill = 1;
        JButton buttonIM = new JButton("-i");
        buttonIM.setBackground(Color.orange);
        buttonIM.addActionListener(actionListenerCN);
        jPanel.add(buttonIM, constraints21);

        GridBagConstraints constraints22 = new GridBagConstraints();
        constraints22.weightx = 0;
        constraints22.weighty = 0;
        constraints22.gridx = 3;
        constraints22.gridy = 6;
        constraints22.gridwidth = 1;
        constraints22.gridheight = 1;
        constraints22.fill = 1;
        iButton = new JButton("i");
        iButton.setBackground(Color.orange);
        iButton.addActionListener(actionListenerCN);
        jPanel.add(iButton, constraints22);

        jPanel.revalidate();

    }


    ActionListener actionListenerCN = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonCommand = e.getActionCommand();
            if (buttonCommand.matches("[0-9]")) {
                if (pressedEquals || pressedOperator || displayField.getText().equals(""))
                    displayField.setText(buttonCommand);
                else
                    displayField.setText(displayField.getText() + buttonCommand);

                pressedOperator = false;
                pressedEquals = false;

            } else if (buttonCommand.equals(".")) {
                if (!displayField.getText().contains(".")) {
                    displayField.setText(displayField.getText() + buttonCommand);
                }

            } else if (buttonCommand.equals("+") || buttonCommand.equals("-")
                    || buttonCommand.equals("x") || buttonCommand.equals("/")) {
                buttonD.setBackground(Color.black);
                buttonX.setBackground(Color.black);
                buttonM.setBackground(Color.black);
                buttonP.setBackground(Color.black);
                if (!pressedOperator)
                    calculatorService.setComplex1(displayField.getText());
                calculatorService.setMathSymbol(buttonCommand.charAt(0));
                displayField.setText("");

                pressedOperator = true;
                pressedEquals = false;

            } else if (buttonCommand.equals("=")) {

                calculatorService.setComplex2(displayField.getText());

                String result = "";
                switch (calculatorService.getMathSymbol()) {
                    case '+':
                        result = calculatorService.sumCN();
                        break;
                    case '-':
                        result = calculatorService.subtractCN();
                        break;
                    case '/':
                        result = calculatorService.divideCN();
                        break;
                    case 'x':
                        result = calculatorService.multiplyCN();
                        break;
                }

                // вывод результата в поле
                displayField.setText(result);
                logger.log(Level.INFO, String.format("\n%s %s %s = %s \n",
                        calculatorService.getComplex1(), calculatorService.getMathSymbol(), calculatorService.getComplex2(), result));

                pressedEquals = true;
                pressedOperator = false;

            } else if (buttonCommand.equals("C")) {
                displayField.setText("");

                pressedOperator = false;
                pressedEquals = false;
            } else if (buttonCommand.equals("<<")) {
                int length = displayField.getText().length();
                int num = displayField.getText().length() - 1;

                if (length > 0) {
                    StringBuilder back = new StringBuilder(displayField.getText());
                    back.deleteCharAt(num);
                    displayField.setText(back.toString());
                }
            } else if (buttonCommand.contains("i")) {
                if (buttonCommand.equals("+i")) {
                    displayField.setText(displayField.getText() + " +");
                } else if (buttonCommand.equals("-i")) {
                    displayField.setText(displayField.getText() + " -");
                }
            }
        }

        ;

        public static void setUIFont(javax.swing.plaf.FontUIResource f) {
            java.util.Enumeration keys = UIManager.getDefaults().keys();
            while (keys.hasMoreElements()) {
                Object key = keys.nextElement();
                Object value = UIManager.get(key);
                if (value instanceof javax.swing.plaf.FontUIResource)
                    UIManager.put(key, f);
            }
        }

        static JFrame getFrame() {
            JFrame jFrame = new JFrame() {
            };
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dimension = toolkit.getScreenSize();
            jFrame.setBounds(dimension.width / 2 - 210, dimension.height / 2 - 260, CommonConstants.APP_SIZE[0], CommonConstants.APP_SIZE[1]);
            jFrame.setTitle("Калькулятор комплексных чисел");
            jFrame.setResizable(true);
            return jFrame;
        }


    };

    public static void setUIFont(javax.swing.plaf.FontUIResource f) {
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put(key, f);
        }
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 210, dimension.height / 2 - 260, CommonConstants.APP_SIZE[0], CommonConstants.APP_SIZE[1]);
        jFrame.setTitle("Калькулятор комплексных чисел");
        jFrame.setResizable(false);
        return jFrame;
    }
}