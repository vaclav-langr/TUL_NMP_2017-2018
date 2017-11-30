package sample;

import sample.modules.DoubleModule.DoubleController;

/**
 * 
 */
public class IControllerFactory {

    /**
     * @param type 
     * @return
     */
    public IController getController(String type) throws Exception {
        switch (type) {
            case "Double":
                return new DoubleController();
            default:
                throw new Exception("Type not found");
        }
    }

}