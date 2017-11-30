package sample.modules.DoubleModule;

/**
 * 
 */
public class DoubleSub implements IDoubleOperation {

    @Override
    public Double doOperation(Double val1, Double val2) {
        return val1 - val2;
    }

    @Override
    public boolean isBinary() {
        return true;
    }
}