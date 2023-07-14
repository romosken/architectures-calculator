package adapter;

import entity.exception.OperationNotFoundException;
import usecase.Calculator;
import usecase.CalculatorRequest;

import java.util.Scanner;

public class ConsoleCalculatorController{
    private final Calculator calculator;

    public ConsoleCalculatorController(Calculator calculator){
        this.calculator = calculator;
    }

    public void initConsoleCalculator() throws InterruptedException{
        var in = new Scanner(System.in);
        String operation = getInputString(in, "Input the operation symbol desired:");

        var num1 = getInputNumber(in, "Input the first number:");
        var num2 = getInputNumber(in, "Input the second number:");

        showResult(num1, num2, operation);
        Thread.sleep(500);

        verifyIfWantsAnotherCalculation(in);
    }

    private void verifyIfWantsAnotherCalculation(Scanner in) throws InterruptedException{
        var again = getInputString(in, "Do you want to calculate again?");
        if (again.contains("n"))
            return;
        initConsoleCalculator();
    }

    private String getInputString(Scanner in, String message){
        exhibitMessage(message);
        return in.next();
    }

    private void exhibitMessage(String message){
        System.out.println(message);
    }

    private double getInputNumber(Scanner in, String message){
        exhibitMessage(message);
        return in.nextDouble();
    }

    private void showResult(Double num1, Double num2, String operation){
        try{
            var calculatorRequest = new CalculatorRequest(num1, num2, operation);
            var result = calculator.calculate(calculatorRequest);
            exhibitMessage("Your operation result is: " + result + "\n");
        } catch (OperationNotFoundException e){
            exhibitMessage(e.getMessage());
        }
    }


}
