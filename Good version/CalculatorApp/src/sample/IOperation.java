package sample;

import java.util.*;

/**
 * 
 */
public interface IOperation<T> {


    /**
     * @param val1 
     * @param val2 
     * @return
     */
    public T doOperation(T val1, T val2);

    /**
     * @return
     */
    public boolean isBinary();

}