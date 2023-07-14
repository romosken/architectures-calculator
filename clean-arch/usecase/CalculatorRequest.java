package usecase;

public class CalculatorRequest{
    private Double num1;
    private Double num2;
    private String operationSymbol;

    public Double getNum1(){
        return num1;
    }

    public CalculatorRequest(Double num1, Double num2, String operationSymbol){
        this.num1 = num1;
        this.num2 = num2;
        this.operationSymbol = operationSymbol;
    }

    public Double getNum2(){
        return num2;
    }

    public String getOperationSymbol(){
        return operationSymbol;
    }
}
