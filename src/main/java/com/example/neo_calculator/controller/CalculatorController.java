package com.example.neo_calculator.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/calc")
    public String getResult(@RequestParam(name = "a", required = false) String a,
                            @RequestParam(name = "b", required = false) String b,
                            @RequestParam(name = "action", required = false) String action) {
        if (a == null || b == null || action == null) {
            return "Request parameters cannot be null";
        } else {
            Double x = 0d;
            Double y = 0d;
            try {
                x = Double.parseDouble(a);
                y = Double.parseDouble(b);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return "Try to calculate only numbers";
            }

            String result;
            switch (action) {
                case "add":
                    result = String.valueOf(x + y);
                    break;
                case "sub":
                    result = String.valueOf(x - y);
                    break;
                case "mul":
                    result = String.valueOf(x * y);
                    break;
                case "div":
                    if (y == 0) {
                        result = "division by zero";
                    } else {
                        result = String.valueOf(x / y);
                    }
                    break;
                default:
                    result = "Incorrect action";
            }
            return result;
        }
    }
}
