package sample.modules.DoubleModule;

import sample.IOperation;

/**
 * 
 */
public class DoubleOperationFactory {

    public IOperation getOperation(String name) throws Exception {
        switch (name) {
            case "+":
                return new DoubleAdd();
            case "-":
                return new DoubleSub();
            case "*":
                return new DoubleMultiply();
            case "/":
                return new DoubleDivide();
            default:
                throw new Exception("Unknwon operation");
        }
    }

}