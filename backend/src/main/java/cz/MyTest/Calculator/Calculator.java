package cz.MyTest.Calculator;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
    private static JTextField inputBox;

    public static void main(String[] args) {
        createWindow();
    }

    public static void createWindow() {
        // Objekt z classy JFrame
        JFrame frame = new JFrame();
        // Nastavení vypnutí aplikace na křížek:
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Vytvoříme okno a nastavíme:
        createUI(frame);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Calculator");
    }

    public static void createUI(JFrame frame){
        JPanel panel = new JPanel();
        Calculator calculator = new Calculator();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(layout);

        inputBox = new JTextField(10);
        inputBox.setEditable(false);

        JButton btn_0 = new JButton("0");JButton btn_1 = new JButton("1");
        JButton btn_2 = new JButton("2");JButton btn_3 = new JButton("3");
        JButton btn_4 = new JButton("4");JButton btn_5 = new JButton("5");
        JButton btn_6 = new JButton("6");JButton btn_7 = new JButton("7");
        JButton btn_8 = new JButton("8");JButton btn_9 = new JButton("9");

        JButton btn_Plus = new JButton("+");JButton btn_Minus = new JButton("-");
        JButton btn_Multiply = new JButton("*");JButton btn_Devide = new JButton("/");
        JButton btn_Dot = new JButton(".");JButton btn_Clear = new JButton("C");
        JButton btn_Equals = new JButton("=");

        btn_0.addActionListener(calculator);btn_1.addActionListener(calculator);
        btn_2.addActionListener(calculator);btn_3.addActionListener(calculator);
        btn_4.addActionListener(calculator);btn_5.addActionListener(calculator);
        btn_6.addActionListener(calculator);btn_7.addActionListener(calculator);
        btn_8.addActionListener(calculator);btn_9.addActionListener(calculator);

        btn_Plus.addActionListener(calculator);btn_Minus.addActionListener(calculator);
        btn_Multiply.addActionListener(calculator);btn_Devide.addActionListener(calculator);
        btn_Dot.addActionListener(calculator);btn_Clear.addActionListener(calculator);
        btn_Equals.addActionListener(calculator);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        gbc.gridx = 0;gbc.gridy = 0;panel.add(inputBox, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 0;gbc.gridy = 1;panel.add(btn_1, gbc);
        gbc.gridx = 1;gbc.gridy = 1;panel.add(btn_2, gbc);
        gbc.gridx = 2;gbc.gridy = 1;panel.add(btn_3, gbc);
        gbc.gridx = 3;gbc.gridy = 1;panel.add(btn_Plus, gbc);
        gbc.gridx = 0;gbc.gridy = 2;panel.add(btn_4, gbc);
        gbc.gridx = 1;gbc.gridy = 2;panel.add(btn_5, gbc);
        gbc.gridx = 2;gbc.gridy = 2;panel.add(btn_6, gbc);
        gbc.gridx = 3;gbc.gridy = 2;panel.add(btn_Minus, gbc);
        gbc.gridx = 0;gbc.gridy = 3;panel.add(btn_7, gbc);
        gbc.gridx = 1;gbc.gridy = 3;panel.add(btn_8, gbc);
        gbc.gridx = 2;gbc.gridy = 3;panel.add(btn_9, gbc);
        gbc.gridx = 3;gbc.gridy = 3;panel.add(btn_Multiply, gbc);
        gbc.gridx = 0;gbc.gridy = 4;panel.add(btn_Dot, gbc);
        gbc.gridx = 1;gbc.gridy = 4;panel.add(btn_0, gbc);
        gbc.gridx = 2;gbc.gridy = 4;panel.add(btn_Clear, gbc);
        gbc.gridx = 3;gbc.gridy = 4;panel.add(btn_Equals, gbc);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.charAt(0) == 'C') {                      
           inputBox.setText("");
        }else if (command.charAt(0) == '=') {                    
           inputBox.setText(evaluate(inputBox.getText()));
        }else {                                
           inputBox.setText(inputBox.getText() + command);
        }
     }
   
     public static String evaluate(String expression) {
        char[] arr = expression.toCharArray();
        String operand1 = "";String operand2 = "";String operator = "";
        double result = 0;

        for (int i = 0; i < arr.length; i++) {
           if (arr[i] >= '0' && arr[i] <= '9' || arr[i] == '.') {
              if(operator.isEmpty()){
                 operand1 += arr[i];
              }else{
                 operand2 += arr[i];
              }
           }  
  
           if(arr[i] == '+' || arr[i] == '-' || arr[i] == '/' || arr[i] == '*') {
              operator += arr[i];
           }
        }
  
        if (operator.equals("+"))
           result = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
        else if (operator.equals("-"))
           result = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
        else if (operator.equals("/"))
           result = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
        else
           result = (Double.parseDouble(operand1) * Double.parseDouble(operand2));          
        return operand1 + operator + operand2 + "=" +result;
     }    
}