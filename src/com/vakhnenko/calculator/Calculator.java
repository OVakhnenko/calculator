package com.vakhnenko.calculator;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    JPanel windowContent;
    JFormattedTextField displayField;

    //JButton[] numButtons= new JButton[10];

    JButton button0;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;

    JButton buttonPoint;

    JButton buttonEqual;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonMnoz;
    JButton buttonDel;

    JPanel p1;
    JPanel p2;

    int counter;

    Calculator() {
        windowContent = new JPanel();
        BorderLayout bl = new BorderLayout();

        windowContent.setLayout(bl);
        displayField = new JFormattedTextField();
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setColumns(30);
        windowContent.add("North", displayField);
               /*
	    	   for (counter=0; counter < 10; counter++){
	    		   numButtons[counter] = new JButton (Integer.toString(counter));
	    	   }
	    	   */
	    	   /*
	    	   numButtons[0] = new JButton (Integer.toString(0));
	    	   numButtons[1] = new JButton (Integer.toString(1));
	    	   ...
	    	   numButtons[9] = new JButton (Integer.toString(9));
	    	   */

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonMnoz = new JButton("*");
        buttonDel = new JButton("/");
        p1 = new JPanel();
        GridLayout gl = new GridLayout(4, 3);
        p1.setLayout(gl);
	    	   /*
	    	   for (counter=0; counter < 10; counter++){
	    		  p1.add(numButtons[counter]);
	    	   }
	    	   */
	    	   /*
	    	   p1.add(numButtons[0]);
	    	   p1.add(numButtons[1]);
	    	   ...
	    	   p1.add(numButtons[9]);
	    	   */

        p1.add(button0);
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(button7);
        p1.add(button8);
        p1.add(button9);

        p1.add(buttonPoint);
        p1.add(buttonEqual);
        windowContent.add("Center", p1);
        p2 = new JPanel();
        GridLayout gr = new GridLayout(4, 3);
        p2.setLayout(gr);
        p2.add(buttonPlus);
        p2.add(buttonMinus);
        p2.add(buttonMnoz);
        p2.add(buttonDel);
        windowContent.add("East", p2);
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);
        frame.pack();
        frame.setVisible(true);

        CalculatorEngine calcEngine = new CalculatorEngine(this);

        button0.addActionListener(calcEngine);
        button1.addActionListener(calcEngine);
        button2.addActionListener(calcEngine);
        button3.addActionListener(calcEngine);
        button4.addActionListener(calcEngine);
        button5.addActionListener(calcEngine);
        button6.addActionListener(calcEngine);
        button7.addActionListener(calcEngine);
        button8.addActionListener(calcEngine);
        button9.addActionListener(calcEngine);
        buttonPlus.addActionListener(calcEngine);
        buttonMinus.addActionListener(calcEngine);
        buttonMnoz.addActionListener(calcEngine);
        buttonDel.addActionListener(calcEngine);
        buttonPoint.addActionListener(calcEngine);
        buttonEqual.addActionListener(calcEngine);
        // numButtons [counter].addActionListener(calcEngine);

    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
}
