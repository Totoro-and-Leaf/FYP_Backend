package com.fyp.shopingbackend.logging;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;


/**
 * The type Logging util.
 */
@Slf4j
public class LoggingUtil {

    private static Logger unWrapperLogger(Logger logger) {
        Logger result = logger;
        return result;
    }

    /**
     * Info.
     *
     * @param logger  the logger
     * @param message the message
     */
    public static void info(Logger logger, String message) {
        Logger unwrapperLogger = unWrapperLogger(logger);
        if (unwrapperLogger.isInfoEnabled()) {
            unwrapperLogger.info(message);
        }
    }

    /**
     * Info.
     *
     * @param logger   the logger
     * @param template the template
     * @param messages the messages
     */
    public static void info(Logger logger, String template, Object... messages) {
        Logger unwrapperLogger = unWrapperLogger(logger);
        if (unwrapperLogger.isInfoEnabled()) {
            unwrapperLogger.info(template, messages);
        }
    }
}
