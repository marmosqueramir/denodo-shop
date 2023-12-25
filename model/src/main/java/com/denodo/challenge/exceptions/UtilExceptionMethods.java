package com.denodo.challenge.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.jboss.logging.Logger;

public class UtilExceptionMethods {
    private UtilExceptionMethods() {
        throw new IllegalStateException("Utility class");
    }

    public static void evaluateAndLogRecursiveError(Logger log, Exception e) {
        log.error(e);
        Throwable th = evaluateRecursiveError(e);
        log.error(th.getMessage());
    }

    public static Throwable evaluateRecursiveError(ModelException e) {
        return evaluateRecursiveError(e.getInnerException());
    }

    public static Throwable evaluateRecursiveError(ServiceException e) {
        return evaluateRecursiveError(e);
    }

    public static Throwable evaluateRecursiveError(Exception e) {
        Throwable th = e;
        for (int maxLevels = 10; maxLevels > 0; maxLevels--) {
            if (th.getCause() != null) {
                th = th.getCause();
            } else {
                break;
            }
        }
        return th;
    }

    public static Throwable evaluateRecursiveErrorUntilClass(ModelException e, Class specificClass) {
        return evaluateRecursiveErrorUntilClass(e.getInnerException(), specificClass);
    }

    public static Throwable evaluateRecursiveErrorUntilClass(ServiceException e, Class specificClass) {
        return evaluateRecursiveErrorUntilClass(e, specificClass);

    }

    public static Throwable evaluateRecursiveErrorUntilClass(Exception e, Class specificClass) {
        Throwable th = e;
        if (specificClass != null) {
            for (int maxLevels = 10; maxLevels > 0; maxLevels--) {
                th = th.getCause();
                if (th.getCause() == null || specificClass.isInstance(th)) {
                    break;
                }
            }
        }
        return th;
    }
}
