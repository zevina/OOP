package gui;

import constants.CommonConstants;
import service.CalculatorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.*;

public class CalculatorGui extends JFrame {
    private final SpringLayout springLayout = new SpringLayout();
    private CalculatorService calculatorService;

    Logger logger;

    private JTextField displayField;  // поле ввода и вывода

    private boolean pressedOperator = false;  // флаги
    private boolean pressedEquals = false;
    private boolean isComplex = false;
    private boolean isI = false;

    JPanel displayFieldPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    JButton switchButton;
    JButton iButton;
    JButton plusButton;
    JButton minusButton;
    JButton buttonD;
    JButton buttonMp;
    JButton buttonMn;
    JButton buttonP;
    JButton buttonE;

    public CalculatorGui(Logger logger) {
        super(CommonConstants.APP_NAME);
        setSize(CommonConstants.APP_SIZE[0], CommonConstants.APP_SIZE[1]);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(springLayout);
        this.logger = logger;

        calculatorService = new CalculatorService();

        addGuiComponents();
    }

    public void addGuiComponents() {
        // добавление поля
        addDisplayFieldComponents();

        // добавление кнопок
        addButtonComponents();
    }

    // добавление поля
    public void addDisplayFieldComponents() {
        displayField = new JTextField(CommonConstants.TEXTFIELD_LENGTH);
        displayField.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.TEXTFIELD_FONTSIZE));
        displayField.setEditable(false);
        displayField.setText("");
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);

        displayFieldPanel.add(displayField);

        this.getContentPane().add(displayFieldPanel);
        springLayout.putConstraint(SpringLayout.NORTH, displayFieldPanel, CommonConstants.TEXTFIELD_SPRINGLAYOUT_NORTHPAD, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.WEST, displayFieldPanel, CommonConstants.TEXTFIELD_SPRINGLAYOUT_WESTPAD, SpringLayout.WEST, this);
    }

    // добавление кнопок
    public void addButtonComponents() {
        GridLayout gridLayout = new GridLayout(CommonConstants.BUTTON_ROWCOUNT, CommonConstants.BUTTON_COLCOUNT);
        buttonPanel.setLayout(gridLayout);

        switchButton = new JButton("RN");
        switchButton.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isComplex) {
                    disableI();
                    buttonPanel.revalidate();
                } else {
                    enableI();
                    buttonPanel.revalidate();
                }
            }
        });
        switchButton.setBackground(Color.green);
        buttonPanel.add(switchButton);

        iButton = new JButton("i");
        iButton.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        iButton.addActionListener(actionListenerCN);
        iButton.setEnabled(false);
        iButton.setBackground(Color.gray);
        buttonPanel.add(iButton);

        JButton cButton = new JButton("C");
        cButton.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText("");

                pressedOperator = false;
                pressedEquals = false;
            }
        });
        cButton.setBackground(Color.lightGray);
        buttonPanel.add(cButton);

        JButton bButton = new JButton("<");
        bButton.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = displayField.getText().length();
                int num = displayField.getText().length() - 1;

                if (length > 0) {
                    StringBuilder back = new StringBuilder(displayField.getText());
                    back.deleteCharAt(num);
                    displayField.setText(back.toString());
                }
            }
        });
        bButton.setBackground(Color.lightGray);
        buttonPanel.add(bButton);

        JButton button7 = new JButton("7");
        button7.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        button7.addActionListener(actionListenerRN);
        buttonPanel.add(button7);

        JButton button8 = new JButton("8");
        button8.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        button8.addActionListener(actionListenerRN);
        buttonPanel.add(button8);

        JButton button9 = new JButton("9");
        button9.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        button9.addActionListener(actionListenerRN);
        buttonPanel.add(button9);

        buttonD = new JButton("/");
        buttonD.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        buttonD.addActionListener(actionListenerRN);
        buttonD.setBackground(Color.orange);
        buttonPanel.add(buttonD);

        JButton button4 = new JButton("4");
        button4.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        button4.addActionListener(actionListenerRN);
        buttonPanel.add(button4);

        JButton button5 = new JButton("5");
        button5.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        button5.addActionListener(actionListenerRN);
        buttonPanel.add(button5);

        JButton button6 = new JButton("6");
        button6.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        button6.addActionListener(actionListenerRN);
        buttonPanel.add(button6);

        buttonMp = new JButton("x");
        buttonMp.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        buttonMp.addActionListener(actionListenerRN);
        buttonMp.setBackground(Color.orange);
        buttonPanel.add(buttonMp);

        JButton button1 = new JButton("1");
        button1.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        button1.addActionListener(actionListenerRN);
        buttonPanel.add(button1);

        JButton button2 = new JButton("2");
        button2.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        button2.addActionListener(actionListenerRN);
        buttonPanel.add(button2);

        JButton button3 = new JButton("3");
        button3.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        button3.addActionListener(actionListenerRN);
        buttonPanel.add(button3);

        buttonMn = new JButton("-");
        buttonMn.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        buttonMn.addActionListener(actionListenerRN);
        buttonMn.setBackground(Color.orange);
        buttonPanel.add(buttonMn);

        JButton button0 = new JButton("0");
        button0.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        button0.addActionListener(actionListenerRN);
        buttonPanel.add(button0);

        JButton buttonDot = new JButton(".");
        buttonDot.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        buttonDot.addActionListener(actionListenerRN);
        buttonPanel.add(buttonDot);

        JButton buttonP = new JButton("+");
        buttonP.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        buttonP.addActionListener(actionListenerRN);
        buttonP.setBackground(Color.orange);
        buttonPanel.add(buttonP);

        buttonE = new JButton("=");
        buttonE.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        buttonE.addActionListener(actionListenerRN);
        buttonE.setBackground(Color.orange);
        buttonPanel.add(buttonE);

        plusButton = new JButton("+i");
        plusButton.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        plusButton.addActionListener(actionListenerRN);
        plusButton.setEnabled(false);
        plusButton.setBackground(Color.gray);
        buttonPanel.add(plusButton);

        minusButton = new JButton("-i");
        minusButton.setFont(new Font("Montserrat", Font.PLAIN, CommonConstants.BUTTON_FONTSIZE));
        minusButton.addActionListener(actionListenerRN);
        minusButton.setEnabled(false);
        minusButton.setBackground(Color.gray);
        buttonPanel.add(minusButton);

        gridLayout.setHgap(CommonConstants.BUTTON_HGAP);
        gridLayout.setVgap(CommonConstants.BUTTON_VGAP);

        this.getContentPane().add(buttonPanel);

        springLayout.putConstraint(SpringLayout.NORTH, buttonPanel, CommonConstants.BUTTON_SPRINGLAYOUT_NORTHPAD, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.WEST, buttonPanel, CommonConstants.BUTTON_SPRINGLAYOUT_WESTPAD, SpringLayout.WEST, this);
    }

    public void enableI() {
        JOptionPane.showMessageDialog(buttonPanel, "Введите действительную и мнимую часть комплексного числа. " +
                "\nЕсли действительной части нет, то введите выражение в формате: 0 + Ni", "Внимание!", JOptionPane.INFORMATION_MESSAGE);

        isComplex = true;
        switchButton.setText("CN");
        iButton.setEnabled(true);
        iButton.setBackground(Color.yellow);
        plusButton.setEnabled(true);
        plusButton.setBackground(Color.yellow);
        minusButton.setEnabled(true);
        minusButton.setBackground(Color.yellow);

        plusButton.addActionListener(actionListenerCN);
        minusButton.addActionListener(actionListenerCN);
        buttonD.addActionListener(actionListenerCN);
        buttonMp.addActionListener(actionListenerCN);
        buttonMn.addActionListener(actionListenerCN);
        buttonP.addActionListener(actionListenerCN);
        buttonE.addActionListener(actionListenerCN);

        buttonPanel.revalidate();

    }

    public void disableI() {
        isComplex = false;
        switchButton.setText("RN");
        iButton.setEnabled(false);
        iButton.setBackground(Color.gray);
        plusButton.setEnabled(false);
        plusButton.setBackground(Color.gray);
        minusButton.setEnabled(false);
        minusButton.setBackground(Color.gray);

        plusButton.addActionListener(actionListenerRN);
        minusButton.addActionListener(actionListenerRN);
        buttonD.addActionListener(actionListenerRN);
        buttonMp.addActionListener(actionListenerRN);
        buttonMn.addActionListener(actionListenerRN);
        buttonP.addActionListener(actionListenerRN);
        buttonE.addActionListener(actionListenerRN);

        buttonPanel.revalidate();

    }

    ActionListener actionListenerRN = new ActionListener() {
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
                if (!pressedOperator)
                    calculatorService.setNum1(Double.parseDouble(displayField.getText()));
                calculatorService.setMathSymbol(buttonCommand.charAt(0));

                pressedOperator = true;
                pressedEquals = false;

            } else if (buttonCommand.equals("=")) {

                calculatorService.setNum2(Double.parseDouble(displayField.getText()));

                double result = 0;
                switch (calculatorService.getMathSymbol()) {
                    case '+':
                        result = calculatorService.sum();
                        break;
                    case '-':
                        result = calculatorService.subtract();
                        break;
                    case '/':
                        result = calculatorService.divide();
                        break;
                    case 'x':
                        result = calculatorService.multiply();
                        break;
                }

                // вывод результата в поле
                displayField.setText(Double.toString(result));
                logger.log(Level.INFO, String.format("\n%f %s %f = %s \n",
                        calculatorService.getNum1(), calculatorService.getMathSymbol(), calculatorService.getNum2(), result));

                pressedEquals = true;
                pressedOperator = false;

            } else if (buttonCommand.equals("C")) {
                displayField.setText("");

                pressedOperator = false;
                pressedEquals = false;
            } else if (buttonCommand.equals("<")) {
                int length = displayField.getText().length();
                int num = displayField.getText().length() - 1;

                if (length > 0) {
                    StringBuilder back = new StringBuilder(displayField.getText());
                    back.deleteCharAt(num);
                    displayField.setText(back.toString());
                }
            }
        }
    };

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
                buttonP.setBackground(Color.black);
                if (!pressedOperator)
                    calculatorService.setComplex1(displayField.getText());
                calculatorService.setMathSymbol(buttonCommand.charAt(0));
                displayField.setText("");
                isI = false;

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
                isI = false;

                pressedOperator = false;
                pressedEquals = false;
            } else if (buttonCommand.equals("<")) {
                int length = displayField.getText().length();
                int num = displayField.getText().length() - 1;

                if (length > 0) {
                    StringBuilder back = new StringBuilder(displayField.getText());
                    back.deleteCharAt(num);
                    displayField.setText(back.toString());
                }
            } else if (buttonCommand.equals("i")) {
                if (!isI) {
                    displayField.setText(displayField.getText() + "i");
                }
                isI = true;
            } else if (buttonCommand.equals("+i")) {
                displayField.setText(displayField.getText() + " +");
            } else if (buttonCommand.equals("-i")) {
                displayField.setText(displayField.getText() + " -");
            }
        }
    };


}