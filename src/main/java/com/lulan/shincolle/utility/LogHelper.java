package com.lulan.shincolle.utility;

import com.lulan.shincolle.reference.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(Reference.MOD_NAME);

    public static void info(Object object) {
        LOGGER.info(String.valueOf(object));
    }

    public static void debug(Object object) {
        LOGGER.debug(String.valueOf(object));
    }

    public static void warn(Object object) {
        LOGGER.warn(String.valueOf(object));
    }

    public static void error(Object object) {
        LOGGER.error(String.valueOf(object));
    }

    public static void fatal(Object object) {
        LOGGER.error("[FATAL] {}", object);
    }

    public static void trace(Object object) {
        LOGGER.trace(String.valueOf(object));
    }
}
