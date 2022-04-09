package com.example.neo_calculator;

import com.example.neo_calculator.controller.CalculatorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NeoCalculatorApplicationTests {

    private final double delta = 1e-9;
    private String result;
    private final CalculatorController controller = new CalculatorController();

    @Test
    void divisionByZero() {
        result = controller.getResult("1", "0", "div");
        Assertions.assertEquals("division by zero", result);
    }

    @Test
    void division() {
        result = controller.getResult("17", "22", "div");
        double d = Double.parseDouble(result);
        Assertions.assertEquals(0.772727273, d, delta);
    }

    @Test
    void addition() {
        result = controller.getResult("17", "22", "add");
        Assertions.assertEquals("39.0", result);
    }

    @Test
    void subtraction() {
        result = controller.getResult("17", "22", "sub");
        Assertions.assertEquals("-5.0", result);
    }

    @Test
    void multiplication() {
        result = controller.getResult("17.48", "22.33", "mul");
        Assertions.assertEquals("390.3284", result);
    }


    @Test
    void nullParameters() {
        result = controller.getResult(null, "22.33", "mul");
        Assertions.assertEquals("Request parameters cannot be null", result);
    }

    @Test
    void wrongAction() {
        result = controller.getResult("17", "22.33", "asb");
        Assertions.assertEquals("Incorrect action", result);
    }

    @Test
    void textInsteadNumbers() {
        result = controller.getResult("17ddd", "22.33", "div");
        Assertions.assertEquals("Try to calculate only numbers", result);
    }
}
