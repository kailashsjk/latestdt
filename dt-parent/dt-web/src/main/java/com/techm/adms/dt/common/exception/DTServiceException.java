package com.techm.adms.dt.common.exception;

/**
 * This is the exception class to be used in case of any errors caused during
 * processing business logic in whale service or whale ejb bean layer
 * 
 * <p>
 * It extends {@link DTRuntimeException} the base Exception class for Whale
 * application.
 * 
 * @CreatedBy TechM
 * @CreatedOn 07-Oct-2015 10:44:04 am
 */
@SuppressWarnings("serial")
public class DTServiceException extends DTRuntimeException {

    /**
     * Instantiates a new Whale Service exception.
     * 
     * @param message
     *            the message
     * @param exception
     *            {@link Throwable} cause
     * @see RuntimeException#RuntimeException(String, Throwable)
     */
    public DTServiceException(final String message, final Throwable exception) {
        super(message, exception);
    }

    /**
     * Instantiates a new Whale Service exception.
     * 
     * @param message
     *            the message
     * @see RuntimeException#RuntimeException(String)
     */
    public DTServiceException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new Whale Service exception.
     * 
     * @param exception
     *            {@link Throwable} cause
     * @see RuntimeException#RuntimeException(Throwable)
     */
    public DTServiceException(final Throwable exception) {
        super(exception);
    }

}
