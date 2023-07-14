package usecase;

import entity.Operation;

public class SimpleCalculator implements Calculator{
    public Double calculate(CalculatorRequest request){
        var operation = getOperation(request.getOperationSymbol());
        return operation.execute(request.getNum1(), request.getNum2());
    }

    private Operation getOperation(String operationSymbol){
        return Operation.create(operationSymbol);
    }
}
