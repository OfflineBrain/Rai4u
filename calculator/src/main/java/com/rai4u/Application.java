package com.rai4u;

import com.rai4u.InputAndOutputClasses.InputAndOutputData;
import com.rai4u.sign.Operation;

/**
 * Created by user on 15.09.2017.
 */

public class Application {
    Application() {

    }

    public static void main(String[] args) {
        Application app = new Application();
        app.Start();
    }

    private void createUI(InputAndOutputData Data) {
        do {
            Data.readData();
            Operation forCalc = Operation.get(Data.getTypeOfOperation());
            if(forCalc == null){
                break;
            }
            Data.printFinalExample(forCalc);
            Data.exitCondition();
        } while (Data.getExitFromApp() == 1);
    }

    void Start() {
        InputAndOutputData Data = new InputAndOutputData();
        createUI(Data);
    }
}
