package org.example;

import java.lang.Math;

public class Calculator {                               // Класс калькулятора

    public int getSum (int a, int b) {                  // Сумма
        return a + b;
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
