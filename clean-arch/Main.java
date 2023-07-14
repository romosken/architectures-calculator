import adapter.ConsoleCalculatorController;
import usecase.SimpleCalculator;

public class Main{
    public static void main(String[] args) throws InterruptedException{
        var calculator = new SimpleCalculator();
        var controller = new ConsoleCalculatorController(calculator);
        controller.initConsoleCalculator();

    }
}
