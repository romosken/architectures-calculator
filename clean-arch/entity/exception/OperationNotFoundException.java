package entity.exception;

public class OperationNotFoundException extends RuntimeException{
    public OperationNotFoundException(){
        super("The operation indicated does not exists!");
    }
}
