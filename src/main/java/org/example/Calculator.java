package org.example;

import java.lang.Math;

public class Calculator {                               // Класс калькулятора
    Calculator () { }

    public int getSum (int a, int b) {                  // Сумма
        int sum = 0;
        try {
            sum = Math.addExact(a, b);
        }
        catch (Exception exp)                           // Проверка переполнения
        {
            sum = -1;
        }
        return sum;
    }

    public int getMult (int a, int b) {              // Произведение
        int mult = 0;
        try {
            mult =  Math.multiplyExact(a, b);
        }
        catch (Exception exp)                       // Проверка переполнения
        {
            mult = -1;
        }
        return mult;
    }
}
