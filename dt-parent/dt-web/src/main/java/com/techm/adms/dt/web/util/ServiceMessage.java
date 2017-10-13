package com.techm.adms.dt.web.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is for creating service message and will send to presentation
 * layer
 * 
 * @param <E>
 * @CreatedBy TechM
 * @CreatedOn 27-Nov-2015 10:49:31 am
 */
public class ServiceMessage<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceMessage.class);

    /**
     * Member variable statusCode for message code
     */
    private final String statusCode;
    /**
     * Member variable statusType for message type like failure or success
     */
    private final String statusType;
    /**
     * Member variable statusMessage for message description
     */
    private final String statusMessage;
    /**
     * Member variable exceptionStackTrace for exception stack trace
     */
    private String exceptionStackTrace;

    /**
     * Member variable exceptionClassName for exception class name
     */
    private String exceptionClassName;

    /**
     * Member variable exceptionMessage for exception message
     */
    private String exceptionMessage;

    /**
     * Member variable objectList
     */
    private List<E> objectList;

    /**
     * Member variable object
     */
    private E object;


    /**
     * @return the statusCode String
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * @return the statusType String
     */
    public String getStatusType() {
        return statusType;
    }

    /**
     * @return the statusMessage String
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * @return the exceptionStackTrace
     */
    public String getExceptionStackTrace() {
        return exceptionStackTrace;
    }

    /**
     * @param exceptionStackTrace
     *            the exceptionStackTrace to set
     */
    public void setExceptionStackTrace(String exceptionStackTrace) {
        this.exceptionStackTrace = exceptionStackTrace;
    }

    /**
     * @return the exceptionClassName
     */
    public String getExceptionClassName() {
        return exceptionClassName;
    }

    /**
     * @param exceptionClassName
     *            the exceptionClassName to set
     */
    public void setExceptionClassName(String exceptionClassName) {
        this.exceptionClassName = exceptionClassName;
    }

    /**
     * @return the exceptionMessage
     */
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    /**
     * @return the objectList
     */
    public List<E> getObjectList() {
        return objectList;
    }

    /**
     * @param objectList
     *            the objectList to set the value in table
     */
    public void setObjectList(List<E> objectList) {
        this.objectList = objectList;
    }

    /**
     * @param exceptionMessage
     *            the exceptionMessage to set
     */
    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
    /**
     * @return the object
     */
    public E getObject() {
        return object;
    }

    /**
     * @param object
     *            the object to set the value in table
     */
    public void setObject(E object) {
        this.object = object;
    }
    
    @SuppressWarnings("all")
    private String toStackTraceString(Throwable exception) {
        Writer result = new StringWriter();
        PrintWriter printWriter = new PrintWriter(result);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Exception To Stack Trace String : " + exception);
            LOGGER.debug(printWriter.toString());
        }
        exception.printStackTrace(printWriter);
        return result.toString();

    }
    
    /**
     * @param statusCode
     * @param statusType
     * @param statusMessage
     * @param exception
     * @param exceptionClassName
     * @param exceptionMessage
     */
    public ServiceMessage(String statusCode, String statusType, String statusMessage, Throwable exception, String exceptionClassName, String exceptionMessage) {
        this.statusCode = statusCode;
        this.statusType = statusType;
        this.statusMessage = statusMessage;
        this.exceptionStackTrace = toStackTraceString(exception);
        this.exceptionClassName = exceptionClassName;
        this.exceptionMessage = exceptionMessage;
    }

    /**
     * @param statusCode
     * @param statusType
     * @param statusMessage
     */
    public ServiceMessage(String statusCode, String statusType, String statusMessage) {
        this.statusCode = statusCode;
        this.statusType = statusType;
        this.statusMessage = statusMessage;
    }
}
