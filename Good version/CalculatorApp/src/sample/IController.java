package sample;

import java.util.*;

/**
 * 
 */
public abstract class IController<T> {

    protected IOperation selectedOperation;
    protected String lastOperand, currentOperand;
    protected boolean dotFlag = false;

    public abstract T numberPressed(String number);
    public abstract T operationPressed(String operation) throws Exception;
    public abstract T dotPressed();
    public abstract T equalPressed();
}