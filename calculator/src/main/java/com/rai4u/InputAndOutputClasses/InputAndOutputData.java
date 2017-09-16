package com.rai4u.InputAndOutputClasses;

import com.rai4u.sign.Operation;


import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by user on 16.09.2017.
 */
public class InputAndOutputData {
    private Scanner scan;

    private BigDecimal firstValue, secondValue;

    private String typeOfOperation;

    private int exitFromApp = 0;

    public InputAndOutputData() {
        scan = new Scanner(System.in);
    }

    public void readData() {
        firstValue = scan.nextBigDecimal();
        typeOfOperation = scan.next();
        secondValue = scan.nextBigDecimal();
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public void printFinalExample(Operation forChooseOperation) {
        System.out.print(firstValue
                + typeOfOperation
                + secondValue
                + " = "
                + forChooseOperation.calculate(firstValue, secondValue));
    }

    public void exitCondition() {
        System.out.println("\n" +
                "Do you want to finish the job?"
                + "\n"
                + "0 - Yes 1 - No");
        exitFromApp = scan.nextInt();
    }

    public int getExitFromApp() {
        return exitFromApp;
    }


}
