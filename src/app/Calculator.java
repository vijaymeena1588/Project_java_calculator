package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator implements ActionListener {

    double input, result;
    String cal;

    JFrame Frame;
    JLabel label = new JLabel();
    JTextField textView = new JTextField();

    JButton clear = new JButton("c");
    JButton del = new JButton("d");
    JButton div = new JButton("/");
    JButton mul = new JButton("x");

    JButton num7 = new JButton("7");
    JButton num8 = new JButton("8");
    JButton num9 = new JButton("9");
    JButton sub = new JButton("-");

    JButton num4 = new JButton("4");
    JButton num5 = new JButton("5");
    JButton num6 = new JButton("6");
    JButton add = new JButton("+");

    JButton num1 = new JButton("1");
    JButton num2 = new JButton("2");
    JButton num3 = new JButton("3");

    JButton zero = new JButton("0");
    JButton dot = new JButton(".");
    JButton eql = new JButton("=");

    Calculator() {
        CreateInterface();
        InterfaceComponents();
        AddInterfaceEventListner();
    }

    public void CreateInterface() {
        Frame = new JFrame();
        Frame.setTitle("Java Calculator");
        Frame.getContentPane().setLayout(null);
        Frame.setLocationRelativeTo(null);
        Frame.setResizable(false);
        Frame.setSize(305, 400);
        Frame.setVisible(true);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void InterfaceComponents() {
    	//OUTPUT ROW 
    	label.setBounds(240,0,40,40);
    	Frame.add(label);
    	
    	textView.setBounds(10,40,270,60);
    	textView.setEditable(false);
    	textView.setHorizontalAlignment(SwingConstants.RIGHT);
    	Frame.add(textView);
    	
    	// first row
    	clear.setBounds(10,110,60,40);
    	Frame.add(clear);
    	del.setBounds(80,110,60,40);
    	Frame.add(del);
    	div.setBounds(150,110,60,40);
    	Frame.add(div);
    	mul.setBounds(220,110,60,40);
    	Frame.add(mul);
    	
    	// second row
    	num7.setBounds(10,160,60,40);
    	Frame.add(num7);
    	num8.setBounds(80,160,60,40);
    	Frame.add(num8);
    	num9.setBounds(150,160,60,40);
    	Frame.add(num9);
    	sub.setBounds(220,160,60,40);
    	Frame.add(sub);
    	
    	// third row
    	num4.setBounds(10,210,60,40);
    	Frame.add(num4);
    	num5.setBounds(80,210,60,40);
    	Frame.add(num5);
    	num6.setBounds(150,210,60,40);
    	Frame.add(num6);
    	add.setBounds(220,210,60,40);
    	Frame.add(add);
    	
    	// fourth row
    	num1.setBounds(10,260,60,40);
    	Frame.add(num1);
    	num2.setBounds(80,260,60,40);
    	Frame.add(num2);
    	num3.setBounds(150,260,60,40);
    	Frame.add(num3);
    	
    	// fifth row
    	zero.setBounds(10,310,130,40);
    	Frame.add(zero);
    	dot.setBounds(150,310,60,40);
    	Frame.add(dot);
    	eql.setBounds(220,260,60,90);
    	Frame.add(eql);
    
    }
    
    public void AddInterfaceEventListner(){
    	
    	clear.addActionListener(this);
    	del.addActionListener(this);
    	div.addActionListener(this);
    	mul.addActionListener(this);
    	
    	num7.addActionListener(this);
    	num8.addActionListener(this);
    	num9.addActionListener(this);
    	sub.addActionListener(this);
    	
    	num4.addActionListener(this);
    	num5.addActionListener(this);
    	num6.addActionListener(this);
    	add.addActionListener(this);
    	
    	num1.addActionListener(this);
    	num2.addActionListener(this);
    	num3.addActionListener(this);
    	
    	zero.addActionListener(this);
    	dot.addActionListener(this);
    	eql.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();

        if (event == num1) {
            textView.setText(textView.getText() + "1");
        } else if (event == num2) {
            textView.setText(textView.getText() + "2");
        } else if (event == num3) {
            textView.setText(textView.getText() + "3");
        } else if (event == num4) {
            textView.setText(textView.getText() + "4");
        } else if (event == num5) {
            textView.setText(textView.getText() + "5");
        } else if (event == num6) {
            textView.setText(textView.getText() + "6");
        } else if (event == num7) {
            textView.setText(textView.getText() + "7");
        } else if (event == num8) {
            textView.setText(textView.getText() + "8");
        } else if (event == num9) {
            textView.setText(textView.getText() + "9");
        } else if (event == zero) {
            if (!textView.getText().equals("0")) {
                textView.setText(textView.getText() + "0");
            }
        } else if (event == dot) {
            String current = textView.getText();
            String[] parts = current.split("[+\\-x/]");
            String lastPart = parts[parts.length - 1];
            if (!lastPart.contains(".")) {
                textView.setText(current + ".");
            }
        } else if (event == clear) {
            textView.setText("");
            label.setText("");
        } else if (event == del) {
            String text = textView.getText();
            if (!text.isEmpty()) {
                textView.setText(text.substring(0, text.length() - 1));
            }
        } else if (event == add) {
            input = Double.parseDouble(textView.getText());
            cal = "+";
            label.setText(textView.getText() + " + ");
            textView.setText("");
        } else if (event == sub) {
            input = Double.parseDouble(textView.getText());
            cal = "-";
            label.setText(textView.getText() + " - ");
            textView.setText("");
        } else if (event == mul) {
            input = Double.parseDouble(textView.getText());
            cal = "*";
            label.setText(textView.getText() + " x ");
            textView.setText("");
        } else if (event == div) {
            input = Double.parseDouble(textView.getText());
            cal = "/";
            label.setText(textView.getText() + " / ");
            textView.setText("");
        } else if (event == eql) {
            double second = Double.parseDouble(textView.getText());
            double result = 0;

            switch (cal) {
                case "+":
                    result = input + second;
                    break;
                case "-":
                    result = input - second;
                    break;
                case "*":
                    result = input * second;
                    break;
                case "/":
                    if (second != 0) {
                        result = input / second;
                    } else {
                        textView.setText("Error");
                        return;
                    }
                    break;
            }
            textView.setText(String.valueOf(result));
            label.setText("");
        }
    }
    public static void main(String[] args) {
        new Calculator();
    }}
