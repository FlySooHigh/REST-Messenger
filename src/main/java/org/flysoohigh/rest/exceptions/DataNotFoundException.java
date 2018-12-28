package org.flysoohigh.rest.exceptions;

/**
 * Created on 28.12.2018.
 */
public class DataNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 413632966943505058L;

    public DataNotFoundException(String message) {
        super(message);
    }
}
