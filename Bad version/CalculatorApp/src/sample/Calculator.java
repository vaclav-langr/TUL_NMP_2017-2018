package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

public class Calculator {

    public TextField operandInput;
    private Float lastOperand = null;
    private Operation selectedOperation;
    private boolean dotFlag = false;

    public void numberPressed(ActionEvent actionEvent) {
        if(operandInput.getText().equals("NaN")) {
            operandInput.setText("");
        }
        String stringId = ((Control)actionEvent.getSource()).getId();
        operandInput.setText(operandInput.getText() + stringId);
    }

    private Float doOperation() {
        if(lastOperand == null) {
            return 0.0f;
        }
        if(operandInput.getText().equals("")) {
            return Float.NaN;
        }
        Float result = lastOperand;
        switch (selectedOperation) {
            case Add:
                result += Float.parseFloat(operandInput.getText());
                break;
            case Sub:
                result -= Float.parseFloat(operandInput.getText());
                break;
            case Multiply:
                result *= Float.parseFloat(operandInput.getText());
                break;
            case Divide:
                if(Float.parseFloat(operandInput.getText()) == 0.0) {
                    return Float.NaN;
                }
                result /= Float.parseFloat(operandInput.getText());
                break;
        }
        return result;
    }

    public void equalTrigger() {
        Float value = doOperation();
        operandInput.setText(value.toString());
        dotFlag = false;
        lastOperand = null;
    }

    public void dotTrigger() {
        if(!dotFlag) {
            dotFlag = true;
            operandInput.setText(operandInput.getText() + ".");
        }
    }

    public void divide() {
        if(lastOperand == null) {
            lastOperand = Float.parseFloat(operandInput.getText());
        } else {
            if(operandInput.getText().length() > 0) {
                lastOperand = doOperation();
            }
        }
        dotFlag = false;
        operandInput.setText("");
        selectedOperation = Operation.Divide;
    }

    public void multiply() {
        if(lastOperand == null) {
            lastOperand = Float.parseFloat(operandInput.getText());
        } else {
            if(operandInput.getText().length() > 0) {
                lastOperand = doOperation();
            }
        }
        dotFlag = false;
        operandInput.setText("");
        selectedOperation = Operation.Multiply;
    }

    public void sub() {
        if(lastOperand == null) {
            if(operandInput.getText().length() > 0) {
                lastOperand = Float.parseFloat(operandInput.getText());
            } else {
                lastOperand = 0.0f;
            }
        } else {
            lastOperand = doOperation();
        }
        dotFlag = false;
        operandInput.setText("");
        selectedOperation = Operation.Sub;
    }

    public void add() {
        if(lastOperand == null) {
            lastOperand = Float.parseFloat(operandInput.getText());
        } else {
            if(operandInput.getText().length() > 0) {
                lastOperand = doOperation();
            }
        }
        dotFlag = false;
        operandInput.setText("");
        selectedOperation = Operation.Add;
    }
}
