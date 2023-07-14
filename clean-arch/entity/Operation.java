package entity;

import entity.exception.OperationNotFoundException;

import java.util.stream.Stream;

public enum Operation{
    SUM("+"){
        public Double execute(Double num1, Double num2){
            return num1 + num2;
        }
    },
    SUBTRACTION("-"){
        public Double execute(Double num1, Double num2){
            return num1 - num2;
        }
    },
    MULTIPLICATION("*"){
        public Double execute(Double num1, Double num2){
            return num1 * num2;
        }
    },
    DIVISION("/"){
        public Double execute(Double num1, Double num2){
            return num1 / num2;
        }
    };

    Operation(String symbol){
        this.symbol = symbol;
    }

    public final String symbol;

    public abstract Double execute(Double num1, Double num2);

    public static Operation create(String symbol){
        return Stream.of(Operation.values())
                .filter(op -> op.symbol.equalsIgnoreCase(symbol))
                .findFirst()
                .orElseThrow(OperationNotFoundException::new);
    }
}
