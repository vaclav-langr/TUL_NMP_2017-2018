package sample.modules.DoubleModule;

import sample.IController;
import sample.IOperation;

public class DoubleController extends IController<Double> {

    private DoubleOperationFactory factory = new DoubleOperationFactory();

    public DoubleController() {
        lastOperand = "0.0";
        currentOperand = null;
    }

    @Override
    public Double numberPressed(String number) {
        if(currentOperand == null) {
            currentOperand = number;
        } else {
            currentOperand += number;
        }
        return Double.parseDouble(currentOperand);
    }

    @Override
    public Double operationPressed(String operation) throws Exception {
        IOperation<Double> next = factory.getOperation(operation);
        dotFlag = false;
        if(selectedOperation == null) {
            if (next.isBinary()) {
                selectedOperation = next;
                lastOperand = currentOperand;
                currentOperand = null;
            } else {
                currentOperand = ((IDoubleOperation) next).doOperation(Double.parseDouble(currentOperand), null).toString();
            }
        } else {
            if(next.isBinary()) {
                lastOperand = ((IDoubleOperation) selectedOperation).doOperation(Double.parseDouble(lastOperand), Double.parseDouble(currentOperand)).toString();
                selectedOperation = next;
                currentOperand = null;
            } else {
                currentOperand = ((IDoubleOperation) next).doOperation(Double.parseDouble(currentOperand), null).toString();
                selectedOperation = null;
            }
        }
        if(lastOperand == null) {
            lastOperand = "0.0";
        }
        return Double.parseDouble(lastOperand);
    }

    @Override
    public Double dotPressed() {
        if(currentOperand == null) {
            currentOperand = "0";
        }
        if(!dotFlag) {
            currentOperand += ".";
            dotFlag = true;
        }
        return Double.parseDouble(currentOperand);
    }

    @Override
    public Double equalPressed() {
        if(currentOperand == null) {
            currentOperand = "0.0";
        }
        if(selectedOperation == null) {
            return Double.parseDouble(currentOperand);
        }
        Double last = Double.parseDouble(lastOperand);
        Double current = Double.parseDouble(currentOperand);
        Double result = ((IDoubleOperation)selectedOperation).doOperation(last, current);
        selectedOperation = null;
        lastOperand = "0.0";
        currentOperand = null;
        dotFlag = false;
        return result;
    }
}