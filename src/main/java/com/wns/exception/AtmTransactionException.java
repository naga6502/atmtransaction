package com.wns.exception;

public class AtmTransactionException extends Exception{
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    
    /**
     * will do IvueTimeException.
     */
    public AtmTransactionException() {
        super();
    }
    
    /**
     * Constructor that allows a specific error message to be specified.
     *
     * @param message
     *            the detail message.
     */
    public AtmTransactionException(String message) {
        super(message);
    }

    /**
     * Constructor that allows a specific error message to be specified.
     *
     * @param message
     *            the detail message.
     */
    public AtmTransactionException(String message,Exception e) {
        super(message,e);
    }


}
