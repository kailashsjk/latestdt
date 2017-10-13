package com.techm.adms.dt.common.exception;

/**
 * This is the abstract base exception class for DT application. Every other
 * functionality of the runtime exception.
 * <p>
 * It is defined as a runtime exception so that we are not forced to catch /
 * throw this at every level of the application. However we do need to make sure
 * that we catch exceptions at the highest level so that we can send a proper
 * response to the caller.
 * 
 * @CreatedBy TechM
 * @CreatedOn 07-Oct-2015 10:43:39 am
 */
@SuppressWarnings({"squid:S00118", "serial" })
public abstract class DTRuntimeException extends RuntimeException {

    /**
     * Instantiates a new DT Runtime exception.
     * 
     * @param message
     *            the message
     * @param exception
     *            {@link Throwable} cause
     * @see RuntimeException#RuntimeException(String, Throwable)
     */
    public DTRuntimeException(final String message, final Throwable exception) {
        super(message, exception);
    }

    /**
     * Instantiates a new tS base exception.
     * 
     * @param message
     *            the message
     * @see RuntimeException#RuntimeException(String)
     */
    public DTRuntimeException(final String message) {
        super(message);
    }

    /**
     * @see RuntimeException#RuntimeException(Throwable)
     * @param exception
     *            {@link Throwable} cause
     */
    public DTRuntimeException(final Throwable exception) {
        super(exception);
    }
}
