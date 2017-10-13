/**
 * 
 */
package com.techm.adms.dt.web.util;

import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJBException;

/**
 * <Comments Here>
 * 
 * @CreatedBy TechM
 * @CreatedOn 07-Oct-2015 10:34:28 am
 */
public final class ServiceMessageHandler {

    /**
     * Member variable MESSAGE_BUNDLE
     */
    public static final ResourceBundle MESSAGE_BUNDLE = ResourceBundle.getBundle("dt-service-serviceMessages");

    /**
     * private constructor
     */
    private ServiceMessageHandler() {

    }

    /**
     * @param messageCode
     * @param exception
     * @return
     */
    public static ServiceMessage prepareMessage(final String messageCode, final Throwable exception) {
        ServiceMessage serviceMessage;
        Throwable exceptionOrCause = (exception instanceof EJBException) ? exception.getCause() : exception;
        String message = exceptionOrCause.getMessage();
        Class exceptionClass = exceptionOrCause.getClass();

        if (messageCode.startsWith(ServiceConstants.ERROR_TYPE)) {
            serviceMessage = new ServiceMessage(messageCode, ServiceConstants.MESSAGE_TYPE_FAIL, MESSAGE_BUNDLE.getString(messageCode), exception, exceptionClass.getSimpleName(), message);
        } else {
            serviceMessage = new ServiceMessage(messageCode, ServiceConstants.MESSAGE_TYPE_SUCCESS, MESSAGE_BUNDLE.getString(messageCode));
        }

        return serviceMessage;

    }

    /**
     * @param <E>
     * @param key
     * @param object
     * @return ServiceMessage
     */
    public static <E> ServiceMessage prepareMessage(final String key, final E object) {
        ServiceMessage serviceMessage;

        if (key.startsWith(ServiceConstants.ERROR_TYPE)) {
            serviceMessage = new ServiceMessage(key, ServiceConstants.MESSAGE_TYPE_FAIL, MESSAGE_BUNDLE.getString(key));
        } else {
            serviceMessage = new ServiceMessage(key, ServiceConstants.MESSAGE_TYPE_SUCCESS, MESSAGE_BUNDLE.getString(key));
        }
        serviceMessage.setObject(object);
        return serviceMessage;
    }

    /**
     * @param key
     * @return
     */
    public static <E> ServiceMessage prepareMessage(final String key) {
        ServiceMessage serviceMessage;

        if (key.startsWith(ServiceConstants.ERROR_TYPE)) {
            serviceMessage = new ServiceMessage(key, ServiceConstants.MESSAGE_TYPE_FAIL, MESSAGE_BUNDLE.getString(key));
        } else {
            serviceMessage = new ServiceMessage(key, ServiceConstants.MESSAGE_TYPE_SUCCESS, MESSAGE_BUNDLE.getString(key));
        }

        return serviceMessage;
    }

    /**
     * @param <E>
     * @param messageCode
     * @param objectList
     *            - List of Object
     * @return
     */
    public static <E> ServiceMessage prepareMessage(final String messageCode, final List<E> objectList) {
        ServiceMessage serviceMessage;

        if (messageCode.startsWith(ServiceConstants.ERROR_TYPE)) {
            serviceMessage = new ServiceMessage(messageCode, ServiceConstants.MESSAGE_TYPE_FAIL, MESSAGE_BUNDLE.getString(messageCode));
        } else {
            serviceMessage = new ServiceMessage(messageCode, ServiceConstants.MESSAGE_TYPE_SUCCESS, MESSAGE_BUNDLE.getString(messageCode));
        }
        serviceMessage.setObjectList(objectList);
        return serviceMessage;
    }

}
