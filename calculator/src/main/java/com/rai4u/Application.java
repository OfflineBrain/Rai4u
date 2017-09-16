package com.rai4u;

import com.rai4u.sign.Operation;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by user on 15.09.2017.
 */

public class Application {

    Application() {

    }

    void Start() {
        String operation;
        BigDecimal firstValue, secondValue;
        Scanner scan = new Scanner(System.in);
        firstValue = scan.nextBigDecimal();
        operation = scan.next();
        secondValue = scan.nextBigDecimal();
        Operation forCalc = Operation.get(operation);
        System.out.print(firstValue
                + operation
                + secondValue
                + " = "
                + forCalc.calculate(firstValue,secondValue));
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.Start();
    }
}
