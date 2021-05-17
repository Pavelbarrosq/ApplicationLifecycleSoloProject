package com.example.springdocker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathCalcTest {

    MyMathCalc calc;

    @BeforeEach
    public void beforeMethod() {
        calc = new MyMathCalc();
    }

    @Test
    void add() {
        int expected = 10;
        int actual = calc.add(5,5);

        assertEquals(expected, actual);
    }

    @Test
    void multiply() {
        int expected = 20;
        int actual = calc.multiply(4, 5);

        assertEquals(expected, actual);
    }

    @Test
    void divide() {
        double expected = 2.5;
        double actual = calc.divide(5, 2);

        assertEquals(expected, actual);
    }

    @DisplayName("Instance method divide will throw Error")
    @Test
    void divideThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> calc.divide(-5, 3));
    }
}