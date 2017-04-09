package com.vakhnenko.calculator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.JOptionPane;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {
    //Обьявим переменные
    Calculator parent;
    char selectedAction = ' ';
    double currentResult = 0;

    //Обьявим конструктор
    CalculatorEngine(Calculator parent) {
        //Запомним в переменной this.parent ссылку на Calculator
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {
        //Обьявим переменную типа JButton  и присовим ей значение класса, в котором произошло событие
        JButton clickedButton = (JButton) e.getSource();
        //Получим текущий текст из строки ввода калькулятора и сохраним его в переменной типа String
        String displayFieldText = parent.displayField.getText();
        //Обьявим переменную
        double displayValue = 0;
        //Если дисплей не пустой, запомним его значение в переменной displayValue
        if (!"".equals(displayFieldText)) {
            displayValue = Double.parseDouble(displayFieldText);
        }
        //Получим источник действия и сохраним класс, в котором это действие произошло, в переменной типа Object
        Object src = e.getSource();
        //Проверим какая из служебных кнопок была нажата
        if (src == parent.buttonPlus) {
            //В зависимости от нажатой служебной кнопки ("+", "-", "/", "*"), запомним соотвествующее значение для переменной selectedAction
            selectedAction = '+';
            //Запомним значение переменной displayValue в переменной currentResult
            currentResult = displayValue;
            //Очистим дисплей калькулятора для ввода второго числа
            parent.displayField.setText("");
        } else if (src == parent.buttonMinus) {
            selectedAction = '-';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonDel) {
            selectedAction = '/';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonMnoz) {
            selectedAction = '*';
            currentResult = displayValue;
            parent.displayField.setText("");
            //Проверим была ли нажата кнопка "="
        } else if (src == parent.buttonEqual) {
            //В зависимости от значения переменной selectedAction
            if (selectedAction == '+') {
                //выполним соотвествующее арифметическое действие (в данном случае - сложение)
                currentResult += displayValue;
                //и покажем результат на дисплее
                parent.displayField.setText("" + currentResult);
            } else if (selectedAction == '-') {
                currentResult -= displayValue;
                parent.displayField.setText("" + currentResult);
            } else if (selectedAction == '/') {
                currentResult /= displayValue;
                parent.displayField.setText("" + currentResult);
            } else if (selectedAction == '*') {
                currentResult *= displayValue;
                parent.displayField.setText("" + currentResult);
            }
            //Если нажатая кнопка не является служебной. то
        } else {
            //Получаем значение нажатой кнопки и сохраняем его в переменной clickedButtonLabel
            String clickedButtonLabel = clickedButton.getText();

            // Если символ точка, проверим, есть ли уже в дисплее точки
            if (clickedButtonLabel.equals(".") && displayFieldText.indexOf(".") > 0) {
                ;
            } else {
                //Если нажатая кнопка - цифра, то к тексту, который уже отображен на дисплее, добавляем текст нажатой кнопки
                parent.displayField.setText(displayFieldText + clickedButtonLabel);
            }

		/*
		JOptionPane.showConfirmDialog(null,
				"You pressed " + clickedButtonLabel, "Just a test",
				         JOptionPane.PLAIN_MESSAGE);
				         */
        }
        //Если на дисплее набран "0" и задана функциф "разделить", то
        if ("0".equals(displayFieldText) && selectedAction == '/') {
            //на дисплее высветится текст "На ноль делить нельзя!"
            parent.displayField.setText("На ноль делить нельзя!");
        }
    }
}
