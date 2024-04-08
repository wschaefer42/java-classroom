package org.example.demospring.common;

import java.util.logging.Logger;

public class Log {
    private static final Logger logger = Logger.getLogger("demo-spring");
    public static void info(String msg, Object... args) {
        logger.info(String.format(msg, args));
    }
}
