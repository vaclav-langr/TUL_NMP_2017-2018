package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * 
 */
public class Calculator {

    public GridPane selection;
    private IController selectedController;
    public TextField operandInput;
    private IControllerFactory factory = new IControllerFactory();

    @FXML
    void initialize() {
        try {
            selectedController = factory.getController("Double");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void numberPressedEvent(ActionEvent actionEvent) {
        String number = ((Button)actionEvent.getSource()).getId();
        operandInput.setText(selectedController.numberPressed(number).toString());
    }

    public void equalPressedEvent(ActionEvent actionEvent) {
        operandInput.setText(selectedController.equalPressed().toString());
    }

    public void dotPressedEvent(ActionEvent actionEvent) {
        operandInput.setText(selectedController.dotPressed().toString());
    }

    public void operationPressedEvent(ActionEvent actionEvent) {
        String operation = ((Button)actionEvent.getSource()).getText();
        try {
            operandInput.setText(selectedController.operationPressed(operation).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}